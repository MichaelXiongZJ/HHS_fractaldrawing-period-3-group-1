import java.awt.Color;

import processing.core.PApplet;
import shrivastava.shapes.Line;

public class SierpinskiTriangle extends FractalDrawing {

	private Coordinates pointA, pointB, pointC;

	public SierpinskiTriangle(int level, double length, Coordinates pointA, Coordinates pointB, Coordinates pointC) 
	{
		super(level, length);
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
	}

	public void draw(PApplet marker) 
	{
//		drawSierpinskiTriangle(marker, pointA, pointB, pointC, level); // this method cannot use length but otherwise works
		drawSierpinskiTriangle(marker, pointA, pointB, pointC, level, length); 
	}

	private void drawSierpinskiTriangle(PApplet marker, Coordinates pointA, Coordinates pointB, Coordinates pointC, int level, double length)
	{
		if(level < 1)
		{
			Line[] triangle = new Line[3];
			triangle[0] = new Line (pointA.getX(), pointA.getY(), -60, length, true);
			triangle[1] = new Line(triangle[0].getX2(), triangle[0].getY2(), 60, length, true);
			triangle[2] = new Line(pointA.getX(), pointA.getY(), 0, length, true);
			
			for(Line l : triangle)
			{
				l.draw(marker);
			}
			return;
		}
		
			Coordinates pointAB = getMidPoint(pointA,length, -60);
			Coordinates pointBC = getMidPoint(pointB,length, 60);
			Coordinates pointAC = getMidPoint(pointA,length, 0);
			
			drawSierpinskiTriangle(marker, pointA, pointAB, pointAC, level-1, length/2);
			drawSierpinskiTriangle(marker, pointAB, pointB, pointBC, level-1, length/2);
			drawSierpinskiTriangle(marker, pointAC, pointBC, pointC, level-1, length/2);
	}
	
	private Coordinates getMidPoint(Coordinates pointA, double length, int angle)
	{
		Line l = new Line(pointA.getX(), pointA.getY(), angle, length, true);
	return  getMidPoint(new Coordinates((float)l.getX(),(float) l.getY()), new Coordinates((float)l.getX2(), (float)l.getY2())) ;
	}
	
//	doesnt use length but has fill color 
	private void drawSierpinskiTriangle(PApplet marker, Coordinates pointA, Coordinates pointB, Coordinates pointC, int level)
	{
		if(level < 1)
		{
			marker.fill((float)Math.random() * 255,(float)Math.random() * 255, (float)Math.random() * 255);
			marker.stroke((float)Math.random() * 255,(float)Math.random() * 255, (float)Math.random() * 255);
			marker.triangle(pointA.getX(), pointA.getY(), pointB.getX(), pointB.getY(), pointC.getX(), pointC.getY());
			
			return;
		}
		
			Coordinates pointAB = getMidPoint(pointA,pointB);
			Coordinates pointBC = getMidPoint(pointB,pointC);
			Coordinates pointAC = getMidPoint(pointA,pointC);
			
			drawSierpinskiTriangle(marker, pointA, pointAB, pointAC, level-1);
			drawSierpinskiTriangle(marker, pointAB, pointB, pointBC, level-1);
			drawSierpinskiTriangle(marker, pointAC, pointBC, pointC, level-1);
	}

	private Coordinates getMidPoint(Coordinates pointA, Coordinates pointB) 
	{
		float midX = (pointA.getX() + pointB.getX()) / 2;
		float midY = (pointA.getY() + pointB.getY()) / 2;
		return new Coordinates(midX, midY);
	}
	
	
}

import processing.core.PApplet;

public class SierpinskiTriangle extends FractalDrawing{

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
		
		drawSierpinskiTriangle(marker, pointA, pointB, pointC, level);
	}

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
		float midY = (pointA.getY() + pointB.getY())/2;
		return new Coordinates(midX, midY);
	}
}

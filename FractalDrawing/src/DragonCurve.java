import processing.core.PApplet;

public class DragonCurve extends FractalDrawing{
	private double r = 1.0/Math.sqrt(2.0);
	public DragonCurve(int level, double length) {
		super(level, length);
	}

	public void draw(PApplet marker) {
		
	}
	
	private void drawDragonCurve(PApplet marker, int level, double length, double angle, double x, double y) {
		if(level<1) {
			marker.line((float)(x), (float)y, 
    				(float)(x+length*Math.cos(Math.toRadians(angle))), (float)(y-length*Math.sin(Math.toRadians(angle))));
		}
		else {
			drawDragonCurve(marker,level-1,length*r,45,x,y);
		}
	}

}

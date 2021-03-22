import processing.core.PApplet;

public class DragonCurve extends FractalDrawing{
	private double r = 1.0/Math.sqrt(2.0);
	public DragonCurve(int level, double length) {
		super(level, length);
	}

	public void draw(PApplet marker) {
		drawDragonCurve(marker,level,length,0,100,100,true);
	}
	
	private void drawDragonCurve(PApplet marker, int level, double length, double angle, double x, double y,boolean popsRight) {
		if(level<1) {
			marker.line((float)(x), (float)y, 
    				(float)(x+length*Math.cos(Math.toRadians(angle))), (float)(y-length*Math.sin(Math.toRadians(angle))));
		}
		else {
			if(popsRight) {
				drawDragonCurve(marker,level-1,length*r,angle-45,x,y,true);
				drawDragonCurve(marker,level-1,length*r,angle+45
						,x+length*r*Math.cos(Math.toRadians(angle-45)),y-length*r*Math.sin(Math.toRadians(angle-45)),false);
			}
			else {
				drawDragonCurve(marker,level-1,length*r,angle+45,x,y,true);
				drawDragonCurve(marker,level-1,length*r,angle-45
						,x+length*r*Math.cos(Math.toRadians(angle+45)),y-length*r*Math.sin(Math.toRadians(angle+45)),false);
			}
			
		}
	}

}

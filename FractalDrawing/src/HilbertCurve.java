import processing.core.PApplet;

public class HilbertCurve extends FractalDrawing{

	private double xLoc;
	private double yLoc;
	
	public HilbertCurve(int level, double length) {
		super(level, length);
		xLoc = 100;
		yLoc = 100;
	}

	
	public void draw(PApplet marker) {
		drawHilbertCurve(marker, xLoc, yLoc, super.length, super.level, 0);
	}
	
	private void drawHilbertCurve(PApplet marker, double x, double y, double length, int level, double angle) {
		if(angle >= 360) {
			angle -= 360;
		}
		if(level < 1) {
			drawCup(marker, x, y, length, level, angle);
		}else {
			length = length*3/2;
			if(angle == 0) {
				drawHilbertCurve(marker, x , y , length/3, level - 1, angle + 90);
				drawHilbertCurve(marker, x, y+2*length/3, length/3, level - 1, angle);
				drawHilbertCurve(marker, x+2*length/3, y+2*length/3 , length/3, level - 1, angle);
				drawHilbertCurve(marker, x+2*length/3 , y, length/3, level - 1, angle + 270);
			}else if(angle == 90) {
				drawHilbertCurve(marker, x , y , length/3, level - 1, angle - 90);
				drawHilbertCurve(marker, x+2*length/3, y, length/3, level - 1, angle);
				drawHilbertCurve(marker, x+2*length/3, y+2*length/3 , length/3, level - 1, angle);
				drawHilbertCurve(marker, x, y+2*length/3, length/3, level - 1, angle + 90);
			}else if(angle == 180) {
				drawHilbertCurve(marker, x , y , length/3, level - 1, angle);
				drawHilbertCurve(marker, x+2*length/3, y, length/3, level - 1, angle);
				drawHilbertCurve(marker, x, y+2*length/3 , length/3, level - 1, angle - 90);
				drawHilbertCurve(marker, x+2*length/3, y+2*length/3, length/3, level - 1, angle + 90);
			}else if(angle == 270) {
				drawHilbertCurve(marker, x+2*length/3 , y , length/3, level - 1, angle + 90);
				drawHilbertCurve(marker, x, y, length/3, level - 1, angle-180);
				drawHilbertCurve(marker, x, y+2*length/3, length/3, level - 1, angle-180);
				drawHilbertCurve(marker, x+2*length/3, y+2*length/3, length/3, level - 1, angle - 90);
			}
		}
	}
	
	private void drawCup(PApplet marker, double x, double y, double length, int level, double angle){
		if(angle == 0 || angle == 360) {
			marker.line((float)x, (float)y, (float)x, (float)(y+length));
			marker.line((float)x, (float)(y+length), (float)(x+length), (float)(y+length));
			marker.line((float)(x+length), (float)(y+length), (float)(x+length), (float)y);
		}else if(angle == 90) {
			marker.line((float)x, (float)y, (float)(x+length), (float)y);
			marker.line((float)(x+length), (float)y, (float)(x+length), (float)(y+length));
			marker.line((float)x, (float)(y+length), (float)(x+length), (float)(y+length));
		}else if(angle == 180) {
			marker.line((float)x, (float)y, (float)x, (float)(y+length));
			marker.line((float)x, (float)y, (float)(x+length), (float)y);
			marker.line((float)(x+length), (float)y, (float)(x+length), (float)(y+length));
		}else if(angle == 270){
			marker.line((float)(x+length), (float)(y+length), (float)x, (float)(y+length));
			marker.line((float)x, (float)(y+length), (float)x, (float)y);
			marker.line((float)x, (float)y, (float)(x+length), (float)y);
		}
	}
}


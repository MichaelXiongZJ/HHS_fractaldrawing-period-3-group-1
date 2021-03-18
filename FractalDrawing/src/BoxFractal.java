import processing.core.PApplet;

public class BoxFractal extends FractalDrawing {
	
	double x = 100;
	double y = 100;

	public BoxFractal(int level, double length) {
		super(level, length);
	}

	public BoxFractal(int level, double length, double x, double y) {
		super(level, length);
		this.x = x;
		this.y = y;
	}
	
	public void draw(PApplet marker) {
		drawFractal(marker, level, length, x, y);
	}
	
	private void drawFractal(PApplet p, int level, double length, double x, double y) {
		if (level < 1) {
			p.rect((float)x, (float)y, (float)length, (float)length);
		} else {
			drawFractal(p, level-1, length/3, x, y);
			drawFractal(p, level-1, length/3, x + 2*length/3, y);
			drawFractal(p, level-1, length/3, x + length/3, y + length/3);
			drawFractal(p, level-1, length/3, x, y + 2*length/3);
			drawFractal(p, level-1, length/3, x + 2*length/3, y + 2*length/3);
		}
	}

}

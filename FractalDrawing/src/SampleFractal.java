import processing.core.PApplet;
import processing.core.PConstants;

public class SampleFractal extends FractalDrawing {

	public SampleFractal(int level, int length) {
        super(level,length);
    }
	

    public void draw(PApplet marker) {

    	marker.fill(0);
    	marker.textSize(Math.max(super.getLevel(), 1));
    	marker.text("This is a sample class to show how to add your own fractal to the menu.", 20, marker.height-(int)super.getLength());
    	
    }
    
    
    /*
     * 
     * Your class would need to have a private recursive method in it that performs all the fractal drawing. 
     * This private method would be called by the public draw() method.
     * 
     * 
     */

	
}



import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Main {
	
	public static void main(String args[]) {
		// Once you have a fractal class, remove my "SampleFractals" and add your fractal object to this list:
		FractalDrawing[] choices = { new SampleFractal (20,15), new DragonCurve (2,30), new BoxFractal (4,400) }; 
		
		
		
		FractalDrawing input = (FractalDrawing)JOptionPane.showInputDialog(null, "Which fractal would you like to draw?",
	        "Which Fractal?", JOptionPane.QUESTION_MESSAGE, null,
	        choices, // Array of choices
	        choices[0]); // Initial choice
	    
		if (input == null)
			return;
		
		
		DrawingSurface drawing = new DrawingSurface(input);
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();

		window.setSize(800, 600);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
		canvas.requestFocus();
	}

}

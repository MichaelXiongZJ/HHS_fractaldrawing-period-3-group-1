import processing.core.PApplet;

public abstract class FractalDrawing {

	protected int level;
	protected double length;
	
	
	public FractalDrawing(int level, double length)
	{
		this.level = level;
		this.length = length;
	}
	
	

	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public double getLength() {
		return length;
	}


	public void setLength(double length) {
		this.length = length;
	}
	
	
	public abstract void draw(PApplet marker);
	
	public String toString() {
		String name = this.getClass().getName();
		for (int i = 0; i < name.length(); i++)
			if (Character.isUpperCase(name.charAt(i))) {
				name = name.substring(0,i) + " " + name.substring(i);
				i++;
			}
		return name;
	}
	
}

package point;

public class Point {
	// Fields (also called instance variables)
	private double x;
	private double y;
	
	// The x and y parameters go away after the Point
	// constructor has completed. To store them we use
	// the fields and the keyword this to make the
	// distinction between the parameters and the fields.
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	// A point can tell you its x and y values
	public double getX() { return x; }
	public double getY() { return y; }
	
	// A Point can tell you how far it is from another Point
	public double distance(Point p) {
		return Math.sqrt((p.x - x) * (p.x - x) + (p.y - y) * (p.y - y));
	}
	
	// If a Point is printed, its toString method is used
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}

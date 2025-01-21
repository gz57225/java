package Point;

public class Main {
	public static void main(String[] args) {
		Point p = new Point(0,0);
		Point q = new Point(3,4);
		System.out.println("The distance from " + p + " to " + q + 
				" is " + p.distance(q));
	}

}
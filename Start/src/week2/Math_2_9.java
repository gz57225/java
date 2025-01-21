package week2;
import java.util.Random;

public class Math_2_9 {

	public static void main(String[] args) {
		System.out.println("abs -10 ====> " + Math.abs(-10));
		System.out.println("4^-0.5 ====> " + Math.pow(4, -0.5));
		System.out.println("sqrt 100 ====> " + Math.sqrt(100));
		System.out.print("random [0, 1) ====> ");
		for (int i = 0; i <= 10; i++) System.out.print(Math.random() + " ");
		System.out.println();
		
		
		Random random = new Random();
		System.out.println("BOOLEAN: " + random.nextBoolean());
		System.out.println("INT: " + random.nextInt());
		System.out.println("DOUBLE: " + random.nextDouble());

	}

}

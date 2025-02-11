package week6;

import java.util.Scanner;

public class While_Loops_4_1 {

	public static void main(String[] args) {
		whileLoopTest();
	}
	
	private static void whileLoopTest() {
		// While Loops
		Scanner scan = new Scanner(System.in);
		System.out.println("Input 1 or 0 again & again.");
		while (scan.nextInt() != Math.round(Math.random())) {
			System.out.println("WRONG!");	
		}
		System.out.println("GOOD JOB!");
	}

}

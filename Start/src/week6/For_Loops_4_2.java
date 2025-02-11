package week6;

import java.util.Scanner;

public class For_Loops_4_2 {

	public static void main(String[] args) {
		System.out.println("Input any numbers!");
		Scanner scan = new Scanner(System.in);
		for (int i = 0; scan.nextInt() < i; i++) {
			System.out.println("[i = " + i + "]!");
		}
		System.out.println("FINISHED!");

	}

}

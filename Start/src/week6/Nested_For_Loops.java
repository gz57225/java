package week6;

import java.util.Scanner;

public class Nested_For_Loops {

	public static void main(String[] args) {
		System.out.print("Please input a integer positive number: ... ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

package week6;

public class ASCII_With_Loops {

	public static void main(String[] args) {
		PrintAsciiBetween('A', 'Z');
		PrintAsciiBetween('a', 'z');
		PrintAsciiBetween('Z', 'a');
	}
	
	private static void PrintAsciiBetween(int l, int r) {
		int /* char */ ch = l;
		for (; ch <= r; ch++) {
			System.out.println("[Letter " + (char) ch + " : " + ch + "]");
		}
	}

}

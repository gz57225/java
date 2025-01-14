package week1;

public class DataType_1_3 {

	public static void main(String[] args) {
		System.out.println("print primitive: ");
		printPrimitive();
	}

	private static void printPrimitive() {
		int i1 = 10086;
		int i2 = 0xFFF;
		System.out.println("int\t" + i1);
		System.out.println("\t" + i2);
		
		double d1 = 1.52;
		System.out.println("double\t" + d1);
		System.out.println("\t" + 0.792);
		
		boolean b1 = false;
		System.out.println("boolean\t" + b1);
		System.out.println("\t" + true);
		
		char c1 = '-';
		System.out.println("char\t" + c1);
		System.out.println("\t" + 'g');
	}
}

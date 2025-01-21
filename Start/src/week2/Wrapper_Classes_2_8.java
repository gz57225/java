package week2;

public class Wrapper_Classes_2_8 {

	public static void main(String[] args) {
		System.out.println("==============================");	
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE - 1);
        System.out.println(Integer.MAX_VALUE + 1);
        
        System.out.println("==============================");
        int i = Integer.MAX_VALUE;
        System.out.println("MAX_VALUE + 1 ====> " + (i + 1));
        Integer wrapped_i = i;
        System.out.println("MAX_VALUE (wrapped class) + 1 ====> " + (wrapped_i + 1));
        System.out.println("MAX_VALUE of int casting to byte ====> " + (byte) Integer.MAX_VALUE);
        
        System.out.println("==============================AUTOBOXING / UNBOXING");
        System.out.println("Assign int to wrapped double ====> ERROR");
//      Double wrapped_d = 100;
        System.out.println("Assign int to unwrapped double ====> GOOD JOB");
        double d = 100;
        System.out.println("d = " + d);
        
        
	}

}

package week2;

import java.util.Date;

public class Strings_2_7 {

	public static void main(String[] args) {
		System.out.println("Compare \"abc\" and \"abcd\" = " + "abc".compareTo("abcd"));
		System.out.println("Compare \"abc\" and \"abd\" = " + "abc".compareTo("aaa"));
		
		System.out.println("==============================");
		System.out.println("'This4is7a9funny5fuzzy1bunny'.idxOf 'ny' = " + "This is a funny fuzzy bunny".indexOf("ny"));

		System.out.println("==============================");
		System.out.println(" 'A' == 'a'? ====> " + "A".equals("a"));
		System.out.println(" 'A' == 'a'? (no matter case) ====> " + "A".equalsIgnoreCase("a"));
		System.out.println(" 'A' == Date? ====> " + "A".equals(new Date()));
		System.out.println("\tWarning: Unlikely argument type for equals(): Date seems to be unrelated to String");
		
		System.out.println("==============================");
		System.out.println(" 'abcde'.subStr 1,1 ====> (LEFT" + "abcde".substring(1,1) + "RIGHT) [EMPTY]");
		System.out.println(" 'abcde'.subStr 1,2 ====> " + "abcde".substring(1,2));
		System.out.println(" 'abcde'.subStr 1 ====> " + "abcde".substring(1));

		System.out.println("==============================");
		String test1 = "$$$-Animal_Farm";
		System.out.println(test1 + " ends with \\0? ====> " + test1.endsWith("\0"));
		System.out.println(test1 + " ends with Farm? ====> " + test1.endsWith("Farm"));
		
		System.out.println("==============================");
		System.out.println("length of " + test1 + " is ... ====> " + test1.length());
	}

}

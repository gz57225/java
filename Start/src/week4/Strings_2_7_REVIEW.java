package week4;

public class Strings_2_7_REVIEW {

	public static void main(String[] args) {
		String s = new String("They don't know how");
		// Substring
		System.out.println(s.substring(0, 4)); // They
		System.out.println(s.substring(7, 8)); // n
		// indexOf
		System.out.println(s.indexOf("They")); // 0
		System.out.println(s.indexOf("ow")); // 13
		System.out.println(s.indexOf("how")); // 16
		// length
		System.out.println(s.length()); // 19
		// compareTo
		System.out.println(s.compareTo("They don't know AAA")); // 39
		System.out.println(s.compareTo("They don't know ZZZ")); // 14
		System.out.println(s.compareTo("They don't know zzz")); // -18
		System.out.println(s.compareTo("They don't know how")); // 0
		// equals
		System.out.println(s.equals("They don't know how")); // true
		System.out.println(s.equals("They don't know AAA")); // false
		// toLower/UpperCase
		System.out.println(s.toLowerCase()); // they don't know how
		System.out.println(s.toUpperCase()); // THEY DON'T KNOW HOW
		// charAt
		System.out.println(s.charAt(0)); // T
		System.out.println(s.charAt(s.length() - 1)); // T

	}

}

package week1;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Casting_1_6 {
	public static final void main(String[] args) {
		// Unicode
		// Standard Output: A.
        System.out.println("\u0041");
        System.out.println(new String(Character.toChars(0x0041)));
        System.out.println((char) 0x0041);
        
        // Standard Output: A smiling yellow face.
        System.out.println(new String(Character.toChars(0x1F600)));
        System.out.println((char) 0x1F600); // Not working (Because out of range[0, 0xFFFF]).
        
        System.out.println("================= DIVISION LINE ===============");
        
        // Text Formation
        double number = 10.0 / 3;
        System.out.println(number);
        System.out.printf("%.2f", number); // format number to show 2 digits after .
        System.out.printf("$%.2f\n", number); // format also with $ and newline
        System.out.printf("%.2f\n", 2./3); // Print out the result of 2.0/3 formatted to show 2 digits after the decimal point.
        
        System.out.printf("%,.5f\n", 123456789.123456789);
        System.out.printf(Locale.FRANCE, "%,.5f\n", 123456789.123456789);
        System.out.printf(Locale.GERMANY, "%,.5f\n", 123456789.123456789);
        
        
        Date now = new Date();

        // Generic Chinese
        DateFormat dfChinese = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINESE);
        System.out.println("Chinese Locale: " + dfChinese.format(now)); // Generic Chinese formatting
        
        // China-specific Chinese
        DateFormat dfChina = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
        System.out.println("China Locale: " + dfChina.format(now)); // China-specific formatting
        
        System.out.println("Normal Date: " + now);
        

        
	}
}

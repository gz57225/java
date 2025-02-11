package week6;

import java.util.ArrayList;

public class Loops_And_Strings {

	public static void main(String[] args) {
		ArrayList<String> arr = stringSeperator("I love you awa. Please love me!", " ");
		for (String e : arr) {
			System.out.print(e + '\t');
		}
	}
	
	private static ArrayList<String> stringSeperator(String str, String sign) {
		ArrayList<String> arr = new ArrayList<String>();
		int curr_idx = 0;
		while (true) {
			int target_idx = str.indexOf(sign, curr_idx);
			if (target_idx == -1) {
				if (curr_idx != str.length() - 1) {
					arr.add(str.substring(curr_idx, str.length()));
				}
				break;
			}
			arr.add(str.substring(curr_idx, target_idx));
			curr_idx = target_idx + sign.length();
		}
		return arr;
	}

}

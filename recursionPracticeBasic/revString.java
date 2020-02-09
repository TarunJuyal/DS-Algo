package recursionPracticeBasic;

import java.util.Scanner;

public class revString {
	 public static void main(String[] args) {
	        String str;
	        System.out.println("Enter your string: ");
	        Scanner scanner = new Scanner(System.in);
	        str = scanner.nextLine();
	        String reversed = reverseString(str);
	        System.out.println("The reversed string is: " + reversed);
	    }

	    public static String reverseString(String str)
	    {
	        if (str.isEmpty())
	            return str;
	        return reverseString(str.substring(1)) + str.charAt(0);
	    }
}

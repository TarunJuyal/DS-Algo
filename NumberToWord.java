package recursionAdvance;

//work for numbers<=99999. 

import java.util.Scanner;

public class NumberToWord {
	static String ones[] = {"", "one ", "two ", "three ", "four ", 
	        "five ", "six ", "seven ", "eight ", 
	        "nine ", "ten ", "eleven ", "twelve ", 
	        "thirteen ", "fourteen ", "fifteen ", 
	        "sixteen ", "seventeen ", "eighteen ", 
	        "nineteen "
	    }; 
	    static String tens[] = {"", "", "twenty ", "thirty ", "forty ", 
	        "fifty ", "sixty ", "seventy ", "eighty ", 
	        "ninety "
	    };
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int number;
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter a number: ");
		number=scanner.nextInt();
		System.out.println(convertToWords(number));
		
	}
	 static String convertToWords(int n) { 
         String result = "";    
         result += numToWords(((n / 1000) % 100), "thousand ");   
         result += numToWords(((n / 100) % 10), "hundred "); 
       if (n > 100 && n % 100 > 0) { 
    	   result += "and "; 
        }   
       result += numToWords((int) (n % 100), ""); 
  return result; 
    }   
	static String numToWords(int n, String s) { 
        String str = ""; 
          if (n > 19) { 
            str += tens[n / 10] + ones[n % 10]; 
        } else { 
            str += ones[n]; 
        }   
        if (n != 0) { 
            str += s; 
        }
  
        return str; 
    }
}
	



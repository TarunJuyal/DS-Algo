package anagramStringApproches;

/**approach is to find sum of ascii values of characters in each string and then if they are equal then string is anagram else not anagram**/

public class anagramString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   anagramCheck("abcde","bedac");
	}
   public static void anagramCheck(String str1,String str2) {
	if(str1.length()==str2.length()) {
   int sumStr1=0,sumStr2=0;
   for(int i=0;i<str1.length();i++) {
	  sumStr1+=str1.charAt(i);
	  sumStr2+=str2.charAt(i);
   }
   System.out.println(sumStr1);
   System.out.println(sumStr2);
   if(sumStr1==sumStr2)
	   System.out.println("String is Anagram");
   else
	   System.out.println("Strings not Anagram");
   }
   else 
		System.out.println("Strings not Anagram");
	
   }
}

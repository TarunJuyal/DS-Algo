package recursionPracticeBasic;

public class palindromeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcdcba";
		if(findPalindrome(s, 0, s.length()-1))
			System.out.println("Palindrome String");
		else
			System.out.println("Not Palindrome");
	}
	public static boolean findPalindrome(String s, int first,int last) {
		if(first==last)
			return true;
		char a[]=s.toCharArray();
		if(a[first]!=a[last])
			return false;
		return findPalindrome(s,first+1, last-1);
		
	}
}

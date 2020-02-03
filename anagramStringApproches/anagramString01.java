package anagramStringApproches;

import java.util.Arrays;

//sort and compare

public class anagramString01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      anagramCheck("abcde","bcad");
      
	}
	public static void anagramCheck(String str1,String str2) {
		if(str1.length()!=str2.length()) {
			System.out.println("Strings not anagram");
			return;
		}
		char arr[]=str1.toCharArray();
		char arr2[]=str2.toCharArray();
		Arrays.sort(arr);
		Arrays.sort(arr2);
		for(int i=0;i<str1.length();i++) {
			if(arr[i]!=arr2[i]) {
				System.out.println("Strings not anagram");
				return;
			}
			}
		System.out.println("Strings are anagram");
	}

}

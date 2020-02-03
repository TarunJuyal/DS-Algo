package anagramStringApproches;

//using hashing

public class anagramString02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 anagramCheck("silent","listen");
	}
	public static void anagramCheck(String str1,String str2) {
		if(str1.length()!=str2.length()) {
			System.out.println("Strings not anagram");
			return;
		}
		char arr[]=str1.toCharArray();
		char arr2[]=str2.toCharArray();
		int hash1 [] = new int[255];
		int hash2[] = new int[255];
		for(int i = 0 ; i<arr.length; i++) {
			++hash1[arr[i]];
			++hash2[arr2[i]];
		}
		for(int i = 0; i<hash1.length; i++) {
			if(hash1[i]!=hash2[i]) {
				System.out.println("Not Anagram String");
				return ;
			}
		}
		System.out.println("Anagram String");

}
}

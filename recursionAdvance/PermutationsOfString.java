package recursionAdvance;

import java.util.ArrayList;

public class PermutationsOfString {
	
	public static ArrayList<String> permutations(String str){
		if(str.length()==0) {
			ArrayList<String> emptyString=new ArrayList<>();
			emptyString.add("");
			return emptyString;
		}
		char currentChar=str.charAt(0);
		ArrayList<String> result=new ArrayList<>();
		ArrayList<String> temp=permutations(str.substring(1));
		for(String s :temp) {
			for(int i=0;i<=s.length();i++) {
				StringBuffer string=new StringBuffer(s);
				string.insert(i, currentChar);
				result.add(string.toString());
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(permutations("abc"));
	}

}

package recursionAdvance;

import java.util.ArrayList;

public class SubSequenceOfString {

	public static ArrayList<String> subSequence(String s){
		if(s.length()==0) {
			ArrayList<String> emptyString=new ArrayList<>();
			emptyString.add("");
			return emptyString;
		}
		char currentChar=s.charAt(0);
		ArrayList<String> result=new ArrayList<>();
		ArrayList<String> temp=subSequence(s.substring(1));
		for(String str :temp) {
			result.add(str);
			result.add(currentChar+str);
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(subSequence("abc"));
	}

}

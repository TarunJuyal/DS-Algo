package backtracking;

//given an string and a dictionary we have to form a meaning full sentence from given string. 

public class WordBreakerProblem {
  static boolean inDictionary(String word) {
	  String dictionary[]= {"Hello","i","am","datastructure","learning"};
	  for(String s:dictionary)
		  if(s.equals(word))
			  return true;
	  return false;
  }
	static String breakWord(String str) {
		return wordBreak(str,"");
	}
	static String wordBreak(String str,String result) {
		for(int i=1;i<=str.length();i++) {
			String word=str.substring(0,i);
			if(inDictionary(word)) {
				if(i==str.length()) {
					result+=word;
					return result;
				}
			  return wordBreak(str.substring(i,str.length()),result+word+" ");
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="Helloiamlearningdatastructure";
		System.out.println("Meaning full sentence is: "+breakWord(str));
	}

}

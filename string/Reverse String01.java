package string;

public class ReverseSentence {
	static String reverseWords(String s) {
		int i=0; 
		System.out.println(s);
		if(s.length()==0)
			return "";
		while(s.charAt(i)!=' '||i==s.length()) {
			i++;
			if(i==s.length())
				break;
		}
		System.out.println("i is: "+i+"word is: "+s.substring(0, i));
		if(i==s.length()){
			return reverseWords(s.substring(i))+" "+ s.substring(0, i);
		}
		else
			return  reverseWords(s.substring(i+1))+" "+ s.substring(0, i);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="I love java";
		System.out.println(reverseWords(s));
	}

}

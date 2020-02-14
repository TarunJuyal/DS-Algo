package recursionPracticeBasic;

public class RemoveCharFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcdabcdabcdabcda";
		System.out.println(s);
		System.out.println("Remove all a's");
        System.out.println(remove(s,'a'));
        System.out.println("Remove all b's");
        System.out.println(remove1(s, 'b'));
	}
	
	//Removing using Substring
	public static String remove(String s,char c) {
		if(s.length()==0)
			return s;
		if(s.charAt(0)==c) {
			return remove(s.substring(1), c);
		}
		return s.charAt(0)+remove(s.substring(1), c);
			
	}
	
	//Removing using a new string.
    
	public static String remove1(String s,char c) {
		if(s.length()==0) {
			return "";
			}
		String str ="";
		if(s.charAt(0)!=c) {
		  str+=s.charAt(0);
		}
		return str+remove1(s.substring(1), c);
			
	}

}

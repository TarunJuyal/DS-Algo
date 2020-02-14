package recursionPracticeBasic;

public class ReplaceCharFromString {

	public static void main(String[] args) {
		System.out.println(replace("Hello".toCharArray(), 'l', 'w'));

	}

   public static String replace(char str[], char c, char alt) {
		if(str.length==0) {
			return "";
		}
		String s = "";
		if(str[0]==c) {
			str[0] = alt;
			
		}
		s = new String(str);
		
		return  str[0] + replace(s.substring(1).toCharArray(), c, alt);
		
	}
	
}

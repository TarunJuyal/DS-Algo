package string;

public class CheckRotation {
	
	public static boolean areRotations(String s1,String s2) {
		if(s1==null || s2==null || s1.length()!=s2.length())
			return false;
		String s=s2;
		for(int i=0;i<s1.length();i++) {
			String str=rotate(s);
			if(s1.equals(str))
				return true;
			s=str;
		}
		return false;
		
	}
	private static String rotate(String s) {
		char c[]=s.toCharArray();
		reverseArray(c, 1);
		reverseArray(c, 0);
		StringBuilder str=new StringBuilder();
		for(char ch:c)
			str.append(ch);
		return str.toString();
	}
	private static void reverseArray(char c[],int start) {
		for(int i=start,j=c.length-1;i<=j;i++,j--) {
			char ch=c[i];
			c[i]=c[j];
			c[j]=ch;
		}
	} 

	public static boolean areRotation(String s1,String s2) {
		if(s1==null || s2==null)
			return false;
		return (s1.length()==s2.length() && (s1+s1).contains(s2));
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(areRotation("ABCD", "CDAB"));
		System.out.println(areRotations("ABCD", "DABC"));
	}

}

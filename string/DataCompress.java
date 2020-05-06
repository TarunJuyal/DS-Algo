package string;

public class DataCompress {
	static String compressData(String s) {
		String out="";
		int count=1;
		for(int i=0;i<s.length()-1;i++) {
			if(s.charAt(i)==s.charAt(i+1))
				count++;
			else {
				out=out+s.charAt(i)+count;
				count=1;
			}
		}
		out=out+s.charAt(s.length()-1)+count;
		return out;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="aaaabbcccddefff";
		System.out.println("Compressed data is: "+compressData(s));
	}

}

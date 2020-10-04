package string;

public class CapitalizeFirstWord {

	public static String capitalize(String s) {
		if(s==null || s.trim().isEmpty())
			return "";
		String[] words=s.trim().replaceAll(" +", " ").split(" ");
		for(int i=0;i<words.length;i++)
			words[i]=words[i].substring(0,1).toUpperCase()+words[i].substring(1).toLowerCase();
		return String.join(" ", words);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(capitalize("Trees are beautiful"	));
	}

}

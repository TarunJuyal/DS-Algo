package hashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeatingandRepeatingCharacter {
	
	public static char findFirstNonRepeating(String str) {
		Map<Character, Integer> map=new HashMap<>();
		char[] chars=str.toCharArray();
		for(char i:chars) {
			int count=map.containsKey(i)?map.get(i):0;
			map.put(i, count+1);
		}
		for(char i:chars) {
			if(map.get(i)==1) {
				return i;
			}
		}
		return Character.MIN_VALUE;
	}
	
	public static char findFirstRepeating(String str) {
		Set<Character> set=new HashSet<>();
		char[] chars=str.toCharArray();
		for(char i:chars) {
			if(set.contains(i))
				return i;
			set.add(i);
		}
		return Character.MIN_VALUE;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("First Non Repeating Character is: "+findFirstNonRepeating("a green apple"));
		System.out.println("First Repeating Character is: "+findFirstRepeating("green apple"));
	}

}

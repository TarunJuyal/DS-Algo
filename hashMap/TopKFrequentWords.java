package hashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentWords {
	static void approach1(int topK) {
		String words[]= {"i","love","i","leetcode","i","love","coding"};
		Map<String, Integer> map=new HashMap<>();
		for(String word:words) {
			map.put(word, map.getOrDefault(word, 0)+1);
		}
		ArrayList<String> keyList=new ArrayList<>(map.keySet());
		Collections.sort(keyList,(first,second)->map.get(second).compareTo(map.get(first)));
		System.out.println("Top "+topK+" frequent words are: "+keyList.subList(0, topK));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		approach1(2);
	}

}

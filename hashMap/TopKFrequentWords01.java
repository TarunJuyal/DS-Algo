package hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
	static void approach2(int topK) {
		String words[]= {"i","love","i","leetcode","i","love","coding"};
		Map<String, Integer> map=new HashMap<>();
		for(String word:words) {
			map.put(word, map.getOrDefault(word, 0)+1);
		}
		PriorityQueue<Integer> heap=new PriorityQueue<>((first,second)->second.compareTo(first));
		for(Map.Entry<String, Integer> entry:map.entrySet()) {
			heap.add(entry.getValue());
		}
		while(topK>=1) {
			int temp=heap.poll();
			for(Map.Entry<String, Integer> entry:map.entrySet()) {
				if(temp==entry.getValue())
					System.out.println(entry.getKey());
			}
			topK--;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		approach2(2);
	}

}

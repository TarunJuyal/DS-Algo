package hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KClosestPointToOrigin {
	static void approach(int minK) {
		int coordinates[][]= {{1,3},{-2,2}};
		Map<int[], Double> map=new HashMap<>();
		for(int[] i:coordinates) {
			int squareSum=0;
			for(int j:i) {
				squareSum+=Math.pow(j, 2);
			}
			map.put(i, map.getOrDefault(i, Math.sqrt(squareSum)));
		}
		PriorityQueue<Double> heap=new PriorityQueue<>((first,second)->first.compareTo(second));
		for(Map.Entry<int[], Double> entry:map.entrySet()) {
			heap.add(entry.getValue());
		}
		while(minK>=1) {
			double temp=heap.poll();
			for(Map.Entry<int[], Double> entry:map.entrySet()) {
				if(temp==entry.getValue())
					for(int i:entry.getKey())
						System.out.print(i+",");
				System.out.println();
			}
			minK--;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		approach(1);
	}

}

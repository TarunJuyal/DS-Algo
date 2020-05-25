package hashMap;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
 

public class IntersectionOfTwoArrays {
	static void findIntersection(int a[],int a1[]) {
		HashMap<Integer,Integer> temp=new HashMap<>();
		HashMap<Integer,Integer> temp2=new HashMap<>();
		for(int i:a)
			temp.put(i, temp.getOrDefault(i, 0)+1);
		for(int i:a1)
			temp2.put(i, temp2.getOrDefault(i, 0)+1);
		temp.keySet().retainAll(temp2.keySet());
		int result[]=new int[temp.size()];
		int i=0;
		for(Map.Entry<Integer, Integer> entry:temp.entrySet()) {
			result[i]=entry.getKey();
			i++;
		}
		for(int j:result)
			System.out.print(j+" ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,2,1};
		int a1[]= {2,2};
		findIntersection(a,a1);
	}

}

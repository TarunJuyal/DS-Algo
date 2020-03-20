package recursionAdvance;

import java.util.ArrayList;

public class ChildHopProblem {
	static ArrayList<String> findPath(int sum,int end){
		if(sum==end) {
			ArrayList<String> empty=new ArrayList<>();
			empty.add("");
			return empty;
		}
		if(sum>=end) {
			ArrayList<String> empty=new ArrayList<>();
			return empty;
		}
		ArrayList<String> result=new ArrayList<>();
		for(int i=1;i<=3;i++) {
			ArrayList<String> temp=findPath(sum+i, end);
			for(String str :temp) {
				result.add(i+str);
			}
			}
		return result;
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			System.out.println(findPath(0,10));
		}

}

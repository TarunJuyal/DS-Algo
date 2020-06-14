package graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacentListGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][]= {{0,1},{1,2},{2,0},{1,3}};
		List<List<Integer>> mainList=new ArrayList<>();
		for(int i=0;i<a.length;i++) {
			List<Integer> subList =new ArrayList<>();
			subList.add(a[i][0]);
			subList.add(a[i][1]);
			mainList.add(subList);
		}
		Graph graph=new Graph();
		for(int i=0;i<a.length;i++) {
			graph.addVertex(String.valueOf(i));
		}
		for(List<Integer> sub : mainList) {
			graph.createEdge(sub.get(0).toString(), sub.get(1).toString(), 0);
		}
		graph.print();
	}

}

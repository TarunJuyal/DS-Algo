package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;


class PrimsPair{
	String vertexName;
	String acquiredFrom;
	int cost;
}
class Vertex{
	HashMap<String, Integer> neighbours = new HashMap<>();
}
class Graph{
	HashMap<String, Vertex> vertxs = new HashMap<>();
	public int countVertices() {
		return vertxs.size();
	}
	public boolean isVertexExist(String vertexName) {
		return vertxs.containsKey(vertexName);
	}
	public void addVertex(String vertexName) {
		Vertex vertex = new Vertex();
		vertxs.put(vertexName, vertex);
	}
	public int countEdges() {
		ArrayList<String> keys = new ArrayList<>(vertxs.keySet());
		int count=0;
		for(String s: keys) {
			count+=vertxs.get(s).neighbours.size();
		}
		return count/2;
	}
	public boolean isEdgeExist(String first,String second) {
		Vertex firstVertex=vertxs.get(first);
		Vertex secondVertex=vertxs.get(second);
		if(firstVertex==null || secondVertex==null || !firstVertex.neighbours.containsKey(second))
			return false;
		return true;
	}
	public void createEdge(String first, String second , int cost) {
		if(isEdgeExist(first, second)) {
			System.out.println("Edge already exist can't create another!!");
			return;
		}
		Vertex firstVertex=vertxs.get(first);
		Vertex secondVertex=vertxs.get(second);
		firstVertex.neighbours.put(second, cost);
		secondVertex.neighbours.put(first, cost);
	}
	public void print() {
		for(Map.Entry<String, Vertex> entry : vertxs.entrySet()) {
			System.out.println(entry.getKey()+" => "+entry.getValue().neighbours);
		}
	} 
	public String removeVertex(String vertexName) {
		Vertex currentVertex=vertxs.get(vertexName);
		for(Map.Entry<String, Integer> entry: currentVertex.neighbours.entrySet()) {
			vertxs.get(entry.getKey()).neighbours.remove(vertexName);
		}
		vertxs.remove(vertexName);
		return vertexName;
	}
	public void removeEdge(String first, String second) {
		if(isEdgeExist(first, second)) {
			Vertex firstVertex=vertxs.get(first);
			Vertex secondVertex=vertxs.get(second);
			firstVertex.neighbours.remove(second);
			secondVertex.neighbours.remove(first);
		}else {
			System.out.println("no edge exist!!");
		}
	}
	private boolean isPath(String first,String second, HashMap<String, Boolean> isVisited) {
		isVisited.put(first, true);
		if(isEdgeExist(first, second))
			return true;
		Vertex firstVertex=vertxs.get(first);
		Set<String> neighbours=firstVertex.neighbours.keySet();
		for(String neighbour : neighbours) {
			if(!isVisited.containsKey(neighbour) && isPath(neighbour, second, isVisited))
				return true;
		}
		return false;
	}
	public boolean isPathExist(String first,String second) {
		return isPath(first,second, new HashMap<String,Boolean>());
	}

	
	Graph prims() {
		Graph mst=new Graph();
		HashMap<String, PrimsPair> map=new HashMap<>();
		PriorityQueue<PrimsPair> heap=new PriorityQueue<>((first,second)->first.cost-second.cost);
		for(String key :vertxs.keySet() ) {
			PrimsPair pair=new PrimsPair();
			pair.vertexName=key;
			pair.cost=Integer.MAX_VALUE;
			heap.add(pair);
			map.put(key, pair);
		}
		while(!heap.isEmpty()) {
			PrimsPair p=heap.remove();
			map.remove(p.vertexName);
			if(p.acquiredFrom==null)
				mst.addVertex(p.vertexName);
			else {
				mst.addVertex(p.vertexName);
				mst.createEdge(p.vertexName, p.acquiredFrom, p.cost);
			}
			for(String neighbour: vertxs.get(p.vertexName).neighbours.keySet()) {
				if(map.containsKey(neighbour)) {
					int oldCost=map.get(neighbour).cost;
					int newCost=vertxs.get(p.vertexName).neighbours.get(neighbour);
					if(newCost<oldCost) {
						PrimsPair p2=map.get(neighbour);
						PrimsPair p3 = new PrimsPair();
						p3.vertexName=p2.vertexName;
						heap.remove(p2);
						p3.acquiredFrom=p.vertexName;
						p3.cost=newCost;
						heap.add(p3);
						map.put(neighbour, p3);
					}
				}
			}
		}
		return mst;
	}
	
}
public class MyGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph =new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.createEdge("A", "B", 2);
		graph.createEdge("A", "D", 6);
		graph.createEdge("B", "C", 3);
		graph.createEdge("C", "D", 1);
		graph.createEdge("D", "E", 8);
		graph.createEdge("E", "F", 5);
		graph.createEdge("F", "G", 4);
		graph.createEdge("E", "G", 7);
		graph.print();
//		System.out.println("After Remove: ");
//		graph.removeVertex("E");
//		graph.removeEdge("D","E");
//		graph.removeEdge("G","E");
//		graph.removeEdge("A","D");
//		System.out.println("Path btw A and F: "+graph.isPathExist("A", "F"));
//		System.out.println("BFS btw A and F: "+graph.breadthFirstSearch("A", "F"));
//		System.out.println("DFS btw A and F: "+graph.depthFirstSearch("A", "F"));
//		graph.print();
//		System.out.println("BFT:");
//		graph.breadthFirstTraversal();
//		System.out.println("DFT:");
//		graph.depthFirstTraversal();
//		System.out.println("Graph Connected: "+graph.isConnected());
//		System.out.println("Graph Contains cycle: "+graph.isCycle());
//		System.out.println("components are:");
//		System.out.println(graph.getComponents());
		System.out.println("Prims output:");
		graph.prims().print();
	}

}

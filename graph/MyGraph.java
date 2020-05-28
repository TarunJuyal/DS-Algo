package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
		if(firstVertex==null || secondVertex==null || !firstVertex.neighbours.containsKey(secondVertex))
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
		graph.createEdge("A", "B", 3);
		graph.createEdge("A", "D", 2);
		graph.createEdge("B", "C", 4);
		graph.createEdge("C", "D", 7);
		graph.createEdge("D", "E", 5);
		graph.createEdge("E", "F", 3);
		graph.createEdge("F", "G", 3);
		graph.createEdge("E", "G", 3);
		graph.print();
		System.out.println("After Remove: ");
		graph.removeVertex("E");
		graph.print();
	}

}

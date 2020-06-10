package graph;

/*graph creation using hashmap,Bredth first search, depth first search, Breath first traversal,depth first traversal,check if cycle,
**check if connected, get components or subgraphs.*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

class Pair{
	String vertexName;
	String traversalTill;
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
	public boolean breadthFirstSearch(String source,String destination) {
		HashMap<String, Boolean> isVisited=new HashMap<>();
		Pair pair =new Pair();
		pair.vertexName=source;
		pair.traversalTill=source;
		LinkedList<Pair> queue=new LinkedList<>();
		queue.addLast(pair);
		while(!queue.isEmpty()) {
			Pair p= queue.removeFirst();
			if(isVisited.containsKey(p.vertexName))
				continue;
			isVisited.put(p.vertexName, true);
			System.out.println(p.vertexName+ " "+ p.traversalTill);
			if(isEdgeExist(p.vertexName, destination)) {
				System.out.println(destination);
				return true;
			}
			Vertex currentVertex=vertxs.get(p.vertexName);
			Set<String> neighbours=currentVertex.neighbours.keySet();
			for(String neighbour : neighbours) {
				if(!isVisited.containsKey(neighbour)) {
					Pair newPair=new Pair();
					newPair.vertexName=neighbour;
					newPair.traversalTill=p.traversalTill+neighbour;
					queue.addLast(newPair);
				}
			}
		}
		return false;
	}
	
	public boolean depthFirstSearch(String source,String destination) {
		HashMap<String, Boolean> isVisited=new HashMap<>();
		Pair pair =new Pair();
		pair.vertexName=source;
		pair.traversalTill=source;
		LinkedList<Pair> stack=new LinkedList<>();
		stack.addFirst(pair);
		while(!stack.isEmpty()) {
			Pair p= stack.removeFirst();
			if(isVisited.containsKey(p.vertexName))
				continue;
			isVisited.put(p.vertexName, true);
			System.out.println(p.vertexName+ " "+ p.traversalTill);
			if(isEdgeExist(p.vertexName, destination)) {
				System.out.println(destination);
				return true;
			}
			Vertex currentVertex=vertxs.get(p.vertexName);
			Set<String> neighbours=currentVertex.neighbours.keySet();
			for(String neighbour : neighbours) {
				if(!isVisited.containsKey(neighbour)) {
					Pair newPair=new Pair();
					newPair.vertexName=neighbour;
					newPair.traversalTill=p.traversalTill+neighbour;
					stack.addFirst(newPair);
				}
			}
		}
		return false;
	}
	
	public void breadthFirstTraversal() {
		HashMap<String, Boolean> isVisited=new HashMap<>();
		Pair pair =new Pair();
		for(Map.Entry<String, Vertex> entry:vertxs.entrySet()) {
			if(isVisited.containsKey(entry.getKey()))
				continue;
			pair.vertexName=entry.getKey();
			pair.traversalTill=entry.getKey();
			LinkedList<Pair> queue=new LinkedList<>();
			queue.addLast(pair);
			while(!queue.isEmpty()) {
				Pair p= queue.removeFirst();
				if(isVisited.containsKey(p.vertexName))
					continue;
				isVisited.put(p.vertexName, true);
				System.out.println(p.vertexName+ " "+ p.traversalTill);
				Vertex currentVertex=vertxs.get(p.vertexName);
				Set<String> neighbours=currentVertex.neighbours.keySet();
				for(String neighbour : neighbours) {
					if(!isVisited.containsKey(neighbour)) {
						Pair newPair=new Pair();
						newPair.vertexName=neighbour;
						newPair.traversalTill=p.traversalTill+neighbour;
						queue.addLast(newPair);
					}
				}
			}
		}
		
	}
	
	public void depthFirstTraversal() {
		HashMap<String, Boolean> isVisited=new HashMap<>();
		Pair pair =new Pair();
		for(Map.Entry<String, Vertex> entry:vertxs.entrySet()) {
			if(isVisited.containsKey(entry.getKey()))
				continue;
			pair.vertexName=entry.getKey();
			pair.traversalTill=entry.getKey();
			LinkedList<Pair> stack=new LinkedList<>();
			stack.addFirst(pair);
			while(!stack.isEmpty()) {
				Pair p= stack.removeFirst();
				if(isVisited.containsKey(p.vertexName))
					continue;
				isVisited.put(p.vertexName, true);
				System.out.println(p.vertexName+ " "+ p.traversalTill);
				Vertex currentVertex=vertxs.get(p.vertexName);
				Set<String> neighbours=currentVertex.neighbours.keySet();
				for(String neighbour : neighbours) {
					if(!isVisited.containsKey(neighbour)) {
						Pair newPair=new Pair();
						newPair.vertexName=neighbour;
						newPair.traversalTill=p.traversalTill+neighbour;
						stack.addFirst(newPair);
					}
				}
			}
		}
	}
	public boolean isConnected() {
		int count=0;
		HashMap<String, Boolean> isVisited=new HashMap<>();
		Pair pair =new Pair();
		for(Map.Entry<String, Vertex> entry:vertxs.entrySet()) {
			if(isVisited.containsKey(entry.getKey()))
				continue;
			count++;
			pair.vertexName=entry.getKey();
			pair.traversalTill=entry.getKey();
			LinkedList<Pair> queue=new LinkedList<>();
			queue.addLast(pair);
			while(!queue.isEmpty()) {
				Pair p= queue.removeFirst();
				if(isVisited.containsKey(p.vertexName))
					continue;
				isVisited.put(p.vertexName, true);
				System.out.println(p.vertexName+ " "+ p.traversalTill);
				Vertex currentVertex=vertxs.get(p.vertexName);
				Set<String> neighbours=currentVertex.neighbours.keySet();
				for(String neighbour : neighbours) {
					if(!isVisited.containsKey(neighbour)) {
						Pair newPair=new Pair();
						newPair.vertexName=neighbour;
						newPair.traversalTill=p.traversalTill+neighbour;
						queue.addLast(newPair);
					}
				}
			}
		}
		return count==1;
	}
	
	public boolean isCycle() {
		HashMap<String, Boolean> isVisited=new HashMap<>();
		Pair pair =new Pair();
		for(Map.Entry<String, Vertex> entry:vertxs.entrySet()) {
			if(isVisited.containsKey(entry.getKey()))
				continue;
			pair.vertexName=entry.getKey();
			pair.traversalTill=entry.getKey();
			LinkedList<Pair> queue=new LinkedList<>();
			queue.addLast(pair);
			while(!queue.isEmpty()) {
				Pair p= queue.removeFirst();
				if(isVisited.containsKey(p.vertexName))
					return true;
				isVisited.put(p.vertexName, true);
				System.out.println(p.vertexName+ " "+ p.traversalTill);
				Vertex currentVertex=vertxs.get(p.vertexName);
				Set<String> neighbours=currentVertex.neighbours.keySet();
				for(String neighbour : neighbours) {
					if(!isVisited.containsKey(neighbour)) {
						Pair newPair=new Pair();
						newPair.vertexName=neighbour;
						newPair.traversalTill=p.traversalTill+neighbour;
						queue.addLast(newPair);
					}
				}
			}
		}
		return false;
	}
	
	public HashMap<String,ArrayList<String>> getComponents() {
		int component=0;
		HashMap<String, Boolean> isVisited=new HashMap<>();
		HashMap<String, ArrayList<String>> components=new HashMap<>();
		Pair pair =new Pair();
		for(Map.Entry<String, Vertex> entry:vertxs.entrySet()) {
			if(isVisited.containsKey(entry.getKey()))
				continue;
			ArrayList<String> subGraph=new ArrayList<>();
			pair.vertexName=entry.getKey();
			pair.traversalTill=entry.getKey();
			LinkedList<Pair> queue=new LinkedList<>();
			queue.addLast(pair);
			while(!queue.isEmpty()) {
				Pair p= queue.removeFirst();
				if(isVisited.containsKey(p.vertexName))
					continue;
				isVisited.put(p.vertexName, true);
				subGraph.add(p.vertexName);
				Vertex currentVertex=vertxs.get(p.vertexName);
				Set<String> neighbours=currentVertex.neighbours.keySet();
				for(String neighbour : neighbours) {
					if(!isVisited.containsKey(neighbour)) {
						Pair newPair=new Pair();
						newPair.vertexName=neighbour;
						newPair.traversalTill=p.traversalTill+neighbour;
						queue.addLast(newPair);
					}
				}
			}
			component++;
			components.put("Component"+component, subGraph);
		}
		return components;
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
		System.out.println("components are:");
		System.out.println(graph.getComponents());
	}

}

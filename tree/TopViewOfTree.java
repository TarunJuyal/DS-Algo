package tree; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

class LevelPair{
	int level;
	BSTNode node;
	LevelPair(BSTNode node,int level){
		this.node=node;
		this.level=level;
	}
}
class BSTNode{
	int data;
	BSTNode left;
	BSTNode right;
	BSTNode(int data){
		this.data=data;
	}
}
class BSTOperations{
	BSTNode root;
	void balanceCreationInOrderGiven(int arr[]) {
		root=balanceCreationInOrderGiven(arr,0,arr.length-1);
	}
	BSTNode balanceCreationInOrderGiven(int arr[],int low, int high) {
		int mid=(low+high)/2;
		if(low>high)
			return null;
		BSTNode node= add(root,arr[mid]);
		node.left=balanceCreationInOrderGiven(arr, low, mid-1);
		node.right=balanceCreationInOrderGiven(arr, mid+1, high);
		return node;
	}
	BSTNode add(BSTNode root,int data) {
		if(root==null) {
			root=new BSTNode(data);
			return root;
		}
		if(data<root.data)
			root.left=add(root.left, data);
		else if(data>root.data)
			root.right=add(root.right, data);
		return root;
	}
	void print(BSTNode root) {
		if(root==null)
			return;
		String output="";
		output+=root.data+" => ";
		if(root.left!=null)
			output+="Left "+root.left.data;
		if(root.right!=null)
			output+="Right "+root.right.data;
		System.out.println(output);
		print(root.left);
		print(root.right);
	}
	static HashMap<Integer, ArrayList<Integer>> h =new HashMap<>();
	static Queue<LevelPair> q=new LinkedList<>();
	//used level order traversal while finding vertical order otherwise ordering is not done for vertical order. 
	void verticalOrder(BSTNode root,int level) {
		q.add(new LevelPair(root,level));
		while(!q.isEmpty()) {
			LevelPair PairNode =q.remove();
			ArrayList<Integer> nodesInLine=h.get(PairNode.level);
			if(nodesInLine==null) {
				nodesInLine=new ArrayList<>();
				nodesInLine.add(PairNode.node.data);
			}
			else
				nodesInLine.add(PairNode.node.data);
			h.put(PairNode.level, nodesInLine);
			if(PairNode.node.left!=null) {
				q.add(new LevelPair(PairNode.node.left,PairNode.level-1));
			}
			if(PairNode.node.right!=null) {
				q.add(new LevelPair(PairNode.node.right,PairNode.level+1));
			}
		}
	}
	void printTopView(BSTNode root) {
		verticalOrder(root, 0);
		TreeMap<Integer, ArrayList<Integer>> map=new TreeMap<>();
		map.putAll(h);
		System.out.println("TopView is: ");
		for(HashMap.Entry<Integer, ArrayList<Integer>> entry:map.entrySet()) {
			System.out.print(entry.getValue().get(0)+" ");
		}
	}
}
public class BinarySearchTree01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTOperations b=new BSTOperations();
		int[] arr= {10,20,30,40,50,60,70,80,90,100,110,120,130,140,150};             //given array in InOrder
		b.balanceCreationInOrderGiven(arr);
		b.printTopView(b.root);
	}
}

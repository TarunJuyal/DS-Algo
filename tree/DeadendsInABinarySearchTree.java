package tree; 

// input elements should be greater than 0.

import java.util.ArrayList;

class BSTNode{
	int data;
	BSTNode left;
	BSTNode right;
	BSTNode(int data){
		this.data=data;
	}
}
class BSTOperations{
	static ArrayList<Integer> visitedNodes=new ArrayList<>();
	static ArrayList<Integer> deadEnds=new ArrayList<>();
	BSTNode root;
	//this is for general addition in tree without balance.
	void creation(int[] arr) {  
		for(int data: arr)
			root=add(root,data);
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
	ArrayList<Integer> deadEnd(BSTNode root) {
		if(root==null)
			return deadEnds;
		if(root.left==null && root.right==null) {
			if(root.data==1)
				deadEnds.add(root.data);
			else if(visitedNodes.contains((root.data+1)) && visitedNodes.contains((root.data-1)))
				deadEnds.add(root.data);
			visitedNodes.add(root.data);
		}
		visitedNodes.add(root.data);
		deadEnd(root.left);
		deadEnd(root.right);
		return deadEnds;
	}
	void deadEnd() {
		deadEnd(root);
		if(deadEnds.isEmpty())
			System.out.println("No Dead ends!!");
		else {
			System.out.println("Dead ends are: ");
			System.out.println(deadEnds);
		}
	}
}
public class BinarySearchTree01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTOperations b=new BSTOperations();
//  int arr[]= {8,7,10,2,9,13};                // test case for dead end
		int arr[]= {8,5,9,2,7,1};                 //test case for dead end
		b.creation(arr);
		b.print(b.root);
		b.deadEnd();
	}
}

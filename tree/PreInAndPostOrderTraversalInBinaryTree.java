package tree;

// Includes Height of tree , Size of tree(Number of nodes in a tree) and search an element in tree.

import java.util.Scanner;

class BTNode{
	int data;
	BTNode left;
	BTNode right;
	BTNode(int data){
		this.data=data;
	}
}
class BTOperations{
	Scanner s=new Scanner(System.in);
	String node="root";
	BTNode insert() {
		System.out.println("Enter data of "+node);
		int data=s.nextInt();
		if(data==-1)
			return null;
		BTNode treeNode=new BTNode(data);
		node="left";
		treeNode.left=insert();
		node="right";
		treeNode.right=insert();
		return treeNode;
	}
	void print(BTNode root) {
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
	int getHeight(BTNode root) {
		if(root==null)
			return 0;
		int currentHeightLeft=getHeight(root.left);
		int currentHeightRight=getHeight(root.right);
		if(currentHeightLeft>currentHeightRight)
			return currentHeightLeft+1;
		else
			return currentHeightRight+1;
		
	}
	int getSize(BTNode root) {
		if(root==null)
			return 0;
		int currentSize=0;
		currentSize+=getSize(root.left);
		currentSize+=getSize(root.right);
		return currentSize+1;
	}
	boolean searchElement(BTNode root,int value) {
		if(root==null)
			return false;
		if(root.data==value)
			return true;
		boolean temp=searchElement(root.left, value);
		if(temp)
			return true;
		return searchElement(root.right, value);
	}
	void preOrder(BTNode root) {
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	void inOrder(BTNode root) {
		if(root==null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	void postOrder(BTNode root) {
		if(root==null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
}
public class PreInAndPostOrderTraversalInBinaryTree {
	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTOperations b=new BTOperations();
		BTNode root=b.insert();
		b.print(root);
		System.out.println("Height is: "+b.getHeight(root));
		System.out.println("Number of node or size is: "+b.getSize(root));
		System.out.println("Enter value to be searched: ");
	    int value=scanner.nextInt();
	    if(b.searchElement(root,value))
	    	System.out.println(value+" present in the tree.");
	    else
	    	System.out.println(value+" not present in tree");
	    System.out.print("PreOrder: ");
	    b.preOrder(root);
	    System.out.println();
	    System.out.print("InOrder: ");
	    b.inOrder(root);
	    System.out.println();
	    System.out.print("PostOrder: ");
	    b.postOrder(root);
	    System.out.println();
	}
}

package tree;

/* Input is taken from user for each node and its number of children which cam be 0 , 1 or 2. 
** Sum of Kth level elements is given as output.*/

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
	BTNode root;
	Scanner s=new Scanner(System.in);
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
	BTNode buildTree(BTNode root) {
		System.out.println("Enter the data of the node: ");
		int data=s.nextInt();
		root=new BTNode(data);
		System.out.println("Enter no. of children "+data+": ");
		int child=s.nextInt();
		if(child==0)
			return root;
		else if(child==1) {
			root.left=buildTree(root.left);
			return root;
		}
		else if(child==2) {
			root.left=buildTree(root.left);
			root.right=buildTree(root.right);
			return root;
		}
		return root;
	} 
	BTNode buildTree() {
		return buildTree(root);
	}
	int sumOfKthLevel(BTNode root,int level,int sumOfLevel) {
		if(root==null)
			return sumOfLevel;
		if(level==0) {
			return root.data;
		}
		int sumOfLevelLeft=sumOfKthLevel(root.left, level-1,sumOfLevel);
		int sumOfLevelright=sumOfKthLevel(root.right, level-1, sumOfLevel);
		return sumOfLevelright+sumOfLevelLeft;
	}
	void getSumOfLevel(BTNode root,int level) {
		int sum=sumOfKthLevel(root, level,0);
		System.out.println("Sum of elements of level "+level+" is: "+sum);
	}
}
public class BinaryTree {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTOperations b=new BTOperations();
	    BTNode root=b.buildTree();
	    b.print(root);
	    b.getSumOfLevel(root,2);
	}
}

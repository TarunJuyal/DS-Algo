package tree;

// preorder , inorder and postorder traversal of a tree.

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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTOperations b=new BTOperations();
		BTNode root=b.insert();
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

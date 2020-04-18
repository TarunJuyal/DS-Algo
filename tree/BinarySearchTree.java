package tree;

import java.util.Scanner;

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
	void insert(int data) {
		root=insert(root,data);
	}
	BSTNode insert(BSTNode root,int data) {
		if(root==null) {
			root=new BSTNode(data);
			return root;
		}
		if(data<root.data)
			root.left=insert(root.left, data);
		else if(data>root.data)
			root.right=insert(root.right, data);
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
}
public class BinarySearchTree {
	static Scanner s= new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTOperations b=new BSTOperations();
		int choice;
		do {
			System.out.println("Enter data of node: ");
			int data=s.nextInt();
			b.insert(data);
			System.out.println("Want to enter more (1 for yes / -1 for no): ");
		    choice=s.nextInt();
		}while(choice==1);
		b.print(b.root);
	}

}

package tree;

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
}
public class BinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTOperations b=new BTOperations();
		BTNode root=b.insert();
		b.print(root);
	}

}

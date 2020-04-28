package tree;

import java.util.LinkedList;
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
	void leftView(BTNode root) {
		LinkedList<BTNode> queue=new LinkedList<>();
		queue.add(root);
		BTNode last=null;
		while(!queue.isEmpty()) {
			int j=queue.size();
			for(int i=0;i<j;i++) {
				if(i==0) {
					System.out.println(queue.get(0).data);
				}
				last=queue.poll();
			}
			BTNode node=null;
			node =last;
			if(node.left!=null)
				queue.addLast(node.left);
			if(node.right!=null)
				queue.addLast(node.right);
		}
	}
}
public class BinaryTree {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTOperations b=new BTOperations();
		BTNode root=b.insert();
	    b.print(root);
	    b.leftView(root);
	}
}

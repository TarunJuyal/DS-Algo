package tree;

import java.util.LinkedList;
import java.util.Queue;
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
	Queue<BTNode> q=new LinkedList<>();
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
	void levelOrder(BTNode root) {
		q.add(root);
		while(!q.isEmpty()) {
			BTNode node=q.remove();
			System.out.println(node.data+" ");
			if(node.left!=null) {
				q.add(node.left);
			}
			if(node.right!=null) {
				q.add(node.right);
			}
		}
	}
}
public class LevelOrderPrint {
	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTOperations b=new BTOperations();
		BTNode root=b.insert();
	    b.levelOrder(root);
	}
}

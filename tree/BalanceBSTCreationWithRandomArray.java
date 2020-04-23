package tree; 

import java.util.Arrays;

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
	void balanceCreationWithRandomArray(int[] arr) {
		Arrays.sort(arr);
		root=balanceCreationWithRandomArray(arr,0,arr.length-1);
	}
	BSTNode balanceCreationWithRandomArray(int arr[],int low, int high) {
		int mid=(low+high)/2;
		if(low>high)
			return null;
		BSTNode node= add(root,arr[mid]);
		node.left=balanceCreationWithRandomArray(arr, low, mid-1);
		node.right=balanceCreationWithRandomArray(arr, mid+1, high);
		return node;
	}
	void add(int data) {
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

}
public class BinarySearchTree01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTOperations b=new BSTOperations();
		int[] arr= {100,95,90,97,65,120};
		b.balanceCreationWithRandomArray(arr);
		b.print(b.root);
	}
}

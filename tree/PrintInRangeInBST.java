package tree; 

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
	void printInRange(BSTNode root, int startOfRange,int endOfRange) {
		if(root==null)
			return;
		if(root.data>=startOfRange && root.data<=endOfRange) {
			System.out.print(root.data+", ");
		}
		printInRange(root.left, startOfRange, endOfRange);
		printInRange(root.right, startOfRange, endOfRange);
	}
}
public class BinarySearchTree01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTOperations b=new BSTOperations();
		int[] arr= {10,20,30,40,50,60,70,80,90,100,110,120,130,140,150};             //given array in InOrder
		b.balanceCreationInOrderGiven(arr);
		b.print(b.root);
		b.printInRange(b.root, 40, 110);
	}
}

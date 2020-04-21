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
	static int maxLevel=0;
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
	void printLeftView(BSTNode root,int level) {
		if(root==null)
			return ;
		if(maxLevel<level) {
			System.out.println(root.data);
			maxLevel=level;
		}
		printLeftView(root.left, level+1);
		printLeftView(root.right, level+1);
	}
}
public class BinarySearchTree01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTOperations b=new BSTOperations();
		int[] arr= {10,20,30,40,50,60,70};             //given array in InOrder
		b.balanceCreationInOrderGiven(arr);
		b.print(b.root);
		System.out.println("Left view of tree:");
		b.printLeftView(b.root, 1);
	}
}

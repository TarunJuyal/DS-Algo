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
	int getMax(BSTNode root){
		if(root==null)
			throw new RuntimeException("Tree is empty!");
		if(root.right==null)
			return root.data;
		return getMax(root.right);
	}
	void delete(BSTNode root,int datatoBedeleted ,BSTNode parent,boolean isLeft) {
		if(root==null)
			throw new RuntimeException("Tree is Empty!!");
		if(datatoBedeleted<root.data) {
			parent=root; 
			delete(root.left, datatoBedeleted,parent,true);
		}
		else if(datatoBedeleted>root.data) {
			parent=root;
			delete(root.right,datatoBedeleted,parent,false);
		}
		else {
			if(root.left==null && root.right==null) {
				if(isLeft)
					parent.left=null;
				else
					parent.right=null;
			}
			else if(root.left==null && root.right!=null) {
				if(isLeft)
					parent.left=root.right;
				else
					parent.right=root.right;
			}
			else if(root.left!=null && root.right==null) {
				if(isLeft)
					parent.left=root.left;
				else
					parent.right=root.left;
			}
			else if(root.left!=null && root.right!=null) {
				root.data=getMax(root.left);
				delete(root.left,root.data,root,true);
			}
		}
}
	void delete(int data) {
		delete(root, data, null, false);
	}

}
public class BinarySearchTree01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTOperations b=new BSTOperations();
		int[] arr= {10,20,30,40,50,60,70,80,90,100,110,120,130,140,150};             //given array in InOrder
		b.balanceCreationInOrderGiven(arr);
		b.print(b.root);
		b.delete(120);
		b.print(b.root);
	}
}

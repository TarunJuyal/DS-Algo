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
	//this was for general addition in tree without balance.
	void creation(int[] arr) {  
		for(int data: arr)
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
	boolean checkIfBalance(BSTNode root) {
		if(root==null)
			return true;
		int leftHeight=getHeight(root.left);
		int rightHeight=getHeight(root.right);
		if(Math.abs(leftHeight-rightHeight)<=1 && checkIfBalance(root.left) && checkIfBalance(root.right))
			return true;
		return false;
			
	}
	int getHeight(BSTNode root) {
		if(root==null)
			return 0;
		int currentHeightLeft=getHeight(root.left);
		int currentHeightRight=getHeight(root.right);
		if(currentHeightLeft>currentHeightRight)
			return currentHeightLeft+1;
		else
			return currentHeightRight+1;
		
	}
}
public class BinarySearchTree01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTOperations b=new BSTOperations();
		int [] arr= {10,9,20,8,21,30};                                               //array to check balance
		b.creation(arr);
		b.print(b.root);
		if(b.checkIfBalance(b.root))
			System.out.println("Tree is balanced");
		else 
			System.out.println("Tree is not balanced.");
	}
}

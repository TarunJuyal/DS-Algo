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
	static int maxDiameter=0;
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
	int findDiameter(BSTNode root) {
		if(root==null)
			return 0;
		int currentHeightLeft=getHeight(root.left);
		int currentHeightRight=getHeight(root.right);
		if((currentHeightLeft+currentHeightRight)>maxDiameter)
			maxDiameter=currentHeightLeft+currentHeightRight;
		findDiameter(root.left);
		findDiameter(root.right);
		return maxDiameter;
	}
}
public class BinarySearchTree01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTOperations b=new BSTOperations();
		int [] arr= {60,40,70,20,50,10,30,52,55,71};                                 //array to check diameter of tree
		b.creation(arr);
		b.print(b.root);
		System.out.println("Diameter of tree is: "+b.findDiameter(b.root));
	}
}

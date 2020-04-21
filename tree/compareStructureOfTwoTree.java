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
	void creation(int[] arr) {
		for(int data: arr)
			root=add(root,data);
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
	boolean compareStructure(BSTNode first,BSTNode second) {
		if(first==null && second==null)
			return true;
		else if((first!=null && second==null)||(first==null && second!=null))
			return false;
		else if(compareStructure(first.left, second.left) && compareStructure(first.right, second.right))
			return true;
		return false;
	}
}
public class BinarySearchTree01 {
	static Scanner s= new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTOperations b=new BSTOperations();
		BSTOperations b2=new BSTOperations();
		int[] arr= {100,95,90,97,65,120};
		int[] arr2= {99,94,89,96,64,119};
		b.creation(arr);
		b2.creation(arr2);
		b.print(b.root);
		b2.print(b2.root);
		System.out.println(b.compareStructure(b.root, b2.root)?"Structurally same":"Structurally different");
	}
}

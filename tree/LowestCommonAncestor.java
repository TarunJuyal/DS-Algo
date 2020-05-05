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
	void lowestCommonAncestor(int x,int y) {
		System.out.println("Lowest common ancestor is: "+lowestCommonAncestor(root, x, y).data);
	}
	BSTNode lowestCommonAncestor(BSTNode root,int x,int y) {
		if(root==null)
			return null;
		if(root.data==x||root.data==y)
			return root;
		BSTNode left=lowestCommonAncestor(root.left, x, y);
		BSTNode right=lowestCommonAncestor(root.right, x, y);
		if(left!=null && right!=null)
			return root;
		return left!=null?left:right;
	}

}
public class BinarySearchTree01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTOperations b=new BSTOperations();
		int arr[]= {1,2,3,5};
		b.balanceCreationInOrderGiven(arr);
		b.print(b.root);
		b.lowestCommonAncestor(3,5);
	}
}

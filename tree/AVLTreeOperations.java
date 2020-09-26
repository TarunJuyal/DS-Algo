package tree;

class AVLTree{
	private class AVLNode{
		private int data;
		private AVLNode left;
		private AVLNode right;
		private int height;
		
		public AVLNode(int data) {
			this.data=data;
		}
		
		@Override
		public String toString() {
			return "Node="+data;
		}
	}
	private AVLNode root;
	
	public void insert(int data) {
		root=insert(root, data);
	}
	
	private AVLNode insert(AVLNode root,int data) {
		if(root==null) {
			root=new AVLNode(data);
			return root;
		}
		if(data<root.data)
			root.left=insert(root.left, data);
		else if(data>root.data)
			root.right=insert(root.right, data);
		setHeight(root);
		return balance(root);
	}
	
	private AVLNode balance(AVLNode root) {
		if(isLeftHeavy(root)) {
			if(balanceFactor(root.left)<0)
				root.left=rotateLeft(root.left);
			return rotateRight(root);
		}else if(isRightHeavy(root)) {
			if(balanceFactor(root.right)>0)
				root.right=rotateRight(root.right);
			return rotateLeft(root);
		}
		return root;
	}
	
	private AVLNode rotateLeft(AVLNode root) {
		AVLNode newRoot=root.right;
		root.right=newRoot.left;
		newRoot.left=root;
		setHeight(root);
		setHeight(newRoot);
		return newRoot;
	}
	
	private AVLNode rotateRight(AVLNode root) {
		AVLNode newRoot=root.left;
		root.left=newRoot.right;
		newRoot.right=root;
		setHeight(root);
		setHeight(newRoot);
		return newRoot;
	}
	
	private void setHeight(AVLNode root) {
		root.height=Math.max(height(root.left), height(root.right))+1;
	}
	
	private int height(AVLNode root) {
		if(root==null)
			return -1;
		return root.height;
	}
	
	private int balanceFactor(AVLNode root) {
		return (root==null)?0:height(root.left)-height(root.right);
	}
	
	private boolean isLeftHeavy(AVLNode root) {
		return balanceFactor(root)>1;
	}
	private boolean isRightHeavy(AVLNode root) {
		return balanceFactor(root)<-1;
	}
	
	public boolean isBalanced() {
		return isBalanced(root);
	}
	private boolean isBalanced(AVLNode root) {
		if(root==null)
			return true;
		if(Math.abs(balanceFactor(root))<=1 && isBalanced(root.left) && isBalanced(root.right))
			return true;
		return false;
	}
	
//	A perfect binary tree of height h has 2^(h + 1) – 1 node.
//	A perfect binary tree of height h has 2^h leaf nodes.
	
	public boolean isPerfect() {
		return isPerfect(root,root.height,0);
	}
	private boolean isPerfect(AVLNode root, int depth,int level) {
		if(root==null)
			return true;
		return Math.pow(2, root.height+1)-1==size(root);
	}
	private int size(AVLNode root) {
		if(root==null)
			return 0;
		return size(root.left)+size(root.right)+1;
	}
	
}

public class AVLTreeOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVLTree tree=new AVLTree();
		tree.insert(30);
		tree.insert(10);
		tree.insert(20);
		tree.insert(15);
		System.out.println(tree.isPerfect());
	}

}

package tree;

import java.util.ArrayList;
import java.util.Scanner;

class TreeNode{
	int data;
	ArrayList<TreeNode> children;
	TreeNode(int data){
		this.data=data;
		this.children=new ArrayList<>();
	}
}
class TreeOperations{
	Scanner scanner=new Scanner(System.in);
	TreeNode addSubTree() {
		TreeNode parent;
		System.out.println("Enter the data of the node:");
		int data=scanner.nextInt();
		parent=new TreeNode(data);
		System.out.println(data+"th node : Enter the children: ");
		int childs=scanner.nextInt();
		for(int i=1;i<=childs;i++) {
			TreeNode childNode=addSubTree();
			parent.children.add(childNode);
		}
		return parent;
	}
	void print(TreeNode root) {
		String str=root.data+" => ";
		for(TreeNode child:root.children) {
			str+=child.data+" , ";
		}
		System.out.println(str);
		for(TreeNode child:root.children) {
			print(child);
		}
	}
	boolean searchElement(TreeNode root, int value) {
		boolean temp;
		if(root==null)
			return false;
		if(root.data==value)
			return true;
        for(int i=0;i<root.children.size();i++) {
			temp=searchElement(root.children.get(i),value);
			if(!temp)
				continue;
			else
				return true;
		}
		return false;
		 
	}
}
public class SearchElementInTree {
	static Scanner scanner =new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeOperations tree=new TreeOperations();
		TreeNode root=tree.addSubTree();
		tree.print(root);
	    System.out.println("Enter value to be searched: ");
	    int value=scanner.nextInt();
	    if(tree.searchElement(root,value))
	    	System.out.println(value+" present in the tree.");
	    else
	    	System.out.println(value+" not present in tree");
	}

}

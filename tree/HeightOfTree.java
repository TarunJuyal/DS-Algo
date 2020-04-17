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
	int getHeight(TreeNode root) {
		if(root==null)
			return 0;
		if(root.children.size()==0)
			return 1;
		int max=0;
		for(int i=0;i<root.children.size();i++) {
			int currentHeight=getHeight(root.children.get(i));
			max=Math.max(max, currentHeight);
		}
		return max+1;
	}
}
public class HeightOfTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeOperations tree=new TreeOperations();
		TreeNode root=tree.addSubTree();
		tree.print(root);
		System.out.println("Height is : "+tree.getHeight(root));
	}

}

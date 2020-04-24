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
	TreeNode addSubTreeWithMaxTwoNodes() {
		TreeNode parent;
		System.out.println("Enter the data of the node:");
		int data=scanner.nextInt();
		parent=new TreeNode(data);
		System.out.println(data+"th node : Enter the children: ");
		int childs=scanner.nextInt();
		if(childs>=0 && childs<=2) {
			for(int i=1;i<=childs;i++) {
				TreeNode childNode=addSubTree();
				parent.children.add(childNode);
			}
		}
		else {
			throw new RuntimeException("Can enter only 0,1 or 2 child");
		}
		return parent;
	}
	void levelSum(TreeNode root,int level,int []sum) {
		if(root==null)
			return;
		sum[level]+=root.data;
		for(TreeNode child:root.children) {
			levelSum(child, level+1, sum);
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
public class GenericTree {
	static Scanner scanner =new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeOperations tree=new TreeOperations();
		TreeNode root=tree.addSubTreeWithMaxTwoNodes();
		System.out.println("Height is : "+tree.getHeight(root));
		int sum[]=new int[tree.getHeight(root)];
		tree.levelSum(root,0,sum);
		System.out.println("Enter level whose sum is required: ");
		int level=scanner.nextInt();
		if(level>=0 && level<tree.getHeight(root))
			System.out.println("Sum of elements of level "+level+" is: "+sum[level]);
		else
			throw new RuntimeException("Invalid level!!");
	}

}

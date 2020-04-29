package StackAndQueue;

import java.util.Stack;

public class RedundantBracket {
	 static Stack<Character> stack=new Stack<>();
	static boolean checkIfRedundantBracket(char s[]) {
		for(int i=0;i<s.length;i++) {
			 if (s[i]==')') { 
				 char top = stack.peek(); 
				 stack.pop(); 
				 boolean isRedundant = true; 
				 while (top!='(') {  
					 if (top=='+'||top=='-'||top=='*'||top=='/') 
						 isRedundant = false;
					 top = stack.peek(); 
					 stack.pop(); 
				 }  
				 if (isRedundant)  
					 return true; 
			 	}
			 else
				 stack.push(s[i]);                     
	        } 
		return false; 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="((a+b))";
		if(checkIfRedundantBracket(s.toCharArray()))
			System.out.println("Redundant brackets present!!");
		else
			System.out.println("No redundant brackets");
		String s1="(a+(b)/c)";
		if(checkIfRedundantBracket(s1.toCharArray()))
			System.out.println("Redundant brackets present!!");
		else
			System.out.println("No redundant brackets");
		String s2="(a+b*(c-d))";
		if(checkIfRedundantBracket(s2.toCharArray()))
			System.out.println("Redundant brackets present!!");
		else
			System.out.println("No redundant brackets");
	}

}

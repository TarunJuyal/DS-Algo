package StackAndQueue;

import java.util.Stack;

public class InfixToPostfix {
	static int precedence(char c) {
		if(c == '^') 
		    return 3; 
		else if(c == '*' || c == '/') 
			return 2; 
		else if(c == '+' || c == '-') 
			return 1; 
		else
			return -1;
	}
	static void toPostfix(char s[]) {
		Stack<Character> stack=new Stack<>();
		String output="";
		for(int i=0;i<s.length;i++) {
			if((s[i]>='a' && s[i]<='z')||(s[i]>='A' && s[i]<='Z'))
				output+=s[i];
			else if(s[i]=='(')
				stack.push(s[i]);
			else if(s[i]==')') {
				while(!stack.isEmpty() && stack.peek()!='(') {
					output+=stack.peek();
					stack.pop();
				}
				if(stack.peek()=='(')
					stack.pop();
			}
			else {
				while(!stack.isEmpty() && precedence(s[i])<=precedence(stack.peek())) {
					output+=stack.peek();
					stack.pop();
				}
				stack.push(s[i]);
			}
		}
		while(!stack.isEmpty()) {
			output+=stack.peek();
			stack.pop();
		}
		System.out.println("Postfix expression is: "+output);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="a+b*(c^d-e)^(f+g*h)-i";
		System.out.println("Infix expession is: "+s);
		toPostfix(s.toCharArray());
	}

}

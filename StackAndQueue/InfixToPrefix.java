package StackAndQueue;

import java.util.Stack;

public class InfixToPrefix {
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
	static String revString(String s) {
		if(s.length()==0)
			return "";
		if(s.charAt(0)=='(')
			s=')'+s.substring(1);
		else if(s.charAt(0)==')')
			s='('+s.substring(1);
		return revString(s.substring(1))+s.charAt(0);
	}
	static void toPrefix(String s) {
		String str=revString(s);
		String Output=revString(toPostfix(str.toCharArray()));
		System.out.println("Prefix expression is: "+Output);
	} 
	static String toPostfix(char s[]) {
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
		return output;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="(a-b/c)*(a/k-l)";
		System.out.println("Infix expession is: "+s);
		toPrefix(s);
		
	}

}

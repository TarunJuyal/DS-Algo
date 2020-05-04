package StackAndQueue;

import java.util.Stack;

public class PrefixToInfix {
	static String revString(String s) {
		if(s.length()==0)
			return "";
		return revString(s.substring(1))+s.charAt(0);
	}
	static boolean isOperator(String s) {
		switch(s) {
		case "^":
		case "+":
		case "-":
		case "*":
		case "/":return true;
		}
		return false;
	}
	static String convertToInfix(String []s) {
		Stack<String> stack=new Stack<>();
		for(int i=0;i<s.length;i++) {
			if(isOperator(s[i])) {
				String op1=stack.pop();
				String op2=stack.pop();
				stack.push("("+op1+s[i]+op2+")");
			}
			else
				stack.push(s[i]);
		}
		return stack.pop();
	}
	static void toInfix(String s) {
		String str[]=new String[s.length()];
		String temp=revString(s);
		for(int i=0;i<s.length();i++) {
			str[i]=Character.toString(temp.charAt(i));
		}
		System.out.println("Infix Expression is: "+convertToInfix(str));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="+-*^ABCD//EF+GH";
		System.out.println("Prefix Expession is: "+s);
		toInfix(s);
	}

}

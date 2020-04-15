package StackAndQueue;

import java.util.Stack;

public class BalanceBracketProblem {

	static boolean ifCancels(char c1,char c2) {
		 if (c1 == '(' && c2 == ')') 
	         return true; 
	       else if (c1 == '{' && c2 == '}') 
	         return true; 
	       else if (c1 == '[' && c2 == ']') 
	         return true; 
	       else
	         return false;
	}
	static boolean checkForBalance( char s[]) {
		Stack<Character> brackets=new Stack<>();
		for(int i=0;i<s.length;i++) {
			if(s[i]=='('||s[i]=='['||s[i]=='{') {
				brackets.push(s[i]);
			}
			else if(s[i]==')'||s[i]==']'||s[i]=='}') {
				if(brackets.isEmpty())
					return false;
				else if(ifCancels(brackets.peek(),s[i])) {
					System.out.println(brackets.peek());
					brackets.pop();
				}
			}
		}
		if(brackets.isEmpty())
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="([[{{()}}]])";
		if(checkForBalance(str.toCharArray()))
			System.out.println("Brackets are balanced");
		else
			System.out.println("Brackets are not balanced");
	}

}

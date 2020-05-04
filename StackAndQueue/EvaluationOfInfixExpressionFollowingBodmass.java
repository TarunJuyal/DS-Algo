package StackAndQueue;

//works only with single digit operands.

import java.util.Stack;

public class EvaluationOfInfixExpressionFollowingBodmass {
	static Stack<Integer> operandStack=new Stack<>();
	static Stack<String> operatorStack=new Stack<>();
	static int getPriority(String s) {
		switch(s) {
		case "^":return 3;
		case "/":
		case "*":return 2;
		case "+":
		case "-":return 1;
		}
		return -1;
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
	static int calculate(int op1,int op2,String s) {
		int result=0;
		switch(s) {
		case "^":result= (int)Math.pow(op1, op2); break;
		case "+":result=op1+op2; break;
		case "-":result=op1-op2; break;
		case "*":result=op1*op2; break;
		case "/":result=op1/op2; break;
		}
		return result;
	}
	static void calculateExpression() {
		int op1=operandStack.pop();
		int op2=operandStack.pop();
		String temp=operatorStack.pop();
		operandStack.push(calculate(op2,op1,temp));
	}
	static int evaluateExpression(String []s) {
		operandStack.push(Integer.parseInt(s[0]));                                        //first element will always be an operand.
		for(int i=1;i<s.length;i++) {
			if(isOperator(s[i])) {
				if(!operatorStack.isEmpty()) {
				while(getPriority(s[i])<=getPriority(operatorStack.peek())) {
					calculateExpression();
					if(operatorStack.isEmpty())
						break;
					else continue;
				}
				}
				operatorStack.push(s[i]);
			}
			else
				operandStack.push(Integer.parseInt(s[i]));
		}
		while(!operatorStack.isEmpty()) {
			calculateExpression();		}
		return operandStack.pop();
	}
	static void evaluate(String s) {
		String str[]=new String[s.length()];
		for(int i=0;i<s.length();i++) {
			str[i]=Character.toString(s.charAt(i));
		}
		System.out.println("Result is: "+evaluateExpression(str));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="2*4-6+7/7+1*2^4";
		System.out.println("Given Expression: "+s);
	    evaluate(s);
	}

}

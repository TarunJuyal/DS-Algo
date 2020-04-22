package StackAndQueue;

import java.util.Stack;

public class EvaluationOfInfixExpressionSimple {
	static Stack<Integer> operandStack=new Stack<>();
	static int calculate(int firstOp,char Op,int secondOp) {
		int result=0;
		//System.out.println("operator"+Op);
		if(Op=='+')
			result=firstOp+secondOp;
		if(Op=='-')
			result=firstOp-secondOp;
		if(Op=='*')
			result=firstOp*secondOp;
		if(Op=='/')
			result=firstOp/secondOp;
		//System.out.println("currentResult"+result);
		return result;
	}
	static int evaluate(char s[]) {
		operandStack.push(Character.getNumericValue(s[0])); //first element has to be a number
		int i=1;
		while(i<s.length) {
			if(s[i]=='+'||s[i]=='-'||s[i]=='*'||s[i]=='/') {
					int operand=Character.getNumericValue(s[i+1]);
					//System.out.println("current"+s[i]);
					operandStack.push(calculate((int)operandStack.pop(),s[i],operand));
					i+=2;
				}
			else 
				i++;
		}
		return operandStack.pop();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="2*4-6+5/7+1*2+4";
		System.out.println("Given Expression: "+s);
		System.out.println("Result: "+evaluate(s.toCharArray()));
	}

}

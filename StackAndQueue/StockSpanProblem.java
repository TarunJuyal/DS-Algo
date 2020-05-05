package StackAndQueue;

/*The span of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, 
 * for which the price of the stock on the current day is less than or equal to its price on the given day.
 */

import java.util.Stack;

public class StockSpanProblem {
	static void calculateSpan(int[] price,int[] span) {
		Stack<Integer> indexStack = new Stack<>();
		span[0]=1;                                                //first element span value will always be 1.
		indexStack.push(0);  
		for(int i=1;i<price.length;i++) {
			while(!indexStack.isEmpty() && price[indexStack.peek()]<=price[i])
				indexStack.pop();
			if(indexStack.isEmpty())
				span[i]=i+1;
			else
				span[i]=(i-indexStack.peek());
			indexStack.push(i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int price[]= {100,80,60,70,60,75,85};
		int span[]=new int[price.length];
		calculateSpan(price,span);
		System.out.println("Span values are: ");
		for(int i:span)
			System.out.print(i+" ");
	}                                                                                          

}

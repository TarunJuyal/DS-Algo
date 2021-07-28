/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
*/

// 1. brute force : O(n^2)
public class Solution {
    public int maxProfit(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }
}

// 2. Use idea like trap rain water O(n) with O(n) extra space
class Solution {
    public int maxProfit(int[] prices) {
        int[] min=new int[prices.length];
        int[] max=new int[prices.length];
        int minvalue=prices[0],maxvalue=prices[prices.length-1];
        min[0]=prices[0];max[max.length-1]=prices[prices.length-1];
        for(int i=1;i<min.length;i++){
            if(prices[i]<minvalue)
                minvalue=prices[i];
            min[i]=minvalue;
        }
        for(int i=prices.length-2;i>=0;i--){
            if(prices[i]>maxvalue)
                maxvalue=prices[i];
            max[i]=maxvalue;
        }
        int result=0;
        for(int i=0;i<prices.length;i++){
            result=Math.max(result,max[i]-min[i]);
        }
        return result>0?result:0;
    }
}

// 3. One pass O(n)
public class Solution {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}

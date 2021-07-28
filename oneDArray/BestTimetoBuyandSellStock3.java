// atmost 2 transactions

// 1.  DP :   O(n)  with O(n) space
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
		return 0;
	}
	int[] left = new int[prices.length];
	int[] right = new int[prices.length];
      
  //track the maximum profit for transactions before i
	left[0] = 0; 
	int min = prices[0];
	for (int i = 1; i < prices.length; i++) {
		min = Math.min(min, prices[i]);
		left[i] = Math.max(left[i - 1], prices[i] - min);
	}
      
  //track the maximum profit for transactions after i
	right[prices.length - 1] = 0;
	int max = prices[prices.length - 1];
	for (int i = prices.length - 2; i >= 0; i--) {
		max = Math.max(max, prices[i]);
		right[i] = Math.max(right[i + 1], max - prices[i]);
	}
   
	int profit = 0;
	for (int i = 0; i < prices.length; i++) {
		profit = Math.max(profit, left[i] + right[i]);
	}
 
	return profit;
    }
}

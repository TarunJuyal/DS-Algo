// 1. Brute Force : O(n^2)
static int maxSubarrayProduct(int arr[])
    {
        int result = arr[0];
        int n = arr.length;
        for (int i = 0; i < n; i++)
        {
            int mul = arr[i];
            for (int j = i + 1; j < n; j++)
            {
                result = Math.max(result, mul);
                mul *= arr[j];
            }
            // updating the result for (n-1)th index.
            result = Math.max(result, mul);
        }
        return result;
    }

// 2. Using approach like max sum of contiguous array O(n)
static int maxSubarrayProduct(int arr[])
    {
        int n = arr.length;
        int max_ending_here = 1;
        int min_ending_here = 1;
        int max_so_far = 0;
        int flag = 0;
        for (int i = 0; i < n; i++)
        {
            if (arr[i] > 0)
            {
                max_ending_here = max_ending_here * arr[i];
                min_ending_here
                    = min(min_ending_here * arr[i], 1);
                flag = 1;
            }
            else if (arr[i] == 0)
            {
                max_ending_here = 1;
                min_ending_here = 1;
            }
            else {
                int temp = max_ending_here;
                max_ending_here
                    = max(min_ending_here * arr[i], 1);
                min_ending_here = temp * arr[i];
            }
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }
 
        if (flag == 0 && max_so_far == 0)
            return 0;
        return max_so_far;
    }

// 3. 2 traversals 1 from start other from end find max product in both directiom whichever max is the ans.(have to handle 0's)   O(n)
static int max_product(int arr[], int n)
{
    int max_fwd = Integer.MIN_VALUE,
        max_bkd = Integer.MIN_VALUE;
    boolean isZero=false;
    int max_till_now = 1;
    for (int i = 0; i < n; i++)
    {
        max_till_now = max_till_now * arr[i];
        if (max_till_now == 0)
        {
            isZero=true;
            max_till_now = 1;
            continue;
        }
        if (max_fwd < max_till_now)
            max_fwd = max_till_now;
    }
    max_till_now = 1;
    for (int i = n - 1; i >= 0; i--)
    {
        max_till_now = max_till_now * arr[i];
        if (max_till_now == 0)
        {
            isZero=true;
            max_till_now = 1;
            continue;
        }
        if (max_bkd < max_till_now)
            max_bkd = max_till_now;
    }
    int res = Math. max(max_fwd, max_bkd);
    if(isZero)
    return Math.max(res, 0);    
    return res;
}

/* 4.
The idea is to traverse array from left to right keeping two variables minVal and maxVal which represents the minimum and maximum product value till 
the ith index of the array. Now, if the ith element of the array is negative that means now the values of minVal and maxVal will be swapped as value 
of maxVal will become minimum by multiplying it with a negative number. Now, compare the minVal and maxVal.       O(n)
*/
static int maxProduct(int arr[], int n)
    {
        int minVal = arr[0];
        int maxVal = arr[0];
        int maxProduct = arr[0];
        for (int i = 1; i < n; i++)
        {
            if (arr[i] < 0)
            {
                int temp = maxVal;
                maxVal = minVal;
                minVal =temp;
            
            }
            maxVal = Math.max(arr[i], maxVal * arr[i]);
            minVal = Math.min(arr[i], minVal * arr[i]);
            maxProduct = Math.max(maxProduct, maxVal);
        }
        return maxProduct;
    }

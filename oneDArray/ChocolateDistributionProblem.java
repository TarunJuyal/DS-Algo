/*
Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. 
There are M students, the task is to distribute chocolate packets among M students such that :
1. Each student gets exactly one packet.
2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.
*/

// 1. make subset of length M and check for min differenece between max and min of each.

// 2. Sort and check diff of i & (i+m-1) with min difference O(nlogn).
static int findMinDiff(int arr[],int m)
    {
        if (m == 0 || arr.length == 0)
            return 0;
        Arrays.sort(arr);
        if (arr.length < m)
           return -1;
        int min_diff = Integer.MAX_VALUE;
        for (int i = 0; i + m - 1 < arr.length; i++)
        {
            int diff = arr[i+m-1] - arr[i];
            if (diff < min_diff)
                min_diff = diff;
        }
        return min_diff;
    }

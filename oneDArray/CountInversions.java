/*
For an array, inversion count indicates how far (or close) the array is from being sorted.  
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
*/

// 1. Brute Force : O(n^2)
//    compare each with the remaining

// 2. Modified Merge Sort : time: O(nlogn)    space: O(n)
//     total number of inversions that needs to be added are the number of inversions in the left subarray, right subarray, and merge().

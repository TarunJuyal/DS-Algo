/*
Given an array and a range [lowVal, highVal], partition the array around the range such that array is divided in three parts. 
1) All elements smaller than lowVal come first. 
2) All elements in range lowVal to highVVal come next. 
3) All elements greater than highVVal appear in the end. 
The individual elements of three sets can appear in any order.
*/

// 1. Sort O(nlogn)

// 2. DNF based quicksort us 2 pte start=0 and end=length-1 while(i<=end) if value<low swap i and start increment both, if value >high swap end and i decrement only end else i++
public static void threeWayPartition(int[] arr, int lowVal, int highVal)
    {
        int  n = arr.length;
        int start = 0, end = n-1;
        for(int i = 0; i <= end;)
        {            
            if(arr[i] < lowVal)
            {
                 
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
                i++;
                 
            }
             else if(arr[i] > highVal)
            {
                 
                int temp = arr[end];
                arr[end] = arr[i];
                arr[i] = temp;
                end--;
                  
            }
            else
               i++;
        }
         
    }

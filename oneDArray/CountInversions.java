/*
For an array, inversion count indicates how far (or close) the array is from being sorted.  
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
*/

// 1. Brute Force : O(n^2)
//    compare each with the remaining

// 2. Modified Merge Sort : time: O(nlogn)    space: O(n)
//     total number of inversions that needs to be added are the number of inversions in the left subarray, right subarray, and merge().
static int sort(int[] a,int start,int end){
        int count=0;
        if(start<end){
        int mid=(end+start)/2;
        count+=sort(a,start,mid);
        count+=sort(a,mid+1,end);
        count+=merge(a,start,mid,end);
        }
        return count;
    }
    
    static int merge(int[] a, int start, int mid, int end){
        int[] left = Arrays.copyOfRange(a, start, mid + 1);
        int[] right = Arrays.copyOfRange(a, mid + 1, end + 1);

        int i = 0, j = 0, k = start, count = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                a[k++] = left[i++];
            else {
                a[k++] = right[j++];
                count+= (mid + 1) - (start + i);
            }
        }
        while (i < left.length)
            a[k++] = left[i++];
        while (j < right.length)
            a[k++] = right[j++];
        return count;

    }

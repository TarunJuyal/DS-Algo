package oneDArray;

//Find the Kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the Kth distinct element.
import java.util.Arrays;

class KthLargestElement {
    static public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int j=nums.length-1;
        for(int i=0;i<k-1;i++){j--;}
        return nums[j];
    }
    public static void main(String[] args){
        int[] nums= {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
    }
}
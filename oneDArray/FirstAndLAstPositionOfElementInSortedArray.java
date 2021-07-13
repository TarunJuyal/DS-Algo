class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=0,h=nums.length-1,fi=-1,li=-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(nums[mid]<target)
                l=mid+1;
            else if(nums[mid]>target)
                h=mid-1;
            else{
                fi=mid;
                h=mid-1;
            }
        }
        
        l=0;h=nums.length-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(nums[mid]<target)
                l=mid+1;
            else if(nums[mid]>target)
                h=mid-1;
            else{
                li=mid;
                l=mid+1;
            }
        }
        return new int[]{fi,li};
    }
}

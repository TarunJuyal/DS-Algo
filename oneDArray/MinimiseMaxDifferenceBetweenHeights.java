// Given an array nums of integers, for each integer nums[i] we need to choose either x = -k or x = k, and add x to nums[i] (only once).
// Return the smallest possible difference between the maximum value of result and the minimum value of result.

class Solution {
    public int smallestRangeII(int[] nums, int k) {
        if(nums.length==1)
            return 0;
        Arrays.sort(nums);
        int min,max;
        int result=nums[nums.length-1]-nums[0];
        
        for(int i=1;i<nums.length;i++){
                max=Math.max(nums[i-1]+k,nums[nums.length-1]-k);
                min=Math.min(nums[i]-k,nums[0]+k);
                result=(int)Math.min(result,max-min);
        }
        return result;
    }
}

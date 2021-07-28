// using 2 pointer

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); 
        for (int i = 0; i < nums.length; i++) {
           int start = i + 1;
           int end = nums.length - 1;
          if (i > 0 && nums[i] == nums[i - 1])
              continue;
          while (start < end) {
             if (end < nums.length - 1 
                  && nums[end] == nums[end + 1]) {
                 end--;
                 continue;
             }
              if (nums[i] + nums[start] + nums[end] == 0) {
                List<Integer> val = 
                       Arrays.asList(nums[i],nums[start],nums[end]);
                result.add(val);
                start++; end--;
              } else if (nums[i] + nums[start] + nums[end] < 0) {
                start++;
              } else {
                 end--;
              }
          }
        }
        return result;
    }
}

// using hashset
static boolean find3Numbers(int A[],
                                int arr_size, int sum)
    {
        for (int i = 0; i < arr_size - 2; i++) {
            HashSet<Integer> s = new HashSet<Integer>();
            int curr_sum = sum - A[i];
            for (int j = i + 1; j < arr_size; j++) 
            {
                if (s.contains(curr_sum - A[j])) 
                {
                    System.out.printf("Triplet is %d, 
                                        %d, %d", A[i],
                                      A[j], curr_sum - A[j]);
                    return true;
                }
                s.add(A[j]);
            }
        }
        return false;
    }

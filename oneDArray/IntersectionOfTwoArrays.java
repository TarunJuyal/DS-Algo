//Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> temp=new HashMap<>();
		HashMap<Integer,Integer> temp2=new HashMap<>();
		for(int i:nums1)
			temp.put(i, temp.getOrDefault(i, 0)+1);
		for(int i:nums2)
			temp2.put(i, temp2.getOrDefault(i, 0)+1);
		temp.keySet().retainAll(temp2.keySet());
		int result[]=new int[temp.size()];
		int i=0;
		for(Map.Entry<Integer, Integer> entry:temp.entrySet()) {
			result[i]=entry.getKey();
			i++;
		}
		return result;
    }
}

/*Given two integer arrays nums1 and nums2, return an array of their intersection. 
Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order
*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return intersect(nums2,nums1);
        }
        Map<Integer,Integer>  m= new HashMap<Integer,Integer>();
        for(int val:nums1){
            m.put(val,m.getOrDefault(val,0)+1);
        }
        int k=0;
        for(int val:nums2){
            if(m.getOrDefault(val,0)>0){
                nums1[k++]=val;
                m.put(val,m.get(val)-1);
            }
        }
        int ans[]=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=nums1[i];
        }
        return ans;
    }
}

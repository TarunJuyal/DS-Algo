// Given an array of N integers arr[] where each element represents the max number of steps that can be made forward from that element. 
// Find the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then you cannot move through that element.
// Note: Return -1 if you can't reach the end of the array.


//maxReach : keeps track of max jump possible
//step : ensures to not make another jump while still in range of previous jump.

class Solution {
    public int minJump(int[] a) {
        if(a.length<=1)
          return 0;
        if(a[0]==0)
          return -1;
      int maxReach=a[0],step=a[0],jumps=1;
      for(int i=1;i<a.length;i++){
        if(a.length-1==i)
          return jumps;
        maxReach=Math.max(maxReach,i+a[i]);
        step--;
        
        if(step==0){
        jumps++;
          if(i>=maxReach)
            return -1;
          step=maxReach-i;
        }
      }
      return -1;
    }
}

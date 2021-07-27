/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals 
that cover all the intervals in the input.
Example:-
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
*/

// brute force : O(n^2);

// Sort and merge : O(nlogn)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        LinkedList<int[]> merge = new LinkedList<>();
        for(int[] i : intervals){
            if(merge.isEmpty() || merge.getLast()[1]<i[0])
                merge.add(i);
            else
                merge.getLast()[1]=Math.max(merge.getLast()[1],i[1]);
        }
        return merge.toArray(new int[merge.size()][]);
    }
}

// can also use stack

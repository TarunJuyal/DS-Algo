package oneDArray;

//Find the Kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the Kth distinct element.
import java.util.Arrays;

//sort nad return O(nlogn)
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

// using heap O(nlogk)
private static PriorityQueue<Integer> heap=new PriorityQueue<>((first,second)-> second-first);
	public static int getKthLargest(int[] a,int k) {
		if(k<1||k>a.length)
			throw new IllegalStateException();
		for(int i:a) {
			heap.add(i);
			if(heap.size()>a.length-k+1) {
				heap.poll();
			}
		}
		return heap.peek();
	}

// using quickselect   worst O(n^2)    average O(n)
// The idea is, not to do use quicksort , but stop at the point where pivot itself is k’th smallest element.

// quickselect using random pivot to increase efficiency  worst O(n^2)    Expected average O(n)
class Solution {
  public int kthLargest(int[] arr, int k) {
    int n = arr.length;
    int left = 0;
    int right = n - 1;
    Random rand = new Random(0);
    while (left <= right) {
      int choosenPivotIndex = rand.nextInt(right - left + 1) + left;
      int finalIndexOfChoosenPivot = partition(arr, left, right, choosenPivotIndex);
      if (finalIndexOfChoosenPivot == n - k) {
        return arr[finalIndexOfChoosenPivot];
      } else if (finalIndexOfChoosenPivot > n - k) {
        right = finalIndexOfChoosenPivot - 1;
      } else {
        left = finalIndexOfChoosenPivot + 1;
      }
    }
    return -1;
  }
  private int partition(int[] arr, int left, int right, int pivotIndex) {
    int pivotValue = arr[pivotIndex];
    int lesserItemsTailIndex = left;
    swap(arr, pivotIndex, right);
    for (int i = left; i < right; i++) {
      if (arr[i] < pivotValue) {
        swap(arr, i, lesserItemsTailIndex);
        lesserItemsTailIndex++;
      }
    }
    swap(arr, right, lesserItemsTailIndex);
    return lesserItemsTailIndex;
  }
  private void swap(int[] arr, int first, int second) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }
}


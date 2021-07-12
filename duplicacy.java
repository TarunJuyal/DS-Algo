// brute force n^2 nested loop

//Using Hashing

public class duplicacy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {0,1,2,3,3,5,4,2};
        int max=arr[0];
     for(int i =0;i<=arr.length-1;i++) {
     if(arr[i]>max)
      max=arr[i];
     }
    //System.out.println(max);
     int[] a=new int[max+1];
   for(int i =0;i<=arr.length-1;i++) {
  a[arr[i]]++;
   }
  for(int i =0;i<=a.length-1;i++) {
  if(a[i]>1) {
  System.out.println(i +"is duplicate in array");
 }
 }

	}

}

// If given input in natural sequence and only one duplicate element then can use , Sum of given elements - Sum of natural sequence

/* If given input in natural sequence then each value will have its own corresponding index. 
Iterate over array and mark the value at index which is current value of current index as negative of itself.
If already negative value encountered that means that element is duplicate. */

public int repeatedNumber(List<Integer> list) {
  if (list.size() <= 1) {
    return -1;
  }

  for (int i = 0; i < list.size(); i++) {
    if (list.get(Math.abs(list.get(i))) > 0) {
      list.set(Math.abs(list.get(i)), -1 * list.get(Math.abs(list.get(i))));
    } else {
      return Math.abs(list.get(i));
    }
  }

  return 0;
}

// an approach like Floyd Cycle Detection Algo. if given in natural sequence

public int repeatedNumber(List<Integer> list) {
  if (list.size() <= 1)
    return -1;

  int slow = list.get(0);
  int fast = list.get(list.get(0));

  while (fast != slow) {
    slow = list.get(slow);
    fast = list.get(list.get(fast));
  }

  slow = 0;
  while (fast != slow) {
    slow = list.get(slow);
    fast = list.get(fast);
  }
  return slow;
}

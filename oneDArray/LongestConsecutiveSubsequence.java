/*
Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
Example 1:
Input:
N = 7
a[] = {2,6,1,9,4,5,3}
Output:
6
*/

// sort and check O(nlogn)
static int findLongestConseqSubseq(int arr[],  int n)
    {
        Arrays.sort(arr);
        int ans = 0, count = 0;
        ArrayList<Integer> v = new ArrayList<Integer>();
        v.add(arr[0]);
        for (int i = 1; i < n; i++) 
        {
            if (arr[i] != arr[i - 1])
                v.add(arr[i]);
        }
        for (int i = 0; i < v.size(); i++) 
        {
            if (i > 0 &&v.get(i) == v.get(i - 1) + 1)
                count++;
            else
                count = 1;
            ans = Math.max(ans, count);
        }
        return ans;
    }

// Use set. if current value-1 present in set then continue otherwise its a start to a sequence. O(n) with O(n) space
static int findLongestConseqSubseq(int arr[], int n)
    {
        HashSet<Integer> S = new HashSet<Integer>();
        int ans = 0;
        for (int i = 0; i < n; ++i)
            S.add(arr[i]);
        for (int i = 0; i < n; ++i) 
        {
            if (!S.contains(arr[i] - 1)) 
            {
                int j = arr[i];
                while (S.contains(j))
                    j++;
                if (ans < j - arr[i])
                    ans = j - arr[i];
            }
        }
        return ans;
    }

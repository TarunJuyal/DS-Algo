// includes duplicate but have to tell distinct

// sort and return keeping duplicates in account. O(nlogn)
static int thirdMax(int[] a)
    {
        int n = a.length;
        Arrays.sort(a);
        int idx = n - 1 , i , distinctCount = 0;
        while(idx >= 0)
        {
            distinctCount++;
            i = idx - 1;
            while(i >= 0 && a[i] == a[idx])
                i--;
            //no third distinct element
            if(i == -1)
                return a[n - 1];
            idx = i;
            if(distinctCount == 2)
                return a[idx];
        }
        return -1;
    }

// use set
class Solution {
    public int thirdMax(int[] nums) {
        Set <Integer> maxElements = new HashSet <>();
        for(int element : nums)
        {
            maxElements.add(element);
            if(maxElements.size() > 3)
                maxElements.remove(Collections.min(maxElements));
        }
        if(maxElements.size() == 3)
            return Collections.min(maxElements);
        return Collections.max(maxElements);
    }
}

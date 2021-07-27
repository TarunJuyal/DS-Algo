/* Given 2 sorted arrays merge without extra space.
Input: ar1[] = {10};
       ar2[] = {2, 3};
Output: ar1[] = {2}
        ar2[] = {3, 10}
*/

// 1. brute force : make extra array and use 2 pointer but its not allowed. O(n+m)

// 2. Use idea of insertion sort. Take last element of second array and try to put it in its correct position in first array by insertion sort 
//    if possible and in this process switch it with last element of first array. Do this far all elements of second array. O(nm)
static void merge(int m, int n)
{
        for (int i=n-1; i>=0; i--)
        {
            int j, last = arr1[m-1];
            for (j=m-2; j >= 0 && arr1[j] > arr2[i]; j--)
                arr1[j+1] = arr1[j];
            // Check If there was a greater element
            if (j != m-2 || last > arr2[i])
            {
                arr1[j+1] = arr2[i];
                arr2[i] = last;
            }
        }
    }

// 3. Make 3 pointers. i(for array one from start), j(for array two from start), k(for array one from last)
//    if a1[i]<a2[j] then simply increment i. Otherwise swap last element of a1 ie k and cuurent element of a2 ie j and increment j and decrement k.
//    do this until i<=k && j<a2.length.
//    Finally sort both arrays.  O((m+n)log(m+n))
static void merge(int m, int n)
    {
        int i = 0, j = 0, k = n - 1;
        while (i <= k and j < m) {
            if (arr1[i] < arr2[j])
                i++;
            else {
                int temp = arr2[j];
                arr2[j] = arr1[k];
                arr1[k] = temp;
                j++;
                k--;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }


// 4. Check if current element of first array > first element of second array.If true the, swap both and then sort the second array. 
//    Repeat Until a1[a1.length-1]>a2[0].
static void merge(int n, int m)
{
    int i = 0,temp;
    while (arr1[n - 1] > arr2[0])
    {
        if (arr1[i] > arr2[0])
        {
            temp = arr1[i];
            arr1[i] = arr2[0];
            arr2[0] = tem
            Arrays.sort(arr2);
        }
        i++;
    }
}

// 5. GAP METHOD : O((m+n)log(m+n))
private static int nextGap(int gap)
    {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }

    private static void merge(int[] arr1,int[] arr2, int n,int m)
    {
        int i, j, gap = n + m;
        for (gap = nextGap(gap); gap > 0;gap = nextGap(gap)){
            // comparing elements in the first
            // array.
            for (i = 0; i + gap < n; i++)
                if (arr1[i] > arr1[i + gap]) 
                {
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }

            // comparing elements in both arrays.
            for (j = gap > n ? gap - n : 0;              //gap>n comes in play when a2 is much larger than a1
                 i < n && j < m;
                 i++, j++)
                if (arr1[i] > arr2[j])
                {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }

            if (j < m)
            {
                // comparing elements in the
                // second array.
                for (j = 0; j + gap < m; j++)
                    if (arr2[j] > arr2[j + gap]) 
                    {
                        int temp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = temp;
                    }
            }
        }
    }

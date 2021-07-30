// 1. Brute force O(n^2)
int smallestSubWithSum(int arr[], int n, int x)
{
     int min_len = n + 1;
     for (int start=0; start<n; start++)
     {
          int curr_sum = arr[start];
          if (curr_sum > x) return 1;
          for (int end=start+1; end<n; end++)
          {
              curr_sum += arr[end];
              if (curr_sum > x && (end - start + 1) < min_len)
                 min_len = (end - start + 1);
          }
     }
     return min_len;
}

// 2. 2 pointer start and end keep adding until sum<=given when sum>given update minlength (end - start) and sum-=a[start++] O(n)
static int smallestSubWithSum(int arr[], int n, int x)
    {
        int curr_sum = 0, min_len = n + 1;
        int start = 0, end = 0;
        while (end < n) {
            while (curr_sum <= x && end < n)
                curr_sum += arr[end++];
            while (curr_sum > x && start < n) {
                if (end - start < min_len)
                    min_len = end - start;
                curr_sum -= arr[start++];
            }
        }
        return min_len;
    }

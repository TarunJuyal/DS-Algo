// 1. Intersection between first two then results intersection with third.

// 2. Use 3 pointers. Doesn't work when duplicates.  O(n1+n2+n3)

void findCommon(int ar1[], int ar2[], int ar3[])
{
        int i = 0, j = 0, k = 0;
        while (i < ar1.length && j < ar2.length && k < ar3.length)
        {
             if (ar1[i] == ar2[j] && ar2[j] == ar3[k])
             {   System.out.print(ar1[i]+" ");   i++; j++; k++; }
             else if (ar1[i] < ar2[j])
                 i++;
             else if (ar2[j] < ar3[k])
                 j++;
             else
                 k++;
        }
    }

// 3. Use 3 variables to store prev value in each array to handle duplicates.

void findCommon(int ar1[], int ar2[], int ar3[], int n1,
                int n2, int n3)
{
    int i = 0, j = 0, k = 0;
    int prev1, prev2, prev3;
    prev1 = prev2 = prev3 = INT_MIN;
    while (i < n1 && j < n2 && k < n3) {
        while (ar1[i] == prev1 && i < n1)
            i++;
        while (ar2[j] == prev2 && j < n2)
            j++;
        while (ar3[k] == prev3 && k < n3)
            k++;
        if (ar1[i] == ar2[j] && ar2[j] == ar3[k]) {
            cout << ar1[i] << " ";
            prev1 = ar1[i];
            prev2 = ar2[j];
            prev3 = ar3[k];
            i++;
            j++;
            k++;
        }
        else if (ar1[i] < ar2[j]) {
            prev1 = ar1[i];
            i++;
        }
        else if (ar2[j] < ar3[k]) {
            prev2 = ar2[j];
            j++;
        }
        else {
            prev3 = ar3[k];
            k++;
        }
    }
}

// 4. first delete all duplicates in each arra then use a freq array whoseever frequency 3 its an ans.

// 5. Use Set for first 2 and then check if elements of third present in them then insert in set thats the answer.

// (XOR all given in array) XOR (XOR all upto n) = missing Number.

static int getMissingNo(int a[])
    {
        int x1 = a[0];
        int x2 = 0;
        for (int i = 1; i < a.length; i++)
            x1 = x1 ^ a[i];
        for (int i = 1; i <= a.length; i++)
            x2 = x2 ^ i;
        return (x1 ^ x2);
    }

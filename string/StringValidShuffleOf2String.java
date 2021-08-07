//shuffled string length sum of two lengths characters of two string can be in different position but in same order. Using 2 pointers.

class Test {
  static boolean checkLength(String first, String second, String result) {
    return (first.length() + second.length() != result.length());
  }
  
  static String sortString(String str) {
    char[] charArray = str.toCharArray();
    Arrays.sort(charArray);
    return String.valueOf(charArray);
  }

  static boolean shuffleCheck(String first, String second, String result) {
    if(checkLength(first,second,result))
      return false;
    first = sortString(first);
    second = sortString(second);
    result = sortString(result);
    int i = 0, j = 0, k = 0;
    while (k != result.length()) {
    if (i < first.length() && first.charAt(i) == result.charAt(k))
        i++;
    else if (j < second.length() && second.charAt(j) == result.charAt(k))
        j++;
    else
        return false;
    k++;
    }
   if(i < first.length() || j < second.length()) {
      return false;
    }
    return true;
  }

/*
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
Then for each group, say the number of characters, then say the character. 
Example :
Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
*/

class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        StringBuilder curr = new StringBuilder();
        String prev=countAndSay(n-1);
        int count=0;
        for(int i=0;i<prev.length();i++){
            count++;
            if(i==prev.length()-1 || prev.charAt(i)!=prev.charAt(i+1)){
                curr.append(count).append(prev.charAt(i));
                count=0;
            }
        }
        return curr.toString();
    }
}

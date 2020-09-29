package tries;

import java.util.Map;

/*  Approaches:-
 * 1> Word by Word - Compare two strings than compare the result of this with next one and so on. O(n*m)
 * 2> Char by Char - check char at each index if present in all strings append if not then we have LCP. O(n*m) 
 * 		(Better cause don't have to traverse all string if there is no common prefix)
 * 3>  Divide & Conquer - perform any of the above operation on two half of the data set and concatenate at last O(n*m)
 * 4> Binary Search - Find Smallest string first and use binary search in that string to check if other strings contain it. 
 * 5> Tries Based - Traverse until children don't split or a word doesn't end.
 * */

public class LongestCommonPrefixOperation {
	
	private static Trie trie = new Trie();
	public static String LongestCommonPrefix(String[] arr) {
		if(arr.length==0)
			return "";
		if(arr.length==1)
			return arr[0];
		for(String s: arr)
			trie.add(s);
		return getLCA();
	}
	
	private static String getLCA() {
		String prefix="";
		TrieNode node=trie.getRoot();
		while(node.children.size()==1 && node.isEnd==false) {
			for(Map.Entry<Character, TrieNode> entry:node.children.entrySet())
				node=entry.getValue();
			prefix+=node.data;
		}
		return prefix;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[] = {"flower","flow","flight"};
		System.out.println("Longest common prefix is: "+LongestCommonPrefix(arr));
	}

}

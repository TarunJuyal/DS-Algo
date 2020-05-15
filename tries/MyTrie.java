package tries;

import java.util.HashMap;
import java.util.Map;

class Node{
	char data;
	HashMap<Character,Node> children;
	boolean isEnd;
	Node(char data){
		this.data=data;
		this.children=new HashMap<>();
	}
}
class Trie{
	private Node root;
	private int noOfWords;
	Trie(){
		root=new Node('\0');
		noOfWords=0;
	}
	Node getRoot() {
		return root;
	}
	int getNoOfWords() {
		return noOfWords;
	}
	void add(String word) {
		addWord(word,getRoot());
	}
	void addWord(String word , Node parent) {
		if(word.length()==0) {
			if(!parent.isEnd) {
				parent.isEnd=true;
				noOfWords++;
			}
			return;
		}
		char firstChar=word.charAt(0);
		String remainingWord=word.substring(1);
		Node child=parent.children.get(firstChar);
		if(child==null) {
			child=new Node(firstChar);
			parent.children.put(firstChar, child);
		}
		addWord(remainingWord,child);
	}
	void print() {
		printTrie(getRoot(),"");
	}
	void printTrie(Node parent,String result) {
		if(parent.isEnd)
			System.out.println(result);
		for(Map.Entry<Character, Node> obj:parent.children.entrySet())
			printTrie(obj.getValue(), result+obj.getKey());
	}
	void search(String word) {
		searchTrie(word, getRoot(),"");
	}
	void searchTrie(String word,Node parent,String result) {
		if(word.length()==0) {
			printTrie(parent,result);
			return;
		}
		char firstChar=word.charAt(0);
		Node child=parent.children.get(firstChar);
		if(child==null) {
			System.out.println("No such word found!!");
			return;
		}
		searchTrie(word.substring(1), child, result+firstChar);
	}
}
public class MyTrie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie=new Trie();
		trie.add("akash");
		trie.add("ram");
		trie.add("akshay");
		trie.add("aniket");
		trie.add("ramesh");
		trie.print();
		System.out.println("search*************");
		trie.search("ak");
	}

}

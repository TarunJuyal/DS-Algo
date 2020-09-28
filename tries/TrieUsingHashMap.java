package tries;

import java.util.HashMap;
import java.util.Map;

//preorder and post order traversal possible.

class Trie{
	private class Node{
		char data;
		HashMap<Character,Node> children;
		boolean isEnd;
		Node(char data){
			this.data=data;
			this.children=new HashMap<>();
		}
	}
	private Node root;
	private int noOfWords;
	Trie(){
		root=new Node('\0');
		noOfWords=0;
	}

	int countWords() {
		return noOfWords;
	}
	void add(String word) {
		addWord(word,root);
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
		if(root.children.size()==0)
			throw new RuntimeException("Trie is empty");
		printTrie(root,"");
	}
	void printTrie(Node parent,String result) {
		if(parent.isEnd)
			System.out.println(result);
		for(Map.Entry<Character, Node> obj:parent.children.entrySet())
			printTrie(obj.getValue(), result+obj.getKey());
	}
	void autoComplete(String word) {
		if(word==null)
			throw new RuntimeException("Can't have a null value");
		autoCompleteTrie(word, root,"");
	}
	void autoCompleteTrie(String word,Node parent,String result) {
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
		autoCompleteTrie(word.substring(1), child, result+firstChar);
	}
	
	public boolean contains(String word) {
		if(word==null)
			return false;
		Node current=root;
		for(char ch:word.toCharArray()) {
			Node child=current.children.get(ch);
			if(child==null)
				return false;
			current=child;
		}
		return current.isEnd;
 	}
	
	public boolean containsRecursive(String word) {
		if(word == null)
			return false;
		return contains(word, root);
	}
	private boolean contains(String word,Node parent) {
		if(word.length()==0)
			return parent.isEnd;
		Node child=parent.children.get(word.charAt(0));
		if(child==null)
			return false;
		return contains(word.substring(1), child);
	}
	
	public void remove(String word) {
		if(word==null)
			throw new RuntimeException("word can't be null");
		remove(word,root);
	}
	private void remove(String word,Node parent) {
		if(word.length()==0) {
				if(!parent.isEnd) {
					System.out.println("No such word found!!");
					return;
				}
				parent.isEnd=false;
				noOfWords--;
				return;
			}
		char firstChar=word.charAt(0);
		String remainingString=word.substring(1);
		Node child=parent.children.get(firstChar);
		if(child==null) {
			System.out.println("No such word found!!");
			return;
		}
		remove(remainingString,child);
		
		//remove from memory
		if(child.children.size()==0 && !child.isEnd)
			parent.children.remove(child.data);
	}
}
public class TrieUsingHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie=new Trie();
		trie.add("car");
		trie.add("card");
		trie.add("care");
		trie.add("careful");
		trie.add("egg");
		trie.print();
		System.out.println("Contains: "+trie.contains("egg"));
		trie.remove("care");
		System.out.println("*****After deletion******");
		trie.print();
		System.out.println("******autocomplete*******");
		trie.autoComplete("car");
		System.out.println(trie.countWords());
		System.out.println("Contains: "+trie.containsRecursive("care"));
	}

}

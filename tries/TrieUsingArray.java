package tries;

class Tries{
	private static int ALPHABET_SIZE=26;
	
	private class Node{
		char value;
		Node[] children= new Node[ALPHABET_SIZE];;
		boolean isEnd;
		public Node(char value){
			this.value=value;
		}
		@Override
		public String toString() {
			return "value= "+value;
		}
	}
	private Node root=new Node(' ');
	private int wordCount;
	
	public int getTotalNumberOfWords() {
		return wordCount;
	}
	
	public void insert(String word) {
		Node current=root;
		for(char ch:word.toCharArray()) {
			int index=ch-'a';
			if(current.children[index]==null)
				current.children[index]=new Node(ch);
			current=current.children[index];
		}
		current.isEnd=true;
		wordCount++;
	}
}

public class TrieUsingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tries trie = new Tries();
		trie.insert("cat");
		trie.insert("can");
	}

}

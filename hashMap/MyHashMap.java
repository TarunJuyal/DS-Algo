package hashMap;

class KeyValuePair<K,V>{
	K key;
	V value;
	public KeyValuePair(K key,V value) {
		this.key=key;
		this.value=value;
	}
	@Override
	public boolean equals(Object object) {
		if(this==object)
			return true;
		if(object instanceof KeyValuePair) {
			KeyValuePair<K,V> keyValuepair= (KeyValuePair) object;
			if(this.key.equals(keyValuepair.key))
				return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "[key=" + key + ", value=" + value + "]";
	}
	
}
class Node<T> {
	T data;
	Node<T> next;
	Node(T data){
		this.data=data;
	}
}
class LinkList<T>{
	Node<T> start,tail;
	void addInlast(T data) {
		Node<T> node=new Node<>(data);
		if(start==null) {
			tail=start=node;
			return;
		}
		tail.next=node;
		tail=node;
	}
	void print() {
		Node<T> temp = start;
		while(temp!=null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	T deleteNodeAt(int index) {
		if(index==0) {
			Node<T> deleted=start;
			start=start.next;
			return deleted.data;
		}
		int i=0;
		Node<T> temp=start;
		while(i<index-1) {
			temp=temp.next;
			i++;
		}
		Node<T> deleted=temp.next;
		temp.next=temp.next.next;
		return deleted.data;
	}
	T getAtIndex(int index) {
		int i=0;
		Node<T> temp =start;
		while(i<index) {
			i++;
			temp=temp.next;
		}
		return temp.data;
	}
	int search(T data) {
		int index=0;
		Node<T> temp=start;
		while(temp!=null) {
			if(temp.data.equals(data))
				return index;
			index++;
			temp=temp.next;
		}
		return -1;
	}
}
class HashMap<K,V>{
	LinkList<KeyValuePair<K,V>> buckets[];
	static final int DEFAULT_CAPACITY=10;
	int size;
	public HashMap() {
		this(DEFAULT_CAPACITY);
	}
	HashMap(int capacity){
		buckets=new LinkList[capacity];
	}
	private int hashFunction(K key) {
		int hashCode= Math.abs(key.hashCode());
		int bucketIndex=hashCode % buckets.length;
		return bucketIndex;
	}
	V put(K key,V value) {
		int bucketIndex=hashFunction(key);
		LinkList<KeyValuePair<K,V>> bucket=buckets[bucketIndex];
		KeyValuePair<K,V> keyValuePair=new KeyValuePair<>(key, value);
		if(bucket==null) {
			bucket=new LinkList<KeyValuePair<K,V>>();
			bucket.addInlast(keyValuePair);
			buckets[bucketIndex]=bucket;
			size++;
		}
		else {
			int index=bucket.search(keyValuePair);
			if(index==-1) {
				bucket.addInlast(keyValuePair);
				size++;
			}
			else {
				KeyValuePair<K,V> keyValueTemp=bucket.getAtIndex(index);
				keyValueTemp.value=value;
			}
		}
		return value;
	}
	V get(K key) {
		int bucketIndex=hashFunction(key);
		LinkList<KeyValuePair<K,V>> bucket=buckets[bucketIndex];
		KeyValuePair<K,V> keyValuePair=new KeyValuePair<>(key, null);
		if(bucket==null) {
			return null;
		}
		else {
			int index=bucket.search(keyValuePair);
			if(index==-1) {
				return null;
			}
			else {
				KeyValuePair<K,V> keyValueTemp=bucket.getAtIndex(index);
				return keyValueTemp.value;
			}
		}
	}
	void print() {
		for(LinkList<KeyValuePair<K,V>> bucket : buckets) {
			if(bucket!=null) {
				bucket.print();
			}
		}
	}
	V remove(K key) {
		int bucketIndex=hashFunction(key);
		LinkList<KeyValuePair<K,V>> bucket=buckets[bucketIndex];
		KeyValuePair<K,V> keyValuePair=new KeyValuePair<>(key, null);
		if(bucket==null) {
			return null;
		}
		else {
			int index=bucket.search(keyValuePair);
			if(index==-1) {
				return null;
			}
			else {
				KeyValuePair<K,V> keyValueTemp=bucket.deleteNodeAt(index);
				return keyValueTemp.value;
			}
		}
	}
	boolean containsKey(K key) {
		int bucketIndex=hashFunction(key);
		LinkList<KeyValuePair<K,V>> bucket=buckets[bucketIndex];
		KeyValuePair<K,V> keyValuePair=new KeyValuePair<>(key, null);
		if(bucket==null) {
			return false;
		}
		else {
			int index=bucket.search(keyValuePair);
			if(index==-1) {
				return false;
			}
			else {
				return true;
			}
		}
	}

}
public class MyHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map=new HashMap<>();
		map.put("tim",2222);
		map.put("ram",3333);
		map.put("shyam",4444);
		map.put("ram",7777);
		map.put("tarun",888);
		map.put("juyal",66);
		map.print();
		System.out.println(map.get("shyam"));
		System.out.println(map.remove("ram"));
		map.print();
		System.out.println(map.containsKey("ram"));
	}

}

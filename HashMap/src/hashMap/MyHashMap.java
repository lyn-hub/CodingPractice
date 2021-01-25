package hashMap;

import java.util.*;


public class MyHashMap <K, V> implements Map<K, V>{
    //Node is a static class of MyHashMap, since it is
	//very closely bonded to my HashMap class
	//we probably need to access this class outside from MyHashMap class.
	public static class Node<K, V> {
		final K key;
		V value;
		Node <K, V> next;
		Node (K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
		
		public void setValue (V value) {
			this.value = value;
		}
	}
	
    //static final variable are global constants
	private static final int DEFAULT_CAPACITY = 16;
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;
	private static final float SCALE_FACTOR = 1.5f;
	
	
	private Node< K, V>[] array;
	private int size;
	private float loadFactor;
	
	public MyHashMap() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}
	
	public MyHashMap (int cap, float loadFactor) {
		if (cap <= 0) {
			throw new IllegalArgumentException("cap can not be <= 0");
		}
		this.array = (Node<K, V>[]) (new Node[cap]);
		this.size = 0;
		this.loadFactor = loadFactor;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		Arrays.fill(this.array, null);
		size = 0;
	}
	
	private int hash(K key) {
		// null key
		if (key == null) {
			return 0;
		}
		
		//guarantee non-nagative
		return key.hashCode() & 0x7FFFFFFF;
	}
	
	private int getIndex(K key) {
		return hash(key) % array.length;
	}
	
	private boolean equalsValue (V v1, V v2) {
		//v1, v2 all possible to be null
		return v1 == v2 || v1 != null && v1.equals(v2);
	}
	
	//traverse the whole array, and traverse each of the linked list in the array
	public boolean containsValue (V value) {
		if (isEmpty()) {
			return false;
		}
		for (Node<K, V> node : array) {
			while (node != null) {
				if (equalsValue (node.value, value)) {
					return true;
				}
				node = node.next;
			}
		}
		return false;
	}
	
	private boolean equalsKey(K k1, K k2) {
		return k1 == k2 || k1 != null && k1.equals(k2);
	}
	
	public boolean containsKey (K key) {
		//get the index of the key
		int index = getIndex(key);
		//find the head of the LinkedList
		Node<K, V> node = array[index];
		//traverse all the nodes in this LinkedList
		while (node !=  null) {
			if (equalsKey(node.key, key)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}
	
	//if key does not exist in the HashMap, return null
	public V get(K key) {
		//get the index of the key
		int index = getIndex(key);
		//find the head of the LinkedList
		Node<K, V> node = array[index];
		while (node != null) {
			if (equalsKey(node.key, key)) {
				return node.value;
			}
			node = node.next;
		}
		return null;
	}
	
	//insert/update
	//if the key already exists, return the old value
	//if the key not exists, return null
	public V put (K key, V value) {
		//find the index of the key
		int index = getIndex(key);
		//find the head and traverse this LinkedList
		//if find the key, then return the old value
		Node<K,V> head = array[index];
		Node<K, V> node = head;
		while (node != null) {
			if (equalsKey(node.key, key)) {
				V result = node.value;
				node.value = value;
				return result;
			}
			node = node.next;
		}
		//if not find the key, then append it to the head of the LinkedList
		//create a newNode
		Node<K, V> newNode = new Node(key, value);
		//insert the newNode before the head
		newNode.next = head;
		//let the index points to the newNode
		array[index] = newNode;
		size++;
		//rehashing if necessary.
		if (needRehashing()) {
			rehashing();
		}
		return null;
	}
	
	private boolean needRehashing() {
		//float loadFactor
		float ratio = (size + 0.0f) /array.length;
		return ratio >= loadFactor;
	}
	
	private void rehashing() {
		Node<K, V>[] oldArray = array;
		array = (Node<K, V>[]) (new Node[(int) (array.length * SCALE_FACTOR)]);
		for (Node<K, V> node : oldArray) {
			while (node != null) {
				Node<K, V> next = node.next;
				// find the new index  of the node's key in new array
				int index = getIndex(node.key);
				//connect the node and the new array
				node.next  = array[index];
				//let the array[index] points to the new head
				array[index] = node;
				//process the next node in old array;
				node = next;
			}
		}
	}
	
	public V remove (K key) {
		//get index
		//delete operation on the linked list
		//size--
		int index = getIndex(key);
		Node <K, V> node = array[index];
		Node <K, V> pre = null;
		while (node != null) {
			if (equalsKey(node.key, key)) {
				if (pre != null) {
					pre.next = node.next;
				} else {
					array[index] = node.next;
				}
				size--;
				return node.value;
			}
			pre = node;
			node = node.next;
		}
		return null;
	}	
	
	public Set<Node<K, V>> entrySet() {
		Set<Node<K, V>> set = new HashSet<>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				Node<K, V> head = array[i];
				while (head != null) {
				  set.add(head);
				  head = head.next;
				}
				
		     }
	    }
		
		return set;
	}
	
		
}

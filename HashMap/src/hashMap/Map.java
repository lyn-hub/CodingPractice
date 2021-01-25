package hashMap;

import java.util.Set;
import hashMap.MyHashMap.Node;

public interface Map<K, V> {
	
	int size();
	
	boolean isEmpty();
	
	void clear();
	
	boolean containsKey(K key);
	
	boolean containsValue(V value);

	V get(K key);
	
	V put(K key, V value);
	
	Set<Node<K, V>> entrySet();
	
}

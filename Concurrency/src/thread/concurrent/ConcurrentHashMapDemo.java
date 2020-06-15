package thread.concurrent;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

	public static void main(String[] args) {
		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();
		map.put(0, "Anupom");
		map.put(1, "Roy");
		map.put(0, "Chandan");
		//map.remove(0);
		System.out.println(map);
		
		// Method of Concurrent Map
		
		// V putIfAbsent(K key, V value);
		map.putIfAbsent(0, "Mr.");
		map.putIfAbsent(3, "Roy");
		System.out.println(map);
		
		// boolean remove(Object key, Object value);
		map.remove(0, "Hello");
		System.out.println(map);
		
		// boolean replace( K key, V oldValue, V newValue);
		map.replace(0, "Chandan", "Anupom");
		System.out.println(map);
		
		// V replace(K key, V value);
		// map.replace(0, "Adric");
		System.out.println(map.replace(0, "Adric"));
	}

}

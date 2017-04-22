package cn.com.sky.algorithms.interview;

/**
 * 自己简单实现HashMap
 */
public class HashMap<K, V> {

	Entry[] entry;

	private int size = 16;

	private int count = 0;

	public HashMap() {
		entry = new Entry[16];
	}

	static class Entry<K, V> {
		int hash;
		K key;
		V value;
		Entry<K, V> next;

		Entry(int hash, K key, V value, Entry<K, V> next) {
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}

	}

	public int size() {
		return size;
	}

	public int getCount() {
		return count;
	}

	private int hash(K k) {
		return k.hashCode();
	}

	private int index(int hash) {
		return hash % size;
	}

	public V remove(K k) {
		int hash = hash(k);
		int index = index(hash);

		Entry<K, V> first = entry[index];
		if (first != null) {
			Entry<K, V> pre = first;
			for (Entry<K, V> e = first; e != null; pre = e, e = e.next) {
				if (e.hash == hash && (k == e.key || k.equals(e.key))) {
					if (pre == e) {
						entry[index] = e.next;
					}

					pre.next = e.next;
					count--;
					return e.value;
				}
			}

		}

		return null;
	}

	public void put(K k, V v) {
		int hash = hash(k);
		int index = index(hash);

		for (Entry<K, V> e = entry[index]; e != null; e = e.next) {
			if (e.hash == hash && (k == e.key || k.equals(e.key))) {
				e.value = v;
				return;
			}

		}

		Entry<K, V> e = new Entry<K, V>(hash, k, v, entry[index]);
		entry[index] = e;
		count++;
	}

	public V get(K k) {
		int hash = hash(k);
		int index = index(hash);

		for (Entry<K, V> e = entry[index]; e != null; e = e.next) {
			if (e.hash == hash && (k == e.key || k.equals(e.key))) {
				return e.value;
			}
		}

		return null;
	}

}

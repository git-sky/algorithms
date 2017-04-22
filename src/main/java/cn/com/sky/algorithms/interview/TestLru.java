package cn.com.sky.algorithms.interview;

public class TestLru {
	public static void main(String[] args) {
		Lru lru = new Lru(10);

		for (int i = 0; i < 100; i++) {
			lru.put("" + i);
			lru.print();
		}

		for (int i = 0; i < 100; i++) {
			lru.put("" + i);
			lru.print();
		}

		lru.get("" + 95);
		lru.get("" + 91);
		lru.print();
	}
}

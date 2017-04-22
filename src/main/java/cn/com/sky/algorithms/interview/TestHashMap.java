package cn.com.sky.algorithms.interview;

public class TestHashMap {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();

		map.put("a", "1");
		map.put("a", "2");
		map.put("a", "3");
		map.put("a", "5");

		map.put("b", "3");
		map.put("b", "c");

		System.out.println(map.get("a"));
		System.out.println(map.get("b"));
		System.out.println(map.getCount());

		System.out.println(map.remove("a"));
		System.out.println(map.getCount());
		System.out.println(map.remove("b"));
		System.out.println(map.getCount());

		System.out.println(map.remove("a"));
		System.out.println(map.getCount());
		System.out.println(map.remove("b"));
		System.out.println(map.getCount());
		System.out.println(map.remove("a"));
		System.out.println(map.getCount());
		System.out.println(map.remove("b"));
		System.out.println(map.getCount());
		System.out.println(map.remove("a"));
		System.out.println(map.getCount());
		System.out.println(map.remove("b"));
		System.out.println(map.getCount());

	}

}

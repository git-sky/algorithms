package cn.com.sky.algorithms.others.classical;

import java.util.HashMap;
import java.util.Iterator;

import org.junit.Test;

public class TestString {

	// 找出字符串的最长不重复子串，输出长度
	@Test
	public void get() {
		// 长度
		HashMap<Character, Integer> lengthMap = new HashMap<Character, Integer>();
		// 位置
		HashMap<Character, Integer> posMap = new HashMap<Character, Integer>();
		String s = "asdfjoiqrfasadkfjasdjqoiwernsadfjdfasdfqweirwefnasdfwoeiorwef";

		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);

			if (lengthMap.containsKey(c)) {

				int len = lengthMap.get(c);
				lengthMap.put(c, len > i - posMap.get(c) ? len : i - posMap.get(c));
			} else {
				lengthMap.put(c, 0);
			}

			posMap.put(c, i);

		}

		Iterator<Character> iter = lengthMap.keySet().iterator();

		while (iter.hasNext()) {
			Character ch = iter.next();
			int length = lengthMap.get(ch);
			System.out.println(ch + ":" + length);
			System.out.println(posMap.get(ch));
		}

	}
}

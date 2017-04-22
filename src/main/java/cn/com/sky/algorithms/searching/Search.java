package cn.com.sky.algorithms.searching;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计字符串中各个字符的个数，并打印出现次数最多的字符
 */
public class Search {

	public static void main(String args[]) {
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		int k = 0;
		char a = 0;
		int b = 0;
		String s = "addbscaddd个地方高高高高高发给assaab发bas鬼放cc放风地方a";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int vv = 0;

			if (m.containsKey(ch)) {
				vv = Integer.parseInt(m.get(ch).toString()) + 1;
				m.put(ch, vv);
			} else {
				m.put(ch, 1);
			}
		}
		for (Map.Entry<Character, Integer> p : m.entrySet()) {
			k++;

			System.out.println(p.getKey() + ": " + p.getValue());
			if (k == 1) {
				a = p.getKey();
				b = p.getValue();
			} else {
				if (b < p.getValue()) {
					a = p.getKey();
					b = p.getValue();
				}
			}

		}
		System.out.println("数量最多的字符是：" + a + "  数目是：" + b);

	}
}

// public class Search {
// public static void main(String args[]) {
// String s = "abscadddasa";
// int len = s.length();
// char[][] o = new char[len][2];
// System.out.println(s.length());
// for (int i = 0; i < len; i++) {
// for (int j = 0; j < len; j++) {
// if (o[j][0] == s.charAt(i)) {
// o[j][1]++;
// break;
// } else {
// o[i][0] = s.charAt(i);
// o[i][1] = 1;
// }
// }
//
// }
// for(int i=0;i<len;i++)
// System.out.println(o[i][0]+": "+o[i][1]);
// }
// }

// public class Search {
// int count;
// char ch;
//
// public static void main(String args[]) {
//
// StringBuffer sb = new StringBuffer("abscadddasa");
//
// for (int i = 0; i < sb.length(); i++) {
// char temp = sb.charAt(i);
//
// }
// }
// }

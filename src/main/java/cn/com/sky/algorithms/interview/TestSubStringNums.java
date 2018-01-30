package cn.com.sky.algorithms.interview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestSubStringNums {

	@Test
	public void test() {
		String s1 = "abcmnabcdefgabcxyzabcabc";
		String s2 = "abc";
		int count = count2(s1, s2);
		System.out.println(count);
	}

	private int count(String str, String regex) {

		int count = 0;

		Matcher mat = Pattern.compile(regex).matcher(str);
		while (mat.find()) {
			count++;
		}
		return count;
	}

	private int count2(String s, String ss) {
		int count = 0;

		int index = -1;
		while ((index = s.indexOf(ss)) != -1) {
			s = s.substring(index + ss.length());
			count++;
		}
		return count;
	}

}

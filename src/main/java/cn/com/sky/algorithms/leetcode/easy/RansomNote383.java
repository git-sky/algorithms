package cn.com.sky.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * <pre>
 * 
 * 383. Ransom Note
 * 
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * 
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * 
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 
 * </pre>
 */
public class RansomNote383 {

	@Test
	public void solution() {
		String ransomNote = "aa";
		String magazine = "ab";

		boolean b = canConstruct(ransomNote, magazine);
		System.out.println(b);
	}

	public boolean canConstruct(String ransomNote, String magazine) {
		int[] arr = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			arr[magazine.charAt(i) - 'a']++;
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}

	public boolean canConstruct2(String ransomNote, String magazine) {

		char[] notes = ransomNote.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < notes.length; i++) {
			char element = notes[i];
			if (map.containsKey(element))
				map.put(element, map.get(element) + 1);
			else
				map.put(element, 1);
		}

		char[] magazines = magazine.toCharArray();
		HashMap<Character, Integer> magazineMap = new HashMap<Character, Integer>();
		for (int i = 0; i < magazines.length; i++) {
			char element = magazines[i];
			if (magazineMap.containsKey(element))
				magazineMap.put(element, magazineMap.get(element) + 1);
			else
				magazineMap.put(element, 1);
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			Character key = entry.getKey();
			Integer value = entry.getValue();
			if (!magazineMap.containsKey(key) || magazineMap.get(key) < value) {
				return false;
			}
		}

		return true;

	}
}

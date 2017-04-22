package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

import org.junit.Test;

/**
 * <pre>
 * 
 * 506. Relative Ranks
 * 
 * Given scores of N athletes(运动员), find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 * 
 * Example 1:
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 * 
 * Note:
 * 1.N is a positive(正数) integer and won't exceed 10,000.
 * 2.All the scores of athletes are guaranteed to be unique.
 * 
 * 
 * 
 * </pre>
 */
public class RelativeRanks506 {

	@Test
	public void solution() {
		int[] input = {};
		String[] result = findRelativeRanks(input);
		System.out.println(Arrays.toString(result));
	}

	public String[] findRelativeRanks(int[] nums) {
		String[] result = new String[nums.length];

		return result;

	}

}

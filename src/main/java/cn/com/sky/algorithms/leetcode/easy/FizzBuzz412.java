package cn.com.sky.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * <pre>
 * 
 * 412. Fizz Buzz
 * 
 * Write a program that outputs the string representation of numbers from 1 to n.
 * 
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 * 
 * Example:
 * 
 * n = 15,
 * 
 * Return:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 * </pre>
 */
public class FizzBuzz412 {

	@Test
	public void solution() {
		List<String> list = fizzBuzz(100);
		System.out.println(list);
	}

	public List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList<String>();

		for (int i = 1; i <= n; i++) {

			if (i % 15 == 0) {
				list.add("FizzBuzz");

			} else if (i % 3 == 0) {
				list.add("Fizz");

			} else if (i % 5 == 0) {
				list.add("Buzz");
			} else {
				list.add(String.valueOf(i));
			}

		}
		return list;

	}

}

package cn.com.sky.algorithms.linearlist.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * <pre>
 * 算法：
 * 
 * 中缀表达式转后缀表达式的方法：
 * 1.遇到操作数：直接输出（添加到后缀表达式中）
 * 2.栈为空时，遇到运算符，直接入栈
 * 3.遇到左括号：将其入栈
 * 4.遇到右括号：执行出栈操作，并将出栈的元素输出，直到弹出栈的是左括号，左括号不输出。
 * 5.遇到其他运算符：加减乘除：弹出所有优先级大于或者等于该运算符的栈顶元素，然后将该运算符入栈
 * 6.最终将栈中的元素依次出栈，输出。
 * 例如
 * a+b*c+(d*e+f)*g ----> abc*+de*f+g*+
 * 
 */
public class Compute {

	public static void main(String[] args) {

		String str = "9+(3-1)*3+8/2";

		String end = "931-3*+82/+";

		Map<Character, Integer> operator = new HashMap<Character, Integer>();
		operator.put('*', 2);
		operator.put('/', 2);
		operator.put('+', 1);
		operator.put('-', 1);
		operator.put('(', 0);
		operator.put(')', 0);

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			if (Character.isDigit(c)) {
				System.out.println("output=" + c);
			} else {
				if ((!stack.isEmpty() && c != '(' && operator.get(stack.peek()) > operator.get(c))) {
					System.out.println("pop=" + stack.pop());
					if (c == ')') {
						while (stack.peek() != '(')
							System.out.println("pop=" + stack.pop());
					}
				}
				stack.push(c);
				// System.out.println(c);
			}
		}

	}

}

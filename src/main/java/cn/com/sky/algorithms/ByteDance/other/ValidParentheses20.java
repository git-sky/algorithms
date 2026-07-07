package cn.com.sky.algorithms.ByteDance.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * LeetCode 20. 有效的括号【Easy】
 * 
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 * 
 * 算法原理（栈）：
 * 1. 使用栈存储左括号
 * 2. 遍历字符串：
 *    - 遇到左括号，入栈
 *    - 遇到右括号，检查栈顶是否匹配
 *    - 匹配则出栈，不匹配则返回false
 * 3. 最后检查栈是否为空
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class ValidParentheses20 {

    public static void main(String[] args) {
        ValidParentheses20 solution = new ValidParentheses20();
        
        // 测试用例1：有效括号
        System.out.println("测试用例1: " + solution.isValid("()"));      // true
        // 测试用例2：多个有效括号
        System.out.println("测试用例2: " + solution.isValid("()[]{}"));  // true
        // 测试用例3：不匹配括号
        System.out.println("测试用例3: " + solution.isValid("(]"));      // false
        // 测试用例4：错误顺序
        System.out.println("测试用例4: " + solution.isValid("([)]"));    // false
        // 测试用例5：嵌套括号
        System.out.println("测试用例5: " + solution.isValid("{[]}"));    // true
        // 测试用例6：空字符串
        System.out.println("测试用例6: " + solution.isValid(""));        // true
        // 测试用例7：只有左括号
        System.out.println("测试用例7: " + solution.isValid("("));       // false
        // 测试用例8：只有右括号
        System.out.println("测试用例8: " + solution.isValid(")"));       // false
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                // 遇到右括号
                char top = stack.isEmpty() ? '#' : stack.pop();
                if (top != map.get(c)) {
                    return false;
                }
            } else {
                // 遇到左括号
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
}
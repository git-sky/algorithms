package cn.com.sky.algorithms.leetcode.easy;

import java.util.Stack;

/**
 * <pre>
 * LeetCode 20. 有效的括号【Easy】（字节跳动高频）
 * 
 * 题目描述：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 * 
 * 算法原理（栈）：
 * 1. 遍历字符串，遇到左括号入栈
 * 2. 遇到右括号，检查栈顶是否为对应的左括号
 *    - 如果是，弹出栈顶
 *    - 如果不是或栈为空，返回false
 * 3. 遍历结束后，栈必须为空才是有效的
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * </pre>
 */
public class ValidParentheses20 {

    public static void main(String[] args) {
        ValidParentheses20 solution = new ValidParentheses20();
        
        // 测试用例1：有效括号
        System.out.println("测试用例1: " + solution.isValid("()[]{}")); // true
        
        // 测试用例2：嵌套括号
        System.out.println("测试用例2: " + solution.isValid("[()]{}")); // true
        
        // 测试用例3：无效括号
        System.out.println("测试用例3: " + solution.isValid("(]")); // false
        
        // 测试用例4：错误嵌套
        System.out.println("测试用例4: " + solution.isValid("([)]")); // false
        
        // 测试用例5：空字符串
        System.out.println("测试用例5: " + solution.isValid("")); // true
        
        // 测试用例6：单个括号
        System.out.println("测试用例6: " + solution.isValid("(")); // false
        
        // 测试用例7：完整嵌套
        System.out.println("测试用例7: " + solution.isValid("({[]})")); // true
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // 左括号入栈对应的右括号
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                // 右括号不匹配或栈为空
                return false;
            }
        }
        
        // 栈必须为空才有效
        return stack.isEmpty();
    }
}
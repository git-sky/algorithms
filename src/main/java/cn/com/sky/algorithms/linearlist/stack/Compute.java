package cn.com.sky.algorithms.linearlist.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <pre>
 * 中缀表达式转后缀表达式（逆波兰表达式）【Medium】
 * 
 * 算法原理：
 * 1. 遇到操作数：直接输出（添加到后缀表达式中）
 * 2. 栈为空时，遇到运算符，直接入栈
 * 3. 遇到左括号：将其入栈
 * 4. 遇到右括号：执行出栈操作，并将出栈的元素输出，直到弹出栈的是左括号，左括号不输出
 * 5. 遇到其他运算符：加减乘除：弹出所有优先级大于或者等于该运算符的栈顶元素，然后将该运算符入栈
 * 6. 最终将栈中的元素依次出栈，输出
 * 
 * 运算符优先级：
 * - 乘除(*) /)：优先级2
 * - 加减(+ -)：优先级1
 * - 括号(() )：优先级0（栈内）
 * 
 * 示例：
 * 中缀：9 + (3 - 1) * 3 + 8 / 2
 * 后缀：9 3 1 - 3 * + 8 2 / +
 * 计算结果：20
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * </pre>
 */
public class Compute {

    public static void main(String[] args) {
        // 测试用例1：标准表达式
        String infix1 = "9+(3-1)*3+8/2";
        System.out.println("=== 测试用例1 ===");
        System.out.println("中缀表达式: " + infix1);
        String postfix1 = infixToPostfix(infix1);
        System.out.println("后缀表达式: " + postfix1);
        System.out.println("计算结果: " + evaluatePostfix(postfix1));
        
        // 测试用例2：无括号表达式
        String infix2 = "3+4*2-1";
        System.out.println("\n=== 测试用例2 ===");
        System.out.println("中缀表达式: " + infix2);
        String postfix2 = infixToPostfix(infix2);
        System.out.println("后缀表达式: " + postfix2);
        System.out.println("计算结果: " + evaluatePostfix(postfix2));
        
        // 测试用例3：嵌套括号
        String infix3 = "((1+2)*3-4)/5";
        System.out.println("\n=== 测试用例3 ===");
        System.out.println("中缀表达式: " + infix3);
        String postfix3 = infixToPostfix(infix3);
        System.out.println("后缀表达式: " + postfix3);
        System.out.println("计算结果: " + evaluatePostfix(postfix3));
    }

    /**
     * 中缀表达式转后缀表达式
     */
    public static String infixToPostfix(String infix) {
        // 运算符优先级映射
        Map<Character, Integer> operatorPriority = new HashMap<>();
        operatorPriority.put('*', 2);
        operatorPriority.put('/', 2);
        operatorPriority.put('+', 1);
        operatorPriority.put('-', 1);
        operatorPriority.put('(', 0);  // 左括号在栈内优先级最低
        
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            
            if (Character.isDigit(c)) {
                // 操作数：直接添加到结果
                postfix.append(c);
            } else if (c == '(') {
                // 左括号：入栈
                stack.push(c);
            } else if (c == ')') {
                // 右括号：弹出直到左括号
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();  // 弹出左括号，不输出
            } else {
                // 运算符：弹出优先级>=当前的运算符
                while (!stack.isEmpty() && operatorPriority.get(stack.peek()) >= operatorPriority.get(c)) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        
        // 弹出栈中剩余运算符
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        
        return postfix.toString();
    }

    /**
     * 计算后缀表达式
     */
    public static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int b = stack.pop();
                int a = stack.pop();
                
                switch (c) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            }
        }
        
        return stack.pop();
    }
}
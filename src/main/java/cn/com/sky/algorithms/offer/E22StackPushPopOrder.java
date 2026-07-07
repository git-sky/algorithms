package cn.com.sky.algorithms.offer;

import java.util.Stack;

/**
 * <pre>
 * 剑指Offer 31. 栈的压入、弹出序列【Medium】
 *
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压栈序列，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 *
 * 算法原理（模拟栈操作）：
 * 1. 使用一个辅助栈模拟压入和弹出过程
 * 2. 按压入序列依次将元素压入辅助栈
 * 3. 每次压入后，检查栈顶元素是否等于弹出序列的当前元素
 * 4. 如果相等则弹出，并继续检查下一个弹出元素
 * 5. 如果所有弹出序列的元素都能匹配，则是合法的弹出序列
 *
 * 时间复杂度：O(n)，每个元素最多入栈出栈各一次
 * 空间复杂度：O(n)，辅助栈的最大深度
 * </pre>
 */
public class E22StackPushPopOrder {

    public static void main(String[] args) {
        E22StackPushPopOrder solution = new E22StackPushPopOrder();

        // 测试用例1：合法的弹出序列
        System.out.println("=== 测试用例1：合法的弹出序列 ===");
        int[] push1 = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        System.out.println("弹出序列{4,5,3,2,1}: " + solution.validateStackSequences(push1, pop1)); // true

        // 测试用例2：不合法的弹出序列
        System.out.println("\n=== 测试用例2：不合法的弹出序列 ===");
        int[] pop2 = {4, 3, 5, 1, 2};
        System.out.println("弹出序列{4,3,5,1,2}: " + solution.validateStackSequences(push1, pop2)); // false

        // 测试用例3：弹出顺序与压入顺序相同
        System.out.println("\n=== 测试用例3：弹出顺序与压入顺序相同 ===");
        int[] pop3 = {1, 2, 3, 4, 5};
        System.out.println("弹出序列{1,2,3,4,5}: " + solution.validateStackSequences(push1, pop3)); // true

        // 测试用例4：弹出顺序与压入顺序相反
        System.out.println("\n=== 测试用例4：弹出顺序与压入顺序相反 ===");
        int[] pop4 = {5, 4, 3, 2, 1};
        System.out.println("弹出序列{5,4,3,2,1}: " + solution.validateStackSequences(push1, pop4)); // true

        // 测试用例5：单元素
        System.out.println("\n=== 测试用例5：单元素 ===");
        int[] push5 = {1};
        int[] pop5 = {1};
        System.out.println("弹出序列{1}: " + solution.validateStackSequences(push5, pop5)); // true

        // 测试用例6：空数组
        System.out.println("\n=== 测试用例6：空数组 ===");
        int[] push6 = {};
        int[] pop6 = {};
        System.out.println("空数组: " + solution.validateStackSequences(push6, pop6)); // true

        // 测试用例7：长度不匹配
        System.out.println("\n=== 测试用例7：长度不匹配 ===");
        int[] pop7 = {1, 2};
        System.out.println("长度不匹配: " + solution.validateStackSequences(push5, pop7)); // false
    }

    /**
     * 判断弹出序列是否合法
     *
     * @param pushed 压入序列
     * @param popped 弹出序列
     * @return 是否为合法的弹出序列
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null) {
            return false;
        }
        if (pushed.length != popped.length) {
            return false;
        }
        if (pushed.length == 0) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;

        for (int num : pushed) {
            // 将当前元素压入栈
            stack.push(num);

            // 检查栈顶是否等于弹出序列的当前元素
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }

        // 如果栈为空，说明所有弹出序列都能匹配
        return stack.isEmpty();
    }
}
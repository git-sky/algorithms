package cn.com.sky.algorithms.interview.stack_queue;

/**
 * <pre>
 * 最小栈【Easy】
 *
 * 题目：定义栈的数据结构，实现一个能够得到栈的最小元素的getMin函数。
 * 在该栈中，调用getMin、push及pop的时间复杂度都是O(1)。
 *
 * 算法原理（辅助栈法）：
 * 1. 使用两个栈：stackData存储数据，stackMin存储当前最小值
 * 2. push时：将元素压入stackData，同时将当前最小值压入stackMin
 * 3. pop时：两个栈同时弹出栈顶
 * 4. getMin时：返回stackMin的栈顶元素
 *
 * 为什么每次push都要往stackMin压入当前最小值？
 * - 保证stackMin与stackData元素个数一致，pop时可以同步弹出
 * - stackMin的栈顶始终是当前栈中的最小值
 *
 * 时间复杂度：push O(1)，pop O(1)，getMin O(1)
 * 空间复杂度：O(n)
 * </pre>
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        // 测试用例1：正常操作
        System.out.println("=== 测试用例1：正常操作 ===");
        minStack.push(5);
        minStack.push(3);
        minStack.push(7);
        minStack.push(1);
        System.out.println("getMin: " + minStack.getMin()); // 1
        System.out.println("pop: " + minStack.pop()); // 1
        System.out.println("getMin: " + minStack.getMin()); // 3
        System.out.println("pop: " + minStack.pop()); // 7
        System.out.println("getMin: " + minStack.getMin()); // 3

        // 测试用例2：递增序列
        System.out.println("\n=== 测试用例2：递增序列 ===");
        MinStack stack2 = new MinStack();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        System.out.println("getMin: " + stack2.getMin()); // 1

        // 测试用例3：递减序列
        System.out.println("\n=== 测试用例3：递减序列 ===");
        MinStack stack3 = new MinStack();
        stack3.push(3);
        stack3.push(2);
        stack3.push(1);
        System.out.println("getMin: " + stack3.getMin()); // 1

        // 测试用例4：相同元素
        System.out.println("\n=== 测试用例4：相同元素 ===");
        MinStack stack4 = new MinStack();
        stack4.push(2);
        stack4.push(2);
        stack4.push(2);
        System.out.println("getMin: " + stack4.getMin()); // 2
    }

    Stack stackData = new Stack(10);
    Stack stackMin = new Stack(10);
    Integer min = null;

    public void push(int e) {
        stackData.push(e);
        if (min == null || min > e) {
            min = e;
        }
        stackMin.push(min);
    }

    public int pop() {
        stackMin.pop();
        int val = stackData.pop();
        // 更新min
        if (!stackMin.isEmpty()) {
            min = stackMin.peek();
        } else {
            min = null;
        }
        return val;
    }

    public int getMin() {
        return stackMin.peek();
    }

    public int peek() {
        return stackData.peek();
    }
}
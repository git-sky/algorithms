package cn.com.sky.algorithms.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <pre>
 * 剑指Offer 6. 从尾到头打印链表【Easy】
 *
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 *
 * 算法原理：
 * 方法1（栈法）：
 *   遍历链表，将节点值依次压入栈中，然后依次弹出即为逆序
 *   本质：栈是"后进先出"的数据结构，天然适合逆序输出
 *
 * 方法2（递归法）：
 *   递归到链表末尾，在回溯时打印节点值
 *   本质：递归调用栈就是一个隐式的栈
 *   缺点：链表过长时可能导致栈溢出
 *
 * 方法3（反转链表法）：
 *   先反转链表，再顺序打印，最后恢复链表
 *   缺点：修改了链表结构
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)（栈或递归调用栈）
 * </pre>
 */
public class ListReversePrint extends SingleLinkedListParent {

    public static void main(String[] args) {
        ListReversePrint solution = new ListReversePrint();

        // 测试用例1：正常链表
        System.out.println("=== 测试用例1：正常链表 ===");
        Node head1 = solution.init(5);
        solution.print(head1);
        System.out.println("栈法逆序: " + solution.reversePrintByStack(head1));
        System.out.println("递归法逆序: " + solution.reversePrintByRecursive(head1));

        // 测试用例2：单节点
        System.out.println("\n=== 测试用例2：单节点 ===");
        Node head2 = solution.init(1);
        solution.print(head2);
        System.out.println("栈法逆序: " + solution.reversePrintByStack(head2));

        // 测试用例3：空链表
        System.out.println("\n=== 测试用例3：空链表 ===");
        System.out.println("栈法逆序: " + solution.reversePrintByStack(null));

        // 测试用例4：两个节点
        System.out.println("\n=== 测试用例4：两个节点 ===");
        Node head4 = solution.init(2);
        solution.print(head4);
        System.out.println("栈法逆序: " + solution.reversePrintByStack(head4));

        // 测试用例5：反转链表法
        System.out.println("\n=== 测试用例5：反转链表法 ===");
        Node head5 = solution.init(5);
        solution.print(head5);
        List<Integer> result = solution.reversePrintByReverse(head5);
        System.out.println("反转法逆序: " + result);
    }

    /**
     * 方法1：使用栈逆序打印链表
     *
     * @param head 链表头节点
     * @return 逆序的节点值列表
     */
    public List<Integer> reversePrintByStack(Node head) {
        List<Integer> result = new ArrayList<>();
        if (head == null) {
            return result;
        }

        Stack<Integer> stack = new Stack<>();
        Node current = head;
        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    /**
     * 方法2：递归法逆序打印链表
     *
     * @param head 链表头节点
     * @return 逆序的节点值列表
     */
    public List<Integer> reversePrintByRecursive(Node head) {
        List<Integer> result = new ArrayList<>();
        recursiveHelper(head, result);
        return result;
    }

    private void recursiveHelper(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        recursiveHelper(node.next, result);
        result.add(node.data);
    }

    /**
     * 方法3：反转链表法逆序打印
     *
     * @param head 链表头节点
     * @return 逆序的节点值列表
     */
    public List<Integer> reversePrintByReverse(Node head) {
        List<Integer> result = new ArrayList<>();
        if (head == null) {
            return result;
        }

        // 反转链表
        Node reversed = reverse(head);

        // 顺序遍历反转后的链表
        Node current = reversed;
        while (current != null) {
            result.add(current.data);
            current = current.next;
        }

        return result;
    }

    /**
     * 反转链表
     */
    private Node reverse(Node head) {
        Node pre = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}
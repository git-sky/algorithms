package cn.com.sky.algorithms.interview.linkedlist;

/**
 * <pre>
 * 单链表有环检测【Easy】（字节跳动高频）
 * 
 * 题目描述：输入一个单向链表，判断链表是否有环。
 * 
 * 算法原理（Floyd判圈算法/快慢指针）：
 * 1. 使用两个指针，slow每次走一步，fast每次走两步
 * 2. 如果链表有环，快慢指针最终会相遇
 * 3. 如果链表无环，fast会先到达链表末尾
 * 
 * 为什么快指针走两步？
 * - 如果走一步，速度相同永远不会相遇
 * - 如果走三步或更多，可能跳过慢指针导致错过相遇点
 * - 走两步是最优选择，保证一定能相遇
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * </pre>
 */
public class SingleLinkedListHasCircle {

    public static void main(String[] args) {
        SingleLinkedListHasCircle solution = new SingleLinkedListHasCircle();
        
        // 测试用例1：正常无环链表
        Node head1 = createList(new int[]{1, 2, 3, 4, 5});
        System.out.println("测试用例1(无环): " + (solution.hasCircle(head1) != null)); // false
        
        // 测试用例2：有环链表
        Node head2 = createListWithCycle(new int[]{1, 2, 3, 4, 5}, 2);
        System.out.println("测试用例2(有环): " + (solution.hasCircle(head2) != null)); // true
        
        // 测试用例3：单节点无环
        Node head3 = new Node(1);
        System.out.println("测试用例3(单节点无环): " + (solution.hasCircle(head3) != null)); // false
        
        // 测试用例4：单节点自环
        Node head4 = new Node(1);
        head4.next = head4;
        System.out.println("测试用例4(单节点自环): " + (solution.hasCircle(head4) != null)); // true
        
        // 测试用例5：空链表
        System.out.println("测试用例5(空链表): " + (solution.hasCircle(null) != null)); // false
        
        // 测试用例6：两节点无环
        Node head6 = new Node(1);
        head6.next = new Node(2);
        System.out.println("测试用例6(两节点无环): " + (solution.hasCircle(head6) != null)); // false
        
        // 测试用例7：两节点有环
        Node head7 = new Node(1);
        head7.next = new Node(2);
        head7.next.next = head7;
        System.out.println("测试用例7(两节点有环): " + (solution.hasCircle(head7) != null)); // true
    }

    /**
     * 创建无环链表
     */
    private static Node createList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    /**
     * 创建有环链表
     * @param arr 数组
     * @param cycleIndex 环开始的索引位置
     */
    private static Node createListWithCycle(int[] arr, int cycleIndex) {
        if (arr == null || arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node curr = head;
        Node cycleStart = null;
        
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
            if (i == cycleIndex) {
                cycleStart = curr;
            }
        }
        // 将尾部连接到环开始位置
        if (cycleStart != null) {
            curr.next = cycleStart;
        }
        return head;
    }

    /**
     * 判断单链表是否存在环
     * 
     * @param head 链表头节点
     * @return 环内相遇节点，如果无环返回null
     */
    Node hasCircle(Node head) {
        // 边界情况
        if (head == null || head.next == null) {
            return null;
        }
        
        Node slow = head;
        Node fast = head.next; // 快指针先走一步
        
        while (slow != fast) {
            // 快指针到达末尾，无环
            if (fast == null || fast.next == null) {
                return null;
            }
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 相遇，有环
        return slow;
    }

    /**
     * 链表节点
     */
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
package cn.com.sky.algorithms.ByteDance.top10;

/**
 * LeetCode 206. 反转链表【Easy】（字节跳动高频）
 * 
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 
 * 算法原理（迭代）：
 * 1. 使用三个指针：prev（前一个节点）、curr（当前节点）、next（下一个节点）
 * 2. 遍历链表，逐个将节点的 next 指针指向前一个节点
 * 3. 最后返回 prev（新的头节点）
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class ReverseLinkedList206 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ReverseLinkedList206 solution = new ReverseLinkedList206();
        
        // 测试用例1：正常情况
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5});
        System.out.println("测试用例1原链表: " + listToString(head1));
        ListNode result1 = solution.reverseList(head1);
        System.out.println("测试用例1反转后: " + listToString(result1)); // [5,4,3,2,1]
        
        // 测试用例2：空链表
        System.out.println("测试用例2空链表: " + listToString(solution.reverseList(null))); // []
        
        // 测试用例3：单节点
        ListNode head3 = new ListNode(1);
        System.out.println("测试用例3单节点: " + listToString(solution.reverseList(head3))); // [1]
        
        // 测试用例4：两个节点
        ListNode head4 = new ListNode(1, new ListNode(2));
        System.out.println("测试用例4两节点反转后: " + listToString(solution.reverseList(head4))); // [2,1]
    }

    /**
     * 创建链表
     */
    private static ListNode createList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    /**
     * 链表转字符串
     */
    private static String listToString(ListNode head) {
        if (head == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        ListNode curr = head;
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) {
                sb.append(",");
            }
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 迭代法反转链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        return prev;
    }

    /**
     * 递归法反转链表
     */
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        
        return newHead;
    }
}
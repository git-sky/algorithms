package cn.com.sky.algorithms.ByteDance.top10;

/**
 * LeetCode 206. 反转链表【Easy】（字节跳动高频）
 * <p>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * 算法原理（迭代）：
 * 1. 使用三个指针：prev（前一个节点）、curr（当前节点）、next（下一个节点）
 * 2. 遍历链表，逐个将节点的 next 指针指向前一个节点
 * 3. 最后返回 prev（新的头节点）
 * <p>
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class ReverseLinkedList206 {

    /**
     * 迭代法反转链表
     * <p>
     * * 时间复杂度：O(n)
     * * 空间复杂度：O(1)
     * <p>
     * 一句话记忆法："保存后路，翻转指针，双双前进"
     */
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;   // 初始时前一个节点为 null
        ListNode curr = head;   // 当前节点从 head 开始

        while (curr != null) {
            ListNode nextTemp = curr.next;  // ① 保存下一个节点（关键！否则会断链）
            curr.next = prev;               // ② 翻转：当前节点指向前一个节点
            prev = curr;                    // ③ prev 前进到当前节点
            curr = nextTemp;                // ④ curr 前进到下一个节点
        }

        return prev;  // 循环结束时 curr=null，prev 就是新的头节点

    }

    /**
     * 递归法反转链表
     * <p>
     * * 时间复杂度：O(n)
     * * 空间复杂度：O(N)
     * <p>
     * 递归的思路是：先递归到链表末尾，然后从最后一个节点开始，一层层往回翻转。
     */
    public ListNode reverseListRecursive(ListNode head) {
        // ① 终止条件：空链表或只有一个节点，无需反转
        if (head == null || head.next == null) {
            return head;
        }

        // ② 递归翻转后面的子链表
        ListNode newHead = reverseListRecursive(head.next);

        // ③ 翻转当前节点与下一个节点的指针
        head.next.next = head;  // 让下一个节点指向自己

        // ④ 断开当前节点原来的指向（防止成环）
        head.next = null;

        // ⑤ 返回新的头节点（始终是原链表的最后一个节点）
        return newHead;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
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


}
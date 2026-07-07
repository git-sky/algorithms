package cn.com.sky.algorithms.ByteDance.top10;

/**
 * LeetCode 23. 合并K个升序链表【Hard】（字节跳动高频）
 * 
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 
 * 算法原理（分治法）：
 * 1. 将链表数组分成两部分
 * 2. 递归合并左右两部分
 * 3. 合并两个有序链表
 * 
 * 时间复杂度：O(N log k)，N是所有节点总数，k是链表数量
 * 空间复杂度：O(log k)（递归栈）
 */
public class MergeKSortedLists23 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        MergeKSortedLists23 solution = new MergeKSortedLists23();
        
        // 构建测试链表
        ListNode l1 = createList(new int[]{1, 4, 5});
        ListNode l2 = createList(new int[]{1, 3, 4});
        ListNode l3 = createList(new int[]{2, 6});
        
        ListNode[] lists = {l1, l2, l3};
        ListNode result = solution.mergeKLists(lists);
        
        System.out.println("合并结果: " + listToString(result)); // [1,1,2,3,4,4,5,6]
        
        // 测试空数组
        ListNode[] emptyLists = {};
        System.out.println("空数组: " + listToString(solution.mergeKLists(emptyLists))); // []
        
        // 测试单链表
        ListNode[] singleList = {createList(new int[]{1, 2, 3})};
        System.out.println("单链表: " + listToString(solution.mergeKLists(singleList))); // [1,2,3]
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    /**
     * 分治合并
     */
    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        
        return mergeTwoLists(l1, l2);
    }

    /**
     * 合并两个有序链表
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        // 连接剩余节点
        curr.next = l1 != null ? l1 : l2;
        
        return dummy.next;
    }
}
package cn.com.sky.algorithms.ByteDance.top10;

/**
 * LeetCode 2. 两数相加【Medium】（字节跳动高频）
 * 
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，
 * 并且每个节点只能存储一位数字。请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 
 * 算法原理：
 * 1. 遍历两个链表，逐位相加
 * 2. 使用进位变量 carry 记录进位
 * 3. 处理链表长度不一致的情况
 * 4. 最后处理剩余的进位
 * 
 * 时间复杂度：O(max(m, n))
 * 空间复杂度：O(max(m, n))
 */
public class AddTwoNumbers2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        AddTwoNumbers2 solution = new AddTwoNumbers2();
        
        // 测试用例1：正常情况
        ListNode l1 = createList(new int[]{2, 4, 3});
        ListNode l2 = createList(new int[]{5, 6, 4});
        ListNode result1 = solution.addTwoNumbers(l1, l2);
        System.out.println("测试用例1: " + listToString(result1)); // [7,0,8]
        
        // 测试用例2：不同长度
        ListNode l3 = createList(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l4 = createList(new int[]{9, 9, 9, 9});
        ListNode result2 = solution.addTwoNumbers(l3, l4);
        System.out.println("测试用例2: " + listToString(result2)); // [8,9,9,9,0,0,0,1]
        
        // 测试用例3：空链表
        ListNode l5 = createList(new int[]{0});
        ListNode l6 = createList(new int[]{0});
        ListNode result3 = solution.addTwoNumbers(l5, l6);
        System.out.println("测试用例3: " + listToString(result3)); // [0]
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        
        return dummy.next;
    }
}
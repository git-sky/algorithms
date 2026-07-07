package cn.com.sky.algorithms.linearlist.linked_list.operation;

/**
 * <pre>
 * 单链表反转【Easy】（字节跳动高频）
 * 
 * 题目描述：反转一个单链表。
 * 
 * 算法原理（迭代法）：
 * 1. 使用三个指针：prev（前一个节点）、curr（当前节点）、next（下一个节点）
 * 2. 遍历链表，依次将每个节点的next指针指向前一个节点
 * 3. 注意：必须先保存next指针，否则会丢失后续节点
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 
 * 递归法思路：
 * 1. 递归到链表末尾，返回新的头节点
 * 2. 将当前节点的next.next指向当前节点
 * 3. 将当前节点的next置为null，防止循环引用
 * 
 * 示例：
 * 输入: 1 -> 2 -> 3 -> 4 -> 5 -> null
 * 输出: 5 -> 4 -> 3 -> 2 -> 1 -> null
 * </pre>
 */
public class ReverseList {

    public static void main(String[] args) {
        // 测试用例1：正常链表
        Node head1 = createList(new String[]{"a", "b", "c", "d", "e"});
        System.out.println("=== 测试用例1：正常链表 ===");
        print(head1);
        head1 = reverseIterative(head1);
        print(head1);
        
        // 测试用例2：单节点链表
        Node head2 = createList(new String[]{"only"});
        System.out.println("\n=== 测试用例2：单节点 ===");
        print(head2);
        head2 = reverseIterative(head2);
        print(head2);
        
        // 测试用例3：空链表
        Node head3 = null;
        System.out.println("\n=== 测试用例3：空链表 ===");
        print(head3);
        head3 = reverseIterative(head3);
        print(head3);
        
        // 测试用例4：两个节点
        Node head4 = createList(new String[]{"first", "second"});
        System.out.println("\n=== 测试用例4：两个节点 ===");
        print(head4);
        head4 = reverseRecursive(head4);
        print(head4);
    }

    /**
     * 迭代法反转链表
     */
    public static Node reverseIterative(Node head) {
        Node prev = null;
        Node curr = head;
        
        while (curr != null) {
            Node nextTemp = curr.next;  // 保存下一个节点
            curr.next = prev;           // 反转当前节点的指针
            prev = curr;                // prev指针前进
            curr = nextTemp;            // curr指针前进
        }
        
        return prev;
    }

    /**
     * 递归法反转链表
     */
    public static Node reverseRecursive(Node head) {
        // 递归终止条件：空链表或只有一个节点
        if (head == null || head.next == null) {
            return head;
        }
        
        // 递归反转后续链表
        Node newHead = reverseRecursive(head.next);
        
        // 将当前节点的下一个节点的next指向当前节点
        head.next.next = head;
        // 断开当前节点的next指针，防止循环
        head.next = null;
        
        return newHead;
    }

    /**
     * 创建链表
     */
    public static Node createList(String[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    /**
     * 打印链表
     */
    public static void print(Node head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        Node p = head;
        while (p != null) {
            sb.append(p.data);
            if (p.next != null) {
                sb.append(" -> ");
            }
            p = p.next;
        }
        sb.append(" -> null");
        System.out.println(sb.toString());
    }
}

/**
 * 链表节点
 */
class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }

    public String toString() {
        return data;
    }
}
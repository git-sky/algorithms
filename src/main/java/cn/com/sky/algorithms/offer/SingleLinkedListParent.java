package cn.com.sky.algorithms.offer;

/**
 * <pre>
 * 单链表辅助类 - 提供链表构建和打印功能
 *
 * 功能：
 * 1. 头插入法构建链表（有头结点/无头结点）
 * 2. 打印链表
 * 3. 定义链表节点
 *
 * 头插入法特点：
 * - 新节点插入到链表头部
 * - 构建的链表顺序与输入顺序相反
 * - 时间复杂度：O(n)
 * </pre>
 */
public class SingleLinkedListParent {

    /**
     * 构建单链表（头插入法，拥有头结点）
     * 头结点不存储有效数据，仅作为链表的入口
     *
     * @param N 节点数量
     * @return 头结点
     */
    protected Node initWithHead(int N) {
        Node head = new Node(-1, null);
        for (int i = 1; i <= N; i++) {
            Node node = new Node(i, head.next);
            head.next = node;
        }
        return head;
    }

    /**
     * 构建单链表（头插入法，无头结点）
     * 注意：头插入法构建的链表顺序与输入顺序相反
     * 例如输入N=5，链表为 5->4->3->2->1
     *
     * @param N 节点数量
     * @return 链表头节点
     */
    protected Node init(int N) {
        Node head = null;
        for (int i = 1; i <= N; i++) {
            Node node = new Node(i, head);
            head = node;
        }
        return head;
    }

    /**
     * 打印链表
     *
     * @param head 链表头节点
     */
    protected void print(Node head) {
        System.out.print("链表：");
        for (Node p = head; p != null; p = p.next) {
            System.out.print(p.data + "->");
        }
        System.out.println("null");
    }

    /**
     * 链表节点
     */
    protected static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
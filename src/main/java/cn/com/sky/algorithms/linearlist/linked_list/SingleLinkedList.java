package cn.com.sky.algorithms.linearlist.linked_list;

/**
 * <pre>
 * 单链表实现【Easy】
 * 
 * 链表结构：
 *        head                              tail
 *         |                                  |	
 *         |                                  |
 *         V                                  V
 *     |head||-->|elem0||-->|elem1||-->|elem2|^|
 * 
 * 主要操作：
 * 1. 头插入法：新节点插入到链表头部
 * 2. 尾插入法：新节点插入到链表尾部
 * 3. 遍历：从头节点开始访问每个节点
 * 4. 反转：将链表顺序反转
 * 
 * 时间复杂度：
 * - 头插入：O(1)
 * - 尾插入：O(n)（若无尾指针）
 * - 遍历：O(n)
 * - 反转：O(n)
 * </pre>
 */
public class SingleLinkedList {

    public static void main(String[] args) {
        // 测试用例1：头插入法建表
        System.out.println("=== 测试用例1：头插入法 ===");
        Node head1 = createByHead(new String[]{"A", "B", "C", "D", "E"});
        print(head1);
        
        // 测试用例2：尾插入法建表
        System.out.println("\n=== 测试用例2：尾插入法 ===");
        Node head2 = createByTail(new String[]{"A", "B", "C", "D", "E"});
        print(head2);
        
        // 测试用例3：链表反转
        System.out.println("\n=== 测试用例3：链表反转 ===");
        Node reversed = reverse(head2);
        print(reversed);
        
        // 测试用例4：查找节点
        System.out.println("\n=== 测试用例4：查找节点 ===");
        Node found = find(reversed, "C");
        System.out.println("查找结果: " + (found != null ? found.getValue() : "null"));
        
        // 测试用例5：删除节点
        System.out.println("\n=== 测试用例5：删除节点 ===");
        Node afterDelete = delete(head2, "C");
        print(afterDelete);
    }

    /**
     * 头插入法建表（逆序）
     */
    public static Node createByHead(String[] elements) {
        Node head = new Node("head", null);  // 头结点
        
        for (String elem : elements) {
            Node node = new Node(elem, head.getNext());
            head.setNext(node);
        }
        
        return head;
    }

    /**
     * 尾插入法建表（顺序）
     */
    public static Node createByTail(String[] elements) {
        Node head = new Node("head", null);  // 头结点
        Node tail = head;  // 尾指针
        
        for (String elem : elements) {
            Node node = new Node(elem, null);
            tail.setNext(node);
            tail = node;
        }
        
        return head;
    }

    /**
     * 遍历单链表
     */
    public static void print(Node head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            sb.append(curr.getValue());
            if (curr.getNext() != null) {
                sb.append(" -> ");
            }
            curr = curr.getNext();
        }
        System.out.println(sb.toString());
    }

    /**
     * 单链表反转（迭代法）
     */
    public static Node reverse(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        
        Node prev = null;
        Node curr = head;
        
        while (curr != null) {
            Node nextTemp = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = nextTemp;
        }
        
        return prev;
    }

    /**
     * 查找指定值的节点
     */
    public static Node find(Node head, String value) {
        Node curr = head;
        while (curr != null) {
            if (curr.getValue().equals(value)) {
                return curr;
            }
            curr = curr.getNext();
        }
        return null;
    }

    /**
     * 删除指定值的节点
     */
    public static Node delete(Node head, String value) {
        if (head == null) {
            return null;
        }
        
        // 处理头节点
        if (head.getValue().equals(value)) {
            return head.getNext();
        }
        
        Node prev = head;
        Node curr = head.getNext();
        
        while (curr != null) {
            if (curr.getValue().equals(value)) {
                prev.setNext(curr.getNext());
                break;
            }
            prev = curr;
            curr = curr.getNext();
        }
        
        return head;
    }
}

/**
 * 链表节点
 */
class Node {
    private String value;
    private Node next;

    public Node(String value, Node next) {
        this.value = value;
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
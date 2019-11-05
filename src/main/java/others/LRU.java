package others;

/**
 * @author: yitl
 * @create: 2019-04-13
 * 链表实现最近最少使用策略LRU（Least Recently Used）
 */
public class LRU {

    static class Node{
        int data;
        Node next;
        public Node (int data) {
            this.data = data;
        }
    }

    public LRU () {
        this.head = new Node(0);
    }

    private static final int maxLength = 4;

    private static Node head;

    public void add (Node node) {
        int tmp = 0;
        Node cur = head.next;
        Node pre = head;
        while (cur != null) {
            if (cur.data == node.data) {
                pre.next = cur.next;
                node.next = head.next;
                head.next = node;
                return;
            }
            pre = cur;
            cur = cur.next;
            ++tmp;
        }
        if (tmp >= 4) {
            cur = head;
            while (cur.next != pre) {
                cur = cur.next;
            }
            cur.next = null;
        }
        node.next = head.next;
        head.next = node;
    }

    public static void main(String[] args) {
        LRU lru = new LRU();
        Node tmp = lru.head;//debug时看参数变化用的
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(3);
        Node n5 = new Node(4);
        Node n6 = new Node(5);
        lru.add(n1);
        lru.add(n2);
        lru.add(n3);
        lru.add(n4);
        lru.add(n5);
        lru.add(n6);
    }

}

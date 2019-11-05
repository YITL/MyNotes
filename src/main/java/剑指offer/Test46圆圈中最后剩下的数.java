package 剑指offer;

/**
 * @author: yitl
 * @create: 2019-03-23
 */
public class Test46圆圈中最后剩下的数 {

    /**
     * 看似简单,但真的不太简单,还是自己手生啊
     * @param n
     * @param m
     * @return
     */
    public static int LastRemaining_Solution(int n, int m) {
        if(n <= 0 || m <= 0) return -1;
        Node head = new Node(0);
        Node cur = head;
        for(int i = 1; i < n; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        cur.next = head;
        cur = head;
        while(cur.next.next != cur) {
            for(int i = 0; i < m-2; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return m%2 == 1 ? cur.next.value : cur.value;
    }

    static class Node{
        private int value;
        private Node next;
        public Node(int value){
            this.value = value;
        }
    }
}

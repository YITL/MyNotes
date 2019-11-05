package others;

public class DeleteByReciprocalN {


    static class Node{
        int data;
        Node next;
        public Node (int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        Node delete = delete(head, 0);
        System.out.println(1);
    }

    public static Node delete(Node head, int n) {
        if (head == null) return null;
        Node fast = head;
        while (n-- > 0 && fast != null) {
            fast = fast.next;
        }
        if (n != -1) return null;
        Node tmp = new Node(0);
        tmp.next = head;
        Node slow = head;
        Node pre = tmp;
        while (fast != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        if (slow != null){//解决n等于1的情况
            pre.next = slow.next;
        }
        return tmp.next;
    }

}
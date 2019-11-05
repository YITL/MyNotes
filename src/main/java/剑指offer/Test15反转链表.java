package 剑指offer;

/**
 * @author: yitl
 * @create: 2019-03-12
 */
public class Test15反转链表 {

    /**
     * 反转链表，第一个练手的就是他了
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}

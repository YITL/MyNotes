package 剑指offer;

/**
 * @author: yitl
 * @create: 2019-03-12
 */
public class Test14链表中倒数第k个节点 {

    /**
     * 思路大家都知道，只要还是鲁棒性
     * 考虑三种特殊情况，k大于链表的长度，输入的指针为空，k等于0的情况
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) return null;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && k-- > 0) { //这里要注意，一定要先判断p2是否为空
            p2 = p2.next;
        }
        if (k > 0) return null;
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}

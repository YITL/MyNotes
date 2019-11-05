package 剑指offer;

/**
 * @author: yitl
 * @create: 2019-03-28
 */
public class Test56删除有序链表的重复节点 {

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        ListNode cur = pHead;
        ListNode pre = new ListNode(-1);
        pre.next = cur;
        ListNode res = pre;//保留头节点的索引
        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                while (cur.next.val == cur.val) {
                    if (cur.next.next == null) {
                        pre.next = null;
                        return res.next;
                    }
                    cur.next = cur.next.next;
                }
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return res.next;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}

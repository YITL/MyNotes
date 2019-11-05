package 剑指offer;

import java.util.HashSet;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * （其实这个方法还是有问题的，如果是两个有环的链表的话，就会形成死循环。。。）
 * @author: yitl
 * @create: 2019-03-20
 */
public class Test36两个链表的第一个公共节点 {

    //利用了有公共节点的两个链表尾部一定相同的原理
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        int len = 0;
        while (p1 != null) {
            p1 = p1.next;
            ++len;
        }
        ListNode p2 = pHead2;
        while (p2 != null) {
            p2 = p2.next;
            --len;
        }

        p1 = pHead1;
        p2 = pHead2;
        if (len > 0) {
            while (len-- > 0) {
                p1 = p1.next;
            }
        } else if (len < 0) {
            len = Math.abs(len);
            while (len-- > 0) {
                p2 = p2.next;
            }
        }

        while (p1 != null && p2 != null) {
            if (p1 == p2) return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}

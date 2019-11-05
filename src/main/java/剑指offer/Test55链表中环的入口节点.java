package 剑指offer;

import java.util.HashSet;

/**
 * @author: yitl
 * @create: 2019-03-28
 */
public class Test55链表中环的入口节点 {

    /**
     * 省心又省力的空间换时间
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        HashSet<ListNode> set = new HashSet();
        while (pHead != null) {
            if (set.contains(pHead)) {
                return pHead;
            }
            set.add(pHead);
            pHead = pHead.next;
        }
        return null;
    }

    /**
     * 快慢指针快慢着跑，找到相遇点，然后挑一个放回头，开始平行跑，第一个相遇的点就是入口。
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop1(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) return null;
        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;
        while (fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = pHead;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
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

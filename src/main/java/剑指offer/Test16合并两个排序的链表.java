package 剑指offer;

/**
 * @author: yitl
 * @create: 2019-03-13
 */
public class Test16合并两个排序的链表 {

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null && list2 == null) return null;
        ListNode tmp = new ListNode(0);
        ListNode res = tmp;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                tmp.next = list2;
                list2 = list2.next;
            } else {
                tmp.next = list1;
                list1 = list1.next;
            }
            tmp = tmp.next;
        }
        while (list1 != null) {
            tmp.next = list1;
            list1 = list1.next;
            tmp = tmp.next;
        }
        while (list2 != null) {
            tmp.next = list2;
            list2 = list2.next;
            tmp = tmp.next;
        }
        return res.next;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}

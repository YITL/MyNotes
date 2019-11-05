package 剑指offer;

import java.util.HashMap;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @author: yitl
 * @create: 2019-03-15
 */
public class Test25复杂链表的复制 {

    /**
     * 写的不行，要继续练，细节把握不到位
     * random复制那里，要判断空值
     * 最后就是，类的时候就休息会，效率太低也没啥用
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode node = pHead;
        RandomListNode next;
        while (node != null) {
            next = node.next;
            node.next = new RandomListNode(node.label);
            node.next.next = next;
            node = next;
        }
        node = pHead;
        while (node != null) {
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }
        node = pHead;
        RandomListNode res = pHead.next;
        while (node.next.next != null) {
            next = node.next;
            node.next = node.next.next;
            next.next = next.next.next;
            node = node.next;
        }
        node.next = null;
        return res;
    }

    /**
     * 借助了一个map
     * @param pHead
     * @return
     */
    public RandomListNode Clone1(RandomListNode pHead){
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = pHead;
        while (cur != null){
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = pHead;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(pHead);
    }


    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

}

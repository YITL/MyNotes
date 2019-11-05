package 剑指offer;


import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author: yitl
 * @create: 2019-03-29
 */
public class Test59之字形打印二叉树 {

    /**
     * 敲黑板
     * 这里用了新知识点Deque和新思路Iterator
     * deque就是既可以做栈，又可以做队列的双向链表
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) return lists;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(pRoot);
        boolean flag = true;//true -> forward, false -> reverse
        while (!deque.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            Iterator<TreeNode> iterator = flag ? deque.iterator() : deque.descendingIterator();
            flag = !flag;
            while (iterator.hasNext()) {
                list.add(iterator.next().val);
            }
            lists.add(list);
            int len = deque.size();
            while (len-- > 0) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return lists;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}

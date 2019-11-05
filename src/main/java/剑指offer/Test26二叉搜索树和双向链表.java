package 剑指offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author: yitl
 * @create: 2019-03-15
 */
public class Test26二叉搜索树和双向链表 {

    /**
     * 非递归的中序遍历不熟悉，多练练
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        //结果链表的头节点
        TreeNode tmp = pRootOfTree;
        while (tmp.left != null) {
            tmp = tmp.left;
        }
        TreeNode res = tmp;
        //嫌弃函数头传来的变量名字太长，自己搞了一个
        TreeNode head = pRootOfTree;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (head != res) {
                    tmp.right = head;
                    head.left = tmp;
                    tmp = head;
                }
                head = head.right;
            }
        }
        return res;
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

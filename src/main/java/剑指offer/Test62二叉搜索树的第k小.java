package 剑指offer;

import java.util.Stack;

/**
 * @author: yitl
 * @create: 2019-03-30
 */
public class Test62二叉搜索树的第k小 {

    /**
     * 二叉搜索树满足三大特点：
     * 树上的任一节点，该节点的值都大于它的非空左子树的值
     * 树上的任一节点，该节点的值都小于它的非空右子树的值
     * 任一节点的左右子树都是二叉搜索树
     *
     * 另外，二叉搜索树的中序遍历就是排序好的递增顺序
     *
     * 其实就是中序遍历
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || pRoot != null) {
                if (pRoot != null) {
                    stack.push(pRoot);
                    pRoot = pRoot.left;
                } else {
                    pRoot = stack.pop();
                    if (k--  == 1) {
                        return pRoot;
                    }
                    pRoot = pRoot.right;
                }
            }
        }
        return null;
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

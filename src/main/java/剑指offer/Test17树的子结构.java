package 剑指offer;

import java.util.Stack;

/**
 * @author: yitl
 * @create: 2019-03-13
 */
public class Test17树的子结构 {

    /**
     * 自己写的非递归实现，思路没毛病
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root1);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val == root2.val) {
                if (isSubtree(node, root2)) return true;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return false;
    }
    private boolean isSubtree(TreeNode node, TreeNode child) {
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(node);
        Stack<TreeNode> stack2 = new Stack<>();
        stack2.push(child);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            node = stack1.pop();
            child = stack2.pop();
            if (node.val != child.val) return false;
            if (node.right != null && child.right != null) {
                stack1.push(node.right);
                stack2.push(child.right);
            }
            if (node.left != null && child.left != null) {
                stack1.push(node.left);
                stack2.push(child.left);
            }
            //这里注意一下，子树没空，父亲树却空了就不行了，不仅适合于找子结构，也适合与找子树
            if ((child.left != null && node.left == null) || (child.right != null && node.right == null)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 看了一下讨论，才想起来的递归
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree1(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        if (root1.val == root2.val) {
            if (isSubtree1(root1, root2)) return true;
        }
        return HasSubtree1(root1.left, root2) || HasSubtree1(root1.right, root2);
    }
    private boolean isSubtree1(TreeNode node, TreeNode child) {
        //核心在这两个判断上面
        if (child == null) {
            return true;
        }
        //走到这里并进去了，说明子树没空，但是父树对应的这个节点空了，肯定不匹配
        if (node == null) {
            return false;
        }
        if (node.val != child.val) return false;
        return isSubtree1(node.left, child.left) && isSubtree1(node.right, child.right);
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

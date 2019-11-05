package 剑指offer;

import java.util.Stack;

/**
 * @author: yitl
 * @create: 2019-03-28
 */
public class Test58判断二叉树是否对称 {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isSymmetrical(left.left, right.right)
                && isSymmetrical(left.right, right.left);

    }

    //非递归
    boolean isSymmetrical1(TreeNode pRoot) {
        if (pRoot == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot.right);
        stack.push(pRoot.left);
        while (!stack.empty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
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

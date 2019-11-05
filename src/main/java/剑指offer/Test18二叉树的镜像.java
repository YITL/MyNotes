package 剑指offer;

import java.util.Stack;

/**
 * @author: yitl
 * @create: 2019-03-13
 */
public class Test18二叉树的镜像 {

    /**
     * 简单题
     * 递归实现
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }

    /**
     * 非递归实现
     * @param root
     */
    public void Mirror1(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode tmp;
        while (!stack.isEmpty()) {
            root = stack.pop();
            tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;

        }
    }

}

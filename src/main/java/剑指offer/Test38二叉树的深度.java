package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: yitl
 * @create: 2019-03-20
 */
public class Test38二叉树的深度 {

    /**
     * 递归方式
     * 讲道理这种简单的题，直接考虑递归就好，按层遍历的话有点绕远了。
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        return recursion(root);
    }

    private int recursion(TreeNode node) {
        if (node == null) return 0;
        return Math.max(recursion(node.left), recursion(node.right)) + 1;
    }

    /**
     * 按层遍历（非递归），不同于原来的出一个进俩，这种是出一层进下一层
     * @param root
     * @return
     */
    public static int TreeDepth2(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            ++level;
            int len = queue.size();
            TreeNode node;
            while (len-- > 0){
                node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return level;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        int i = TreeDepth2(head);
        System.out.println(i);
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

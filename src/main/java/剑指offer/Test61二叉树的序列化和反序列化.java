package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: yitl
 * @create: 2019-03-29
 */
public class Test61二叉树的序列化和反序列化 {

    String Serialize(TreeNode root) {
        if (root == null) return "#_";
        StringBuilder res = new StringBuilder();
        res.append(root.val).append("_");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.left != null) {
                res.append(node.left.val).append("_");
                queue.offer(node.left);
            }else {
                res.append("#_");
            }
            if (node.right != null) {
                res.append(node.right.val).append("_");
                queue.offer(node.right);
            }else {
                res.append("#_");
            }
        }
        return res.toString();
    }
    TreeNode Deserialize(String str) {
        Queue<TreeNode> queue = new LinkedList<>();
        String[] arr = str.split("_");
        int index = 0;
        TreeNode root = getNode(arr[index++]);
        if (root != null) {
            queue.offer(root);
        }
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = getNode(arr[index++]);
            node.right = getNode(arr[index++]);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    TreeNode getNode(String str) {
        if (str.equals("#")) return null;
        return new TreeNode(Integer.valueOf(str));
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

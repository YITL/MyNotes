package 剑指offer;


/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * @author: yitl
 * @create: 2019-03-20
 */
public class Test39平衡二叉树 {

    private boolean flag = true;

    /**
     * 借助了一个成员变量，虽然是后序遍历，每个节点只访问一次，但是没有剪枝
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        recursion(root);
        return flag;
    }

    private int recursion(TreeNode node) {
        if (node == null) return 0;
        int res1 = recursion(node.left);
        int res2 = recursion(node.right);
        if (Math.abs(res1-res2) > 1) flag = false;
        return Math.max(res1, res2) + 1;
    }

    /**
     * 剪枝以后
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution1(TreeNode root) {
        int recursion = recursion(root);
        return recursion == -1 ? false : true;
    }

    private int recursion1(TreeNode node) {
        if (node == null) return 0;
        int res1 = recursion(node.left);
        if (res1 == -1) return -1;
        int res2 = recursion(node.right);
        if (res2 == -1) return -1;
        return Math.abs(res1-res2) > 1 ? -1 : Math.max(res1, res2) + 1;
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

package 剑指offer;

//根据前序遍历和中序遍历重建二叉树
public class Test04重建二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length != in.length || pre.length == 0) return null;
        return build(pre, in, 0, pre.length-1, 0, pre.length-1);
    }

    private TreeNode build(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        //前序遍历的第一个节点是根节点(对于子过程也是这样的)
        TreeNode head = new TreeNode(pre[preStart]);
        if (preStart == preEnd) {
            head.left = null;
            head.right = null;
            return head;
        }
        int tmp = 0;//tmp记录的其实是左子树节点的个数
        for (int i = inStart; i <= inEnd; ++i) {
            if (in[i] == head.val) {
                break;
            }
            ++tmp;
        }
        //构建左子树
        if (tmp == 0) {
            head.left = null;
        } else {
            head.left = build(pre, in, preStart+1, preStart+tmp, inStart, inStart+tmp-1);
        }
        //构建右子树
        if (preStart+tmp == preEnd) {
            head.right = null;
        } else {
            head.right = build(pre, in, preStart+tmp+1, preEnd, inStart+tmp+1, inEnd);
        }
        return head;
    }

}

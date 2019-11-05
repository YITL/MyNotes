package 剑指offer;

/**
 * @author: yitl
 * @create: 2019-03-28
 */
public class Test57中序遍历的后继节点 {

    /*
    两种情况
    若有右子树,后继节点则是右子树的最左下的节点
    若没有右子树,则找父节点,直到是父节点的左子树为止
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        if (pNode.right != null) {
            while (pNode.right.left != null) {
                pNode.right = pNode.right.left;
            }
            return pNode.right;
        } else {
            TreeLinkNode parent = pNode.next;
            while (parent != null && pNode != parent.left) {
                pNode = parent;
                parent = pNode.next;
            }
            return parent;
        }
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}

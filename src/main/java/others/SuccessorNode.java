package others;

/**
 * @author: yitl
 * @create: 2019-03-08
 */
public class SuccessorNode {

    public static class Node {
        private int value;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int data){
            this.value = data;
        }
    }

    /**
     * 得到后继节点（中序遍历的下一位）
     * 两种情况：1、有右孩子的话，后继节点肯定是以右孩子为根节点的树的最左面的节点
     * 2、没有右孩子的话，就让parent和node两个指针往上跳，直到node是parent的左孩子的情况下停止，此时parent指针
     * 指在node的后继节点，返回即可。注意：parent != null这个判断条件是为了防止node是这棵树最后一个节点的情况，
     * 这种情况下，也可以说后继节点为null。
     * @param node
     * @return
     */
    public static Node getSuccessorNode(Node node){
        if(node == null){
            return null;
        }
        if(node.right != null){
            return getLeftMost(node.right);
        }else {
            Node parent = node.parent;
            while(parent != null && node != parent.left){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node){
        if(node == null){
            return node;
        }
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.parent = null;
        head.left = new Node(2);
        head.left.parent = head;
        head.right = new Node(3);
        head.right.parent = head;
        head.left.left = new Node(4);
        head.left.left.parent = head.left;
        head.left.right = new Node(5);
        head.left.right.parent = head.left;
        head.right.left = new Node(6);
        head.right.left.parent = head.right;
        head.right.right = new Node(7);
        head.right.right.parent = head.right;

        Node test = head.left.right;
        Node successorNode = getSuccessorNode(test);
        System.out.println(successorNode.value);
        Node successorNode1 = getSuccessorNode(head);
        System.out.println(successorNode1.value);
    }

}

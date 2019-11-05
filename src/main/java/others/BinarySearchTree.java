package others;



/**
 * @author: yitl
 * @create: 2019-04-17
 */
public class BinarySearchTree {

    private Node tree;

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (data < p.data) {
                p = p.left;
            } else if (data > p.data){
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public void delete(int data) {
        Node p = tree;
        Node pp = null;
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) p = p.right;
            else p = p.left;
        }
        if (p == null) return;//没有找到要删除的值

        if (p.left != null && p.right != null) {
            Node minP = p.right;
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;
            p = minP;
            pp = minPP;
        }//如果走过这段代码的话，p指向的节点就是要删除的节点，并且这个节点可能有右孩子，但一定没有左孩子

        Node child;
        if (p.left != null) child = p.left;//被删除的节点只有一个左孩子
        else if (p.right != null) child = p.right;//被删除的节点有两种可能：1、只有一个右孩子 2、有两个子节点，但经过了处理
        else child = null;//有两种可能：1、被删除的节点就是子节点 2、有两个子节点，但经过了处理

        if (pp == null) tree = child;//删除的节点是根节点的情况
        else if (pp.left == p) pp.left = child;
        else pp.right = child;
    }

    public Node findMin() {
        if (tree == null) return null;
        Node p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public Node findMax() {
        if (tree == null) return null;
        Node p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

}

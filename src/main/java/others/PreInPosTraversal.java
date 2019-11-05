package others;

import java.util.Stack;

/**
 * @author: yitl
 * @create: 2019-03-08
 */
public class PreInPosTraversal {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    /**
     *       1
     *    2     3
     *  4   5 6   7
     * 对于上面这个简单的二叉树，递归法的遍历顺序是1、2、4、4、4、2、5、5、5、2、1、3、6、6、6、3、7、7、7、3、1
     * 可以看出，每个节点都访问了3次，而前序、中序、后序的差别就在于在第几次访问节点的时候进行打印操作，前序是第一次，
     * 中序是第二次，后序是第三次，这也是前序、中序、后序的递归操作代码很类似的原因。
     * 前序遍历的递归实现
     * @param head
     */
    public static void preOrderRecur(Node head){
        if(head == null){
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    /**
     * 中序遍历的递归实现
     * @param head
     */
    public static void inOrderRecur(Node head){
        if(head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    /**
     * 后序遍历的递归实现
     * @param head
     */
    public static void posOrderRecur(Node head){
        if(head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    /**
     * 前序遍历的非递归实现
     * @param head
     */
    public static void preOrderUnRecur(Node head){
        System.out.println("preOrderUnRecur: ");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while(!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.value + " ");
                if(head.right != null){
                    stack.push(head.right);
                }
                if(head.left != null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历的非递归实现
     * 先一路干到最低层的第一个节点，直到遇上空值，开始弹栈，打印，然后跳到右子树，重复操作
     * while循环中止条件是，栈空了，head指针也到空值了，其实就是根节点已经遍历过了，根节点右子树也遍历结束的情况。
     * @param head
     */
    public static void inOrderUnRecur(Node head){
        System.out.println("inOrderUnRecur: ");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            while(!stack.isEmpty() || head!=null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    /**
     * 后续遍历的非递归实现
     * 原理很简单，就是先实现类似前序遍历的方法，只不过是按中右左的顺序而不是中左右，同时把打印的操作替换成
     * push进辅助栈的操作，然后再pop打印这个辅助栈，就可以实现后序遍历。
     * @param head
     */
    public static void posOrderUnRecur(Node head){
        System.out.println("posOrderUnRecur: ");
        if(head != null){
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()){
                head = stack1.pop();
                stack2.push(head);
                if(head.left != null){
                    stack1.push(head.left);
                }
                if(head.right != null){
                    stack1.push(head.right);
                }
            }
            while (!stack2.isEmpty()){
                System.out.print(stack2.pop().value + " ");
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println("================recursive=================");
        System.out.println("preOrderRecur: ");
        preOrderRecur(head);
        System.out.println();
        System.out.println("inOrderRecur: ");
        inOrderRecur(head);
        System.out.println();
        System.out.println("posOrderRecur: ");
        posOrderRecur(head);
        System.out.println();
        System.out.println("================unRecursive=================");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnRecur(head);
    }

}

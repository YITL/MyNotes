package 剑指offer;

import java.util.Stack;

/**
 * @author: yitl
 * @create: 2019-03-13
 */
public class Test20包含min函数的栈 {

    /**
     * 简单题
     */
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        if(stack.isEmpty()){
            minStack.push(node);
        }else {
            minStack.push(node < minStack.peek() ? node : minStack.peek());
        }
        stack.push(node);
    }

    public void pop() {
        if (stack.isEmpty()){
            throw new RuntimeException("栈已经空了");
        }
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if (stack.isEmpty()){
            throw new RuntimeException("栈已经空了");
        }
        return stack.peek();
    }

    public int min() {
        if (stack.isEmpty()){
            throw new RuntimeException("栈已经空了");
        }
        return minStack.peek();
    }

}

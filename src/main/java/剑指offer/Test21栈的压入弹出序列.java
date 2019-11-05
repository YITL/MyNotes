package 剑指offer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的
 * 一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * @author: yitl
 * @create: 2019-03-14
 */
public class Test21栈的压入弹出序列 {

    /**
     * 用一个辅助栈的思想，没有问题
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (popA.length != pushA.length) return false;
        int i = 0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < pushA.length) {
            stack.push(pushA[i]);
            if (pushA[i] == popA[j]) {
                while (!stack.isEmpty() && stack.peek() == popA[j]) {
                    ++j;
                    stack.pop();
                }
            }
            ++i;
        }
        while (!stack.isEmpty() && stack.peek() == popA[j]) {
            ++j;
            stack.pop();
        }
        if (stack.isEmpty() && j == popA.length) return true;
        return false;
    }

}

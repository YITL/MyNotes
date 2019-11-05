package 剑指offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author: yitl
 * @create: 2019-03-30
 */
public class Test64滑动窗口的最大值 {

    //核心就是只保留可能成为最大数据的元素
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (size > num.length || size == 0) return list;
        Deque<Integer> deque = new ArrayDeque<>();
        //构建第一个滑动窗口
        for (int i = 0; i < size; ++i) {
            //若遍历到的元素比队列末的元素大,弹出队列末的元素
            while (!deque.isEmpty() && num[i] > num[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        list.add(num[deque.peekFirst()]);
        for (int i = size; i < num.length; ++i) {
            //若遍历到的元素比队列末的元素大,弹出队列末的元素
            while (!deque.isEmpty() && num[i] > num[deque.peekLast()]) {
                deque.pollLast();
            }
            //淘汰过期的元素
            while (!deque.isEmpty() && i - deque.peekFirst() >= size) {
                deque.pollFirst();
            }
            deque.offerLast(i);
            list.add(num[deque.peekFirst()]);
        }
        return list;
    }

}

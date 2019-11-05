package 剑指offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: yitl
 * @create: 2019-03-30
 */
public class Test63中位数 {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    private int count = 0;

    //奇数插入大根堆，偶数插入小根堆
    public void Insert(Integer num) {
        ++count;
        if (count%2 == 0) {
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        } else {
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }

    }

    public Double GetMedian() {
        if (count == 0) {
            return null;
        }
        if (count%2 == 0) {
            return (minHeap.peek() + maxHeap.peek())/2.0;
        } else {
            return maxHeap.peek() + 0.0;
        }
    }

}

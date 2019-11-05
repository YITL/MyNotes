package 剑指offer;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @author: yitl
 * @create: 2019-03-16
 */
public class Test29最小的k个数 {

    /**
     * 堆排的思想
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length) return list;
        if (input == null || input.length == 0) return list;
        for (int i = 0; i < input.length; ++i) {
            heapInsert(input, i);
        }
        int size = input.length;
        swap(input, 0, --size);
        int tmp = k;
        while (tmp-- > 1) {
            heapify(input, 0, size);
            swap(input, 0, --size);
        }
        tmp = k;
        int index = input.length-1;
        while (tmp-- > 0) {
            list.add(input[index--]);
        }
        return list;
    }

    static void heapInsert(int[] arr, int index) {
        while (arr[(index-1)/2] > arr[index]) {
            swap(arr, index, (index-1)/2);
            index = (index-1)/2;
        }
    }

    static void heapify(int[] arr, int index, int size) {
        int left = index*2 + 1;
        while (left < size) {
            int small = (left+1 < size && arr[left+1] < arr[left]) ? left+1 : left;
            small = arr[small] < arr[index] ? small : index;
            if (small == index) break;
            swap(arr, index, small);
            index = small;
            left = index * 2 + 1;
        }
    }

    //***********************************************

    private static int k;

    /**
     * 快排思想
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length) return list;
        this.k = k-1;
        recursion(input, 0, input.length-1);
        for (int i = 0; i < k; ++i) {
            list.add(input[i]);
        }
        return list;
    }

    static void recursion(int[] array, int left, int right) {
        if (left >= right) return;
        int[] tmp = partition(array, left, right);
        if (tmp[0] > k) {
            recursion(array, left, tmp[0]-1);
        } else if (tmp[1] < k) {
            recursion(array, tmp[1]+1, right);
        }
    }

    static int[] partition(int[] array, int left, int right) {

        int pre = left-1;
        int end = right;
        while (left < end) {
            if (array[left] == array[right]) {
                ++left;
            } else if (array[left] < array[right]) {
                swap(array, left++, ++pre);
            } else {
                swap(array, left, --end);
            }
        }
        swap(array, end, right);
        return new int[] {pre+1, end};
    }

    static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

}

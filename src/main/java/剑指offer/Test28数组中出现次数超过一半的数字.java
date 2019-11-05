package 剑指offer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，
 * 因此输出2。如果不存在则输出0。
 * @author: yitl
 * @create: 2019-03-16
 */
public class Test28数组中出现次数超过一半的数字 {

    /**
     * "哨兵"法，不要考虑用hashmap了，不行的
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution1(int [] array) {
        int flag = 1;
        int tmp = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (flag == 0) {
                tmp = array[i];
                flag = 1;
            } else if (tmp == array[i]){
                ++flag;
            } else {
                --flag;
            }
        }
        int times = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == tmp) {
                ++times;
            }
        }
        return times > array.length/2 ? tmp : 0;
    }

    /**
     * 快排思想，本质就是找排序好之后的中位数
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) return 0;
        if (array.length == 1) return array[0];
        int res = recursion(array, 0, array.length - 1);
        int times = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == res) {
                ++times;
            }
        }
        return times > array.length/2 ? res : 0;
    }

    static int recursion(int[] array, int left, int right) {
        if (left >= right) return 0;
        int length = array.length;
        int res= array[right];
        int[] tmp = partition(array, left, right);
        if (tmp[1] < length/2) {
            res = recursion(array, tmp[1] + 1, right);
        } else if (tmp[0] > length/2){
            res = recursion(array, left, tmp[0] - 1);
        }
        return res;
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

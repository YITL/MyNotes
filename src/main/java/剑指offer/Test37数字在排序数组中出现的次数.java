package 剑指offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 * @author: yitl
 * @create: 2019-03-20
 */
public class Test37数字在排序数组中出现的次数 {


    //这次思路是有了，但是怎么做忘了
    public int GetNumberOfK(int [] array , int k) {
        int first = getFirst(array, k);
        int last = getLast(array, k);
        if (first == -1 && last == -1) {
            return 0;
        }
        return last-first+1;
    }

    static int getFirst(int[] arr, int k) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (arr[mid] < k) {
                left = mid + 1;
            } else if (arr[mid] > k) {
                right = mid - 1;
            } else {
                if (mid == 0 || (mid > 0 && arr[mid-1] != k)) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    static int getLast(int[] arr, int k) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (arr[mid] < k) {
                left = mid + 1;
            } else if (arr[mid] > k) {
                right = mid - 1;
            } else {
                if (mid == arr.length-1 || (mid < arr.length-1 && arr[mid+1] != k)) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

}

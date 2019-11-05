package 剑指offer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * @author: yitl
 * @create: 2019-03-19
 */
public class Test35数组中的逆序对 {

    /**
     * 没啥好说的，就是归并排序的应用
     */
    static int[] tmp;
    static int res = 0;
    public int InversePairs(int [] array) {
        tmp = new int[array.length];
        merageSort(array, 0, array.length-1);
        return res;
    }

    static void merageSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right-left)/2;
        merageSort(arr, left, mid);
        merageSort(arr, mid+1, right);
        int p1 = left;
        int p2 = mid+1;
        int index = left;
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] <= arr[p2]) {
                tmp[index++] = arr[p1++];
            } else {
                res += mid - p1 + 1;
                res %= 1000000007;//注意这里，不加这一行会溢出
                tmp[index++] = arr[p2++];
            }
        }
        while (p1 <= mid) {
            tmp[index++] = arr[p1++];
        }
        while (p2 <= right) {
            tmp[index++] = arr[p2++];
        }
        for (int i = left; i <= right; ++i) {
            arr[i] = tmp[i];
        }
    }

}

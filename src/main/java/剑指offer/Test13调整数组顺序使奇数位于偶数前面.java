package 剑指offer;

/**
 * @author: yitl
 * @create: 2019-03-12
 */
public class Test13调整数组顺序使奇数位于偶数前面 {

    /**
     * 归并排序思想，保证稳定性，但时间复杂度是nlog（n）
     * 剑指offer用的是类似下面快排的思想，但要求扩展性去了，而且牛客加了稳定性这一条
     * 所以我个人觉得，这个思想最好了
     * @param array
     */
    public void reOrderArray(int [] array) {
        if (array.length == 0 || array.length == 1) return;
        int[] tmpArr = new int[array.length];
        merge(array, 0, array.length-1, tmpArr);
    }

    private void merge(int[] arr, int start, int end, int[] tmpArr) {
        if (start == end) return;
        int mid = start+((end-start) >> 1);
        int index = start;
        merge(arr, start, mid, tmpArr);
        merge(arr, mid+1, end, tmpArr);
        int tmp1 = start;
        int tmp2 = mid + 1;
        while (tmp1 <= mid && tmp2 <= end) {
            if (arr[tmp1] % 2 == 1 && arr[tmp2] % 2 == 0) {
                tmpArr[index++] = arr[tmp1];
                ++tmp1;
            } else if (arr[tmp2] % 2 == 1 && arr[tmp1] % 2 == 0) {
                tmpArr[index++] = arr[tmp2];
                ++tmp2;
            } else {
                tmpArr[index++] = arr[tmp1];
                ++tmp1;
            }
        }
        while (tmp1 <= mid) {
            tmpArr[index++] = arr[tmp1++];
        }
        while (tmp2 <= end) {
            tmpArr[index++] = arr[tmp2++];
        }
        for (int i = start; i <= end; ++i) {
            arr[i] = tmpArr[i];
        }
    }

    /**
     * 快排思想，不要求稳定性的话，就用这个，时间复杂度贼低
     * @param array
     */
    public static void reOrderArray1(int [] array) {
        if(array == null || array.length < 2) return;
        int L = -1;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] % 2 == 1) {
                swap(array, ++L, i);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        reOrderArray1(arr);
        for (int i : arr){
            System.out.println(i);
        }
    }

}

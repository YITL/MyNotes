package 剑指offer;

public class Test06旋转数组的最小数字 {

    public static int minNumberInRotateArray(int [] array) {
        int start = 0;
        int end = array.length-1;
        int mid;
        while (start < end) {
            mid = start + (end-start)/2;
            if (array[mid] > array[end]) {
                start = mid+1;
            } else if (array[mid] < array[end]) {
                end = mid;
            } else {
                --end;//解决重复数字
            }
        }
        return array[start];
    }
}

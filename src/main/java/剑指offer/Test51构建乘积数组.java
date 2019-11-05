package 剑指offer;

/**
 * @author: yitl
 * @create: 2019-03-26
 */
public class Test51构建乘积数组 {

    /**
     * 可以想象出一个矩阵，第i行的所有元素的乘积为arr[i]的结果。
     * 这样就可以以斜着横贯矩阵的斜线为界，分别求下三角和上三角，然后累乘到一起
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] arr = new int[length];
        if (length == 0) return arr;
        arr[0] = 1;
        //先计算下半部分
        for (int i = 1; i < length; i++) {
            arr[i] = arr[i-1] * A[i-1];
        }
        int tmp = 1;
        for (int j = length-2; j >= 0; j--) {
            tmp *= A[j+1];
            arr[j] *= tmp;
        }
        return arr;
    }
}

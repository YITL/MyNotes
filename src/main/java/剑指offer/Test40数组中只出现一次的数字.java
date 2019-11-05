package 剑指offer;

import java.util.HashSet;

/**
 * @author: yitl
 * @create: 2019-03-21
 */
public class Test40数组中只出现一次的数字 {

    /**
     * 容易想到的思路
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i])) {
                set.remove(array[i]);
            } else {
                set.add(array[i]);
            }
        }
        int[] m = new int[2];
        int n = 0;
        for (int i : set) {
            m[n++] = i;
        }
        num1[0] = m[0];
        num2[0] = m[1];
    }

    /**
     * 考察了异或操作的特点
     * 先把所有数都异或一遍，得到的结果是两个只出现一次的数的异或结果（因为两个相同的数的异或结果是0）
     * 找到这个异或结果里从有右边数的第一个1的索引位置，根据异或的性质，这两个数的这一位一定不会相同
     * 根据这个索引的位置是否为1把数分成两部分各自进行异或操作
     * 
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        int m = 0;
        for (int i = 0; i < array.length; i++) {
            m ^= array[i];
        }

        int index = 0;
        int tmp = m;
        while ((tmp & 1) == 0 && index < 32) {
            tmp >>= 1;
            index++;
        }

        for (int i = 0; i < array.length; i++) {
            if (isBit1(array[i], index)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }

    }

    private static boolean isBit1(int tmp, int index) {
        tmp >>= index;
        return (tmp & 1) == 1;
    }

}

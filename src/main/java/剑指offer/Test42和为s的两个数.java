package 剑指offer;

import java.util.ArrayList;

/**
 * @author: yitl
 * @create: 2019-03-22
 */
public class Test42和为s的两个数 {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {

        ArrayList<Integer> list = new ArrayList<>();
        int m = 0;
        int n = array.length - 1;

        while (m < n) {
            int tmp = array[m] + array[n];
            if (tmp < sum) {
                m++;
            } else if (tmp > sum) {
                n--;
            } else {
                list.add(array[m]);
                list.add(array[n]);
                break;
            }
        }

        return list;
    }

}

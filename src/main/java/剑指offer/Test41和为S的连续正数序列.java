package 剑指offer;

import java.util.ArrayList;

/**
 * @author: yitl
 * @create: 2019-03-22
 */
public class Test41和为S的连续正数序列 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int m = 1;
        int n = 2;
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        while (m <= sum/2 && m < n) {
            int tmp = getSum(m, n);
            if (tmp < sum) {
                n++;
            } else if (tmp > sum) {
                m++;
            } else {
                lists.add(getList(m, n));
                n++;
            }
        }

        return lists;
    }

    private int getSum(int m, int n) {
        return (m + n) * (n - m + 1) / 2;
    }

    private ArrayList<Integer> getList(int m, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (; m <= n; m++) {
            list.add(m);
        }
        return list;
    }

}

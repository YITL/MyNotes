package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @author: yitl
 * @create: 2019-03-18
 */
public class Test32把数组排成最小的数 {


    /**
     * 这个是推荐的方法，只是重写了以下comparator
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int [] numbers) {
        String s = "";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; ++i) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });
        for (int i : list) {
            s += i;
        }
        return s;
    }

    /**
     * 这个方法时间复杂度为O(n²)
     * 虽然比n！那种好，但还是一般
     * @param numbers
     * @return
     */
    public String PrintMinNumber1(int [] numbers) {
        if (numbers.length == 0 || numbers == null){
            return "";
        }
        for (int i = 0; i < numbers.length; i++){
            for (int j = i + 1; j < numbers.length; j++){
                int a = Integer.valueOf(numbers[i] + "" + numbers[j]);
                int b = Integer.valueOf(numbers[j] + "" + numbers[i]);
                if (a > b){
                    swap(numbers, i, j);
                }
            }
        }
        String str = "";
        for (int i = 0; i < numbers.length; i++){
            str += String.valueOf(numbers[i]);
        }
        return str;
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

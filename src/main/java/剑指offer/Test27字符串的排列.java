package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * @author: yitl
 * @create: 2019-03-15
 */
public class Test27字符串的排列 {


    /**
     * 递归实现，回溯法
     * 其实讲道理，如果每个递归函数都传进去一个char[]，就体现不到回溯的思想，因为我把char[]也提出来作为了一个成员变量
     * 这样的话，因为自始至终都是对同一个char[]操作，就需要有个复原的操作，也就体现了回溯思想；
     * 另一方面，也能省很多空间，每个子方法要保留的数据就少了很多，整体也就更省空间了。
     * @param str
     * @return
     */
    ArrayList<String> list = new ArrayList<>();
    char[] chars;
    public ArrayList<String> Permutation(String str) {
        chars = str.toCharArray();
        recursion(0);
        Collections.sort(list);
        return list;
    }

    public void recursion(int index) {
        if (index == chars.length-1) {
            list.add(new String(chars));
        }else {
            for (int i = index; i < chars.length; ++i) {
                if (i != index && chars[i] == chars[index]) {
                    continue;
                }
                swap(chars, index, i);
                recursion(index+1);
                swap(chars, index, i);
            }
        }
    }

    /**
     * 字典序，保留算法，暂时不研究
     * @param str
     * @return
     */
    public static ArrayList<String> Permutation2(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str == null || str.length() == 0){
            return list;
        }
        if (str.length() == 1){
            list.add(str);
            return list;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        list.add(String.valueOf(chars));
        while (true){
            int i = chars.length - 1;
            while (i > 0 && chars[i-1] >= chars[i]){
                i--;
            }
            if (i == 0){
                break;
            }
            int m = i-1;
            while (i < chars.length && chars[i] > chars[m]){
                i++;
            }
            swap(chars, m, i-1);
            reverse(chars, m+1);
            list.add(String.valueOf(chars));
        }
        return list;
    }

    private static void reverse(char[] str, int i){
        for (int j = str.length-1; i < j; i++ ,j--){
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
        }
    }

    private static void swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }
}



package 剑指offer;

import java.util.HashMap;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）
 * @author: yitl
 * @create: 2019-03-19
 */
public class Test34第一个只出现一次的字符位置 {

    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); ++i) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        for (int i = 0; i < str.length(); ++i) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    //自己实现的一个简单的哈希表
    public int FirstNotRepeatingChar1(String str) {

        int[] words = new int[58];
        for (int i = 0; i < str.length(); ++i) {
            words[str.charAt(i)-65] += 1;
        }
        for (int i = 0; i < str.length(); ++i) {
            if (words[str.charAt(i) - 65] == 1) {
                return i;
            }
        }
        return -1;
    }

}

package 剑指offer;

/**
 * @author: yitl
 * @create: 2019-03-23
 */
public class Test44翻转单词顺序列 {

    /**
     * 先反转整个句子，再一个单词一个单词的反转
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length-1);
        int blank = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, blank+1, i-1);
                blank = i;
            }
        }
        reverse(chars, blank+1, chars.length-1);
        return new String(chars);
    }

    private static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            ++left;
            --right;
        }
    }

}

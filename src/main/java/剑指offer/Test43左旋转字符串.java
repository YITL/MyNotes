package 剑指offer;

/**
 * @author: yitl
 * @create: 2019-03-22
 */
public class Test43左旋转字符串 {
    
    /**
     * 根据n把字符串分成前后两部分，并各自反转，最后整个字符串反转一次
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString1(String str,int n) {
        if (str.length() == 0) return str;
        char[] chars = str.toCharArray();
        n = n % chars.length;
        reverse(chars, 0, n-1);
        reverse(chars, n, chars.length-1);
        reverse(chars, 0, chars.length-1);
        return new String(chars);
    }

    public static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            ++left;
            --right;
        }
    }
}

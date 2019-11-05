package 剑指offer;

/**
 * @author: yitl
 * @create: 2019-03-26
 */
public class Test52正则表达式匹配 {

    public static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return match(str, strIndex, pattern, patternIndex);
    }

    public static boolean match(char[] str, int strIndex, char[] pattern, int patternIndex) {

        /*
        若模式串走完
            字符串也走完,返回ture
            字符串未走完,返回false
        若patternIndex的后一位是*
            若字符串和模式串当前指向的字符一样,或者pattern指向的字符是.
                有两种情况,一种是正常情况,只有字符串进位,另一种是*号前的字符数量为0,这种情况只有模式串进两位
                这两种情况只要有一个成功就好
            若字符串和模式串当前指向的字符不一样,且pattern也不是.
                模式串直接进两位
        若字符串和模式串当前指向的字符一样,或者pattern指向的字符是.
            字符串和模式串各进一位

         */

        if(patternIndex == pattern.length) {
            return strIndex == str.length;
        }
        if(patternIndex + 1 < pattern.length && pattern[patternIndex+1] == '*') {
            if(strIndex != str.length && (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.')) {
                return match(str, strIndex+1, pattern, patternIndex) ||
                        match(str, strIndex, pattern, patternIndex+2);
            }else{
                return match(str, strIndex, pattern, patternIndex+2);
            }
        }
        if(strIndex != str.length && (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.')) {
            return match(str, strIndex+1, pattern, patternIndex+1);
        }
        return false;
    }

}

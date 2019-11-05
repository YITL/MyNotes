package 剑指offer;

/**
 * @author: yitl
 * @create: 2019-03-25
 */
public class Test49字符串转int {

    private static boolean flag = true;//这个标志位是为了区分异常情况的0和正常的0

    public static int StrToInt(String str) {
        if (str.length() == 0) return 0;
        boolean isNegative = false;//符号位,负号->true,正号->false
        int i = 0;
        char[] chars = str.trim().toCharArray();

        //处理符号位
        if (chars[0] == '-' || chars[0] == '+') {
            if (chars.length == 1) {
                flag = false;
                return 0;//只有一个符号位,不符合规范
            }
            isNegative = chars[0] == '-';
            i = 1;
        }

        long res = 0;
        for (; i < chars.length; i++) {
            if (chars[i] > '9' || chars[i] < '0') {
                flag = false;
                return 0;
            }
            res = res * 10 + (chars[i] - '0');
        }

        return (int) (isNegative ? -res : res);
    }
}

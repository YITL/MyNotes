package 剑指offer;

/**
 * @author: yitl
 * @create: 2019-03-28
 */
public class Test53字符串转数值 {

    /**
     * 入手点是分别判断这三种符号，需要归纳总结的类型
     * e和E只能出现一次且不能在最后一位
     * 正负号可以在两个地方出现,一个在开头,一个在E和e后面
     * .只能出现一次,且不能和E和e共存
     * 最后记得判断,数要在0和9之间
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        boolean hasE = false;//是否含有e或者E
        boolean hasSign = false;//是否有符号
        boolean hasDecimal = false;//是否有小数点
        if (str.length == 0) {
            return false;
        }
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                //e和E不能是最后一位,且只能出现一次
                if (i == str.length-1) {
                    return false;
                }
                if (hasE) {
                    return false;
                } else {
                    hasE = true;
                }
            } else if (str[i] == '+' || str[i] == '-') {
                if (hasSign) {
                    //若有正负号,则这里的正负号只能出现在E和e后面
                    if (str[i-1] != 'E' && str[i-1] != 'e') {
                        return false;
                    }
                }else {
                    //若没有正负号,且当前索引不在0位上,则这里的正负号只能出现在E和e后面
                    if (i > 0 && str[i-1] != 'E' && str[i-1] != 'e') {
                        return false;
                    }
                }
                hasSign = true;
            } else if (str[i] == '.') {
                if (hasDecimal){
                    //.只能出现一次
                    return false;
                }
                if (hasE) {
                    int j = i;
                    for (; j >= 0; j--) {
                        if (str[j] == 'e' || str[j] == 'E') {
                            return false;
                        }
                    }
                }
                hasDecimal = true;
            } else if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }

}

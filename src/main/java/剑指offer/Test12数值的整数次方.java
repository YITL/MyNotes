package 剑指offer;

/**
 * @author: yitl
 * @create: 2019-03-12
 */
public class Test12数值的整数次方 {

    /**
     * 快速幂，核心其实就一个公式
     * 3^10 = 3^(1010) = 3^(3^3+3^1) = 3^(3^3) * 3^(3^1)
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base, int exponent) {
        if (base == 0) return 0;
        if (exponent == 0) return 1;
        boolean isNegative;
        if (exponent > 0) {
            isNegative = false;
        } else {
            isNegative = true;
            exponent = -exponent;
        }
        double res = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                res *= base;
            }
            base *= base;
            exponent >>= 1;
        }
        return isNegative ? 1/res : res;
    }

    /**
     * 这道题考察的是有没有考虑全各种情况，所以这个解法也算勉强可以接受吧
     * 有一个点就是，刚开始做的时候把res定义成了int，这样就会导致丢失小数点以后的部分，一定要注意
     * @param base
     * @param exponent
     * @return
     */
    public static double Power1(double base, int exponent) {
        if (base == 0) return 0;
        if (exponent == 0) return 1;
        boolean isNegative;
        if (exponent > 0) {
            isNegative = false;
        } else {
            isNegative = true;
            exponent = -exponent;
        }
        double res = 1;
        while (exponent-- > 0) {
            res *= base;
        }
        return isNegative ? 1/res : res;
    }



    public static void main(String[] args) {
        double power = Power(2, -3);
        System.out.println(power);
    }

}

package 剑指offer;

/**
 * @author: yitl
 * @create: 2019-03-25
 */
public class Test48位运算实现加法 {

    /**
     * 加法的位运算，先记录不进位的数，然后记录进位
     * 有一个进位，就要走一次循环
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        int sum, carry;//不计进位的和,进位
        while (num2 != 0) {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;//循环到进位为0为止
            //之后循环的就是没记进位的和与进位相加的结果,但是相加后可能还会产生进位,所以要循环
        }
        return num1;
    }

}

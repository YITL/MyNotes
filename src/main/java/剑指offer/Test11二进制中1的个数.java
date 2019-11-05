package 剑指offer;


public class Test11二进制中1的个数 {

    /*
     * 当一个数减去1时，最右面的1会变成0，然后这位后面的所有的0都变为1
     * 知道这个规律就好理解了
     */
    public static int NumberOf1_2(int n) {
        int res = 0;
        while (n != 0) {
            ++res;
            n = n & (n-1);
        }
        return res;
    }

    /**
     * 剑指offer提供的普通解法，和我写的基本一样，但比我的好一些，但我不喜欢这种方法
     * @param n
     * @return
     */
    public int NumberOf1_1(int n) {
        int tmp = 1;
        int res = 0;
        while (tmp != 0) { //这里要注意，不能是tmp > 0，还有最小值那个情况
            if ((n & tmp) != 0) { //这里不能写成(n & tmp) == 1，因为已经不是只有最低位的一位进行了&操作了，到后面，tmp是相当大的一个数
                ++res;
            }
            tmp = tmp << 1;
        }
        return res;
    }

    /*
     * 做这个题的时候，基础知识有些空缺，先列一下
     * 1.int为四个字节，一个字节有8位，所以int有32位
     * 2.<<为左移，也就是加0，相当于*2；>>为右移，也就是去位（这里也解释了为什么int没有四舍五入而是全部舍去），
     * 相当于/2。
     * 3.补码的概念不清楚，这里举一个例子，Integer.MIN_VALUE - 1 = Integer.MAX_VALUE
     * Integer.MAX_VALUE = 0x7fffffff(十六进制） = 0111 1111 1111 1111 1111 1111 1111 1111 = 2147483647
     * Integer.MIN_VALUE = 0x80000000(十六进制) = 1000 0000 0000 0000 0000 0000 0000 0000 = -2147483647
     * MIN_VALUE取反码就是（这里有个负号）0111 1111 1111 1111 1111 1111 1111 1111，就是-2147483647了
     * 最高一位是符号位，若为1则是负数，题目说了，负数按补码来算，我们就按补码算就好了，要算上符号位的1
     */
    public int NumberOf1(int n) {
        int tmp = 32;
        int res = 0;
        while (tmp-- > 0) {
            if ((n & 1) == 1) {
                ++res;
            }
            n = n >> 1;
        }
        return res;
    }

}

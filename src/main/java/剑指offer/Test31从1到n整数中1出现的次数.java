package 剑指offer;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数
 * （从1 到 n 中1出现的次数）。
 * @author: yitl
 * @create: 2019-03-17
 */
public class Test31从1到n整数中1出现的次数 {

    /**
     * 左神的书里面的解法，说的很清楚
     * 关键点就是分情况讨论，把最高位单独拿出来算，其他位根据排列组合算，最后递归
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n < 1) return 0;
        int len = String.valueOf(n).length();
        if (len == 1) {
            return 1;
        }
        int tmp = (int) Math.pow(10, len-1);

        int first = n/tmp;
        int firstRes = first == 1 ? n % tmp + 1 : tmp;
        int otherRes = first * (len-1) * tmp/10;
        return firstRes + otherRes + NumberOf1Between1AndN_Solution(n % tmp);
    }


}

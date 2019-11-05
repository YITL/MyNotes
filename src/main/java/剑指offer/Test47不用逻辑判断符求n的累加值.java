package 剑指offer;

/**
 * @author: yitl
 * @create: 2019-03-24
 */
public class Test47不用逻辑判断符求n的累加值 {

    /**
     * 递归，借用了短路的思想
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {

        int num = n;
        boolean flag = (num > 0) && ((num += Sum_Solution(n-1)) > 0);
        return num;

    }

}

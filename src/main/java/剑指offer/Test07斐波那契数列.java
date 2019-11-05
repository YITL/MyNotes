package 剑指offer;

public class Test07斐波那契数列 {

    //不要用递归
    public int Fibonacci(int n) {
        if(n == 0) return 0;
        int m1 = 0;
        int m2 = 1;
        int res = 1;
        while (--n > 0) {
            res = m1 + m2;
            m1 = m2;
            m2 = res;
        }
        return res;
    }

}

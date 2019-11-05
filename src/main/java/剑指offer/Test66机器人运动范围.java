package 剑指offer;


public class Test66机器人运动范围 {

    int res;
    public int movingCount(int threshold, int rows, int cols) {
        //记录状态的二维数组
        boolean[][] flags = new boolean[rows][cols];
        judge(threshold, rows, cols, 0, 0, flags);
        return res;
    }

    private void judge(int k, int rows, int cols, int i, int j, boolean[][] flags) {
        /*
        退出条件:
        1.下标越界
        2.元素各位和大于k
        3.已经访问过
         */
        if (i < 0 || j < 0 || i >= rows || j >= cols || help(i, j) > k || flags[i][j]) {
            return;
        }
        ++res;
        flags[i][j] = true;
        judge(k, rows, cols, i-1, j, flags);
        judge(k, rows, cols, i+1, j, flags);
        judge(k, rows, cols, i, j-1, flags);
        judge(k, rows, cols, i, j+1, flags);
    }

    //计算各位和
    private int help(int i, int j) {
        int res = 0;
        while (i > 0) {
            res += i % 10;
            i = i/10;
        }
        while (j > 0) {
            res += j % 10;
            j = j/10;
        }
        return res;
    }

}

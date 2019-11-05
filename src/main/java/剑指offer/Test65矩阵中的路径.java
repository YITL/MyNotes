package 剑指offer;

public class Test65矩阵中的路径 {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] flags = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (judge(matrix, i, j, rows, cols, flags, str, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean judge(char[] matrix, int i, int j, int rows, int cols, boolean[] flags, char[] str, int k) {
        int index = i * cols + j;
        /*
        退出条件:
        1.下标越界
        2.字符串当前字符和矩阵中的当前字符不匹配
        3.已经访问过
         */
        if (i<0 || j<0 || i >= rows || j >= cols || matrix[index] != str[k] || flags[index]) {
            return false;
        }
        //最后一个字符,直接返回成功
        if (k == str.length-1) {
            return true;
        }
        flags[index] = true;
        //四个方向有一个成功就可以
        if (judge(matrix, i-1, j, rows, cols, flags, str, k+1) ||
            judge(matrix, i+1, j, rows, cols, flags, str, k+1) ||
            judge(matrix, i, j-1, rows, cols, flags, str, k+1) ||
            judge(matrix, i, j+1, rows, cols, flags, str, k+1) )
        {
            return true;
        }
        //这条路走不通之后,复原标识,方便其他路使用
        flags[index] = false;
        return false;
    }

}

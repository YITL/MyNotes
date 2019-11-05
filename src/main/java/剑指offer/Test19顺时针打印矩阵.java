package 剑指offer;

import java.util.ArrayList;

/**
 * @author: yitl
 * @create: 2019-03-13
 */
public class Test19顺时针打印矩阵 {

    /**
     * 简单题，就是要抠细节
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int row1 = 0, column1 = 0, row2 = matrix.length-1, column2 = matrix[0].length-1;
        while (row1 <= row2 && column1 <= column2) {
            print(matrix, row1++, column1++, row2--, column2--, list);
        }
        return list;
    }

    public void print(int[][] matrix, int row1, int column1, int row2, int column2, ArrayList list) {
        int a = row1, b = column1;
        if (row1 == row2) {
            while (b <= column2) list.add(matrix[a][b++]);
            return;
        }
        if (column1 == column2) {
            while (a <= row2) list.add(matrix[a++][b]);
            return;
        }
        while (b < column2) list.add(matrix[a][b++]);
        while (a < row2) list.add(matrix[a++][b]);
        while (b > column1) list.add(matrix[a][b--]);
        while (a > row1) list.add(matrix[a--][b]);
    }

}

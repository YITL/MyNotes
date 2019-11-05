package others;

/**
 * 顺时针旋转正方形（默认为正方形）
 * @author yitl
 *
 */
public class RotateMatrix {
	
	public static void rotate(int[][] matrix) {
		int a = 0;
		int b = 0;
		int c = matrix.length - 1;
		int d = matrix[0].length - 1;
		while(a < c) {
			rotateEdge(matrix, a++, b++, c--, d--);
		}
	}
	
	public static void rotateEdge(int[][] m, int a, int b, int c, int d) {
		int times = d - b;
		int tmp = 0;
		for(int i = 0; i != times; i++) {
			tmp = m[a][b+i];
			m[a][b+i] = m[c-i][b];
			m[c-i][b] = m[c][d-i];
			m[c][d-i] = m[a+i][d];
			m[a+i][d] = tmp;
		}
	}
	
	public static void printMatrix(int[][] m) {
		for(int i = 0; i != m.length; i++) {
			for(int j = 0; j != m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] m = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		printMatrix(m);
		rotate(m);
		System.out.println("================");
		printMatrix(m);
	}
	
}

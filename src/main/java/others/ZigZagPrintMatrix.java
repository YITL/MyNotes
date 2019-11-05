package others;

/**
 * 之字形打印矩阵
 * @author yitl
 *
 */
public class ZigZagPrintMatrix {

	public static void zigZagPrintMatrix(int[][] matrix) {
		//(tR, tC) (dR, dC)
		int tR = 0;
		int tC = 0;
		int dR = 0;
		int dC = 0;
		int endR = matrix.length - 1;
		int endC = matrix[0].length - 1;
		boolean fromUp = false;
		while(tR != endR + 1) {
			printLevel(matrix, tR, tC, dR, dC, fromUp);
			//这里注意一下，因为tC和dR为判断条件，所以必须放在tR和dC的下面。
			tR = tC == endC ? tR+1 : tR;
			tC = tC == endC ? tC : tC+1;
			dC = dR == endR ? dC+1 : dC;
			dR = dR == endR ? dR : dR+1;
			fromUp = !fromUp;
		}
		System.out.println();
	}
	
	/**
	 *  打印一条斜线上的数据
	 *  （tR， tC）为从（0，1）方向走的点，（dR，dC）为从（1，0）方向走的点。
	 * @param m
	 * @param tR
	 * @param tC
	 * @param dR
	 * @param dC
	 * @param fromUp 从上打印还是从下打印。
	 */
	public static void printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean fromUp) {
		if(fromUp) {
			while(tR != dR + 1) {
				System.out.print(m[tR++][tC--] + " ");
			}
		}else {
			while(dR != tR - 1) {
				System.out.print(m[dR--][dC++] + " ");
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] m = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		zigZagPrintMatrix(m);
	}
	
}

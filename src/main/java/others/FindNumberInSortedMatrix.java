package others;

/**
 * 在已经排好序的矩阵中找到一个数
 * 左 -> 右 和 上 -> 下 都是小到大的顺序
 * @author yitl
 *
 */
public class FindNumberInSortedMatrix {

	//从右上角开始,arr[row][col]小于k下跳，大于k左跳
	public static boolean isContains(int[][] m, int k) {
		int row = 0;
		int col = m[0].length - 1;
		while(row < m.length && col > -1) {
			if(m[row][col] == k) {
				return true;
			}else if(m[row][col] > k) {
				col--;
			}else {
				row++;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] m = new int[][] { { 0, 1, 2, 3, 4, 5, 6 },// 0
			{ 10, 12, 13, 15, 16, 17, 18 },// 1
			{ 23, 24, 25, 26, 27, 28, 29 },// 2
			{ 44, 45, 46, 47, 48, 49, 50 },// 3
			{ 65, 66, 67, 68, 69, 70, 71 },// 4
			{ 96, 97, 98, 99, 100, 111, 122 },// 5
			{ 166, 176, 186, 187, 190, 195, 200 },// 6
			{ 233, 243, 321, 341, 356, 370, 380 } // 7
		};
		int k = 233;
		System.out.println(isContains(m, k));
	}
	
}

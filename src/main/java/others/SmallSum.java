package others;


/**
 *  小和问题（归并排序的应用）
 *  题目：在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和。
 * @author yitl
 */
public class SmallSum {
	
	/**
	 * 取出数组的头索引和尾索引传入重载方法
	 * @param arr
	 */
	public static int smallSum(int[] arr) {
		if(arr == null || arr.length < 2) {
			return 0;
		}
		return smallSum(arr, 0, arr.length-1);
	}
	
	/**
	 * 归并操作的入口，此处有一个递归操作
	 * @时间复杂度：根据master公式来求，可知有两个子过程，每个子过程的样本量位n/2，并且执行了两次，
	 * 所以公式的前半部分为2T（n/2）。之后的merge（）操作是一个遍历操作，因此为O（n），所以总的公式为
	 * T(n)=2T(n/2)+O(n)。
	 * log(2,2) = 1 = 1,因此时间复杂度为O（N^d * logN) = O(n*log(n))。
	 * @额外空间复杂度：空间复杂度为O（N），因为merge（）方法中，用了一个help临时数组。
	 * @param arr
	 * @param L
	 * @param R
	 */
	public static int smallSum(int[] arr, int L, int R) {
		if(L == R) {
			return 0;
		}
		int mid = L + ((R-L)>>1);
		return smallSum(arr, L, mid) + smallSum(arr, mid+1, R) + merge(arr, L, mid, R);
	}
	
	/**
	 * 归并操作求小和
	 * @param arr
	 * @param L
	 * @param M
	 * @param R
	 */
	public static int merge(int[] arr, int L, int M, int R) {
		//准备一个临时数组存储归并排序的结果，然后覆盖到原数组
		int[] help = new int[R-L+1];
		int i = 0;
		//前半部分的指针
		int p1 = L;
		//后半部分的指针
		int p2 = M + 1;
		//保存归并的过程中小和的结果
		int res = 0;
		while(p1 <= M && p2 <= R) {
			//核心逻辑
			res += arr[p1] < arr[p2] ? (R - p2 + 1)*arr[p1] : 0;
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while(p1 <= M) {
			help[i++] = arr[p1++];
		}
		while(p2 <= R) {
			help[i++] = arr[p2++];
		}
		for(i=0; i<help.length; i++) {
			arr[L + i] = help[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		int testTimes = 500000;
		int maxSize = 7;
		int maxValue = 10;
		boolean succeed = true;
		for(int i=0; i<testTimes; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			if(smallSum(arr1) != comparator(arr2)) {
				succeed = false;
				print(arr1);
				print(arr2);
				break;
			}
		}
		System.out.println(succeed ? "ok" : "no");
		System.out.println(System.currentTimeMillis());
	}
	
	/**
	 * 打印输出
	 * @param arr
	 */
	public static void print(int[] arr) {
		if(arr == null) {
			return;
		}
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	/**
	 * 判断两个数组是否相等
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if((arr1 == null && arr2 != null) || (arr2 == null && arr1 != null)) {
			return false;
		}
		if(arr1 == null && arr2 == null) {
			return true;
		}
		if(arr2 != null && arr1 != null) {
			return true;
		}
		for(int i=0; i<arr1.length; i++) {
			if(arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 复制数组
	 * @param arr
	 * @return
	 */
	public static int[] copyArray(int[] arr) {
		if(arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}
	
	/**
	 * 用java自带的排序作为对数器的比较方法。（一般选用绝对正确的，易实现的，不用考虑性能问题）
	 * @param arr
	 */
	public static int comparator(int[] arr) {
		if(arr == null || arr.length < 2) {
			return 0;
		}
		int res = 0;
		for(int i = 1; i < arr.length; i++) {
			for(int j = 0; j < i; j++) {
				res += arr[j] < arr[i] ? arr[j] : 0;
			}
		}
		return res;
	}
	
	/**
	 * 生成长度随机的数组
	 * 这里对(int)((maxSize+1)*Math.random())进行以下解释：
	 * Math.random() -> double [0,1)，假设这里的maxSize=5，size+1=6，
	 * (maxSize+1)*Math.random() -> double [0,6) -> int [0,5]
	 * @param maxSize 数组的长度
	 * @param maxValue 数组的最大值
	 * @return
	 */
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int)((maxSize+1)*Math.random())];
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)((maxValue+1)*Math.random()) - (int)((maxValue)*Math.random());
		}
		return arr;
	}
	
	/**
	 * 交换位置
	 * @param arr
	 * @param i
	 * @param j
	 */
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
}

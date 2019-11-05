package others;

import java.util.Arrays;

/**
 * 归并排序
 * @author yitl
 */
public class MergeSort {
	
	public static void mergeSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		mergeSort(arr, 0, arr.length-1);
	}
	
	public static void mergeSort(int[] arr, int L, int R) {
		if(L == R) {
			return;
		}
		int mid = L + (R - L) / 2;
		mergeSort(arr, L, mid);
		mergeSort(arr, mid+1, R);
		merge(arr, L, mid, R);
	}
	
	public static void merge(int[] arr, int L, int M, int R) {
		//准备一个临时数组存储归并排序的结果，然后覆盖到原数组
		int[] help = new int[R-L+1];
		int i = 0;
		//前半部分的指针
		int p1 = L;
		//后半部分的指针
		int p2 = M + 1;
		while(p1 <= M && p2 <= R) {
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
			//bubbleSort(arr1);
			mergeSort(arr1);
			comparator(arr2);
			if(!isEqual(arr1, arr2)) {
				succeed = false;
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
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
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

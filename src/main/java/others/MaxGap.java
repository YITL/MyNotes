package others;

import java.util.Arrays;

/**
 * 最大间隔问题。
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度O(N)，且要求不能用非基于比较的排序
 * 核心在于，构建N+1个桶。n个数肯定放不满，所以一定会有一个空桶。空桶的意义在于否定最大插值在一个桶里面的可能性，这样
 * 才可以通过计算桶间的插值，并选出最大的作为最大差值。
 * @author yitl
 */
public class MaxGap {
	
	public static int maxGap(int[] arr) {
		if(arr == null || arr.length < 2) {
			return 0;
		}
		//遍历找出数组的最大值和最小值
		int len = arr.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < len; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		if(min == max) {
			return 0;
		}
		
		//构建（len+1）个桶；每个桶只维护三个值，最大值，最小值，和是否有值
		boolean[] hasNum = new boolean[len + 1];
		int[] maxs = new int[len + 1];
		int[] mins = new int[len + 1];
		int bid = 0;
		for(int i = 0; i < len; i++) {
			bid = bucket(arr[i], len, min, max);
			mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
			maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
			hasNum[bid] = true;
		}
		
		//从1的位置开始遍历，每个桶的最小值都和前面一个桶的最大值比较（空桶会被跳过），选出最大差值
		int res = 0;
		int lastMax = maxs[0];//0号桶一定会有值，因为构建桶时默认放进去最小值。
		int i = 1;
		for(; i<=len; i++) {
			if(hasNum[i]) {
				res = Math.max(res, mins[i] - lastMax);
				lastMax = maxs[i];
			}
		}
		return res;
	}
	
	/**
	 * 给出以下四个值，分完桶以后再给出这个数所在的桶的id
	 * @param num 数组中随机的一个数
	 * @param len 数组的长度
	 * @param min 数组的最小值
	 * @param max 数组的最大值
	 * @return
	 */
	public static int bucket(long num, long len, long min, long max) {
		return (int)((num - min) * len / (max - min));
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
			if(maxGap(arr1) != comparator(arr2)) {
				succeed = false;
				print(arr1);
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
		Arrays.sort(arr);
		int gap = Integer.MIN_VALUE;
		for(int i = 1; i < arr.length; i++) {
			gap = Math.max(arr[i] - arr[i-1], gap);
		}
		return gap;
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
}

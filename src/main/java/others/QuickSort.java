package others;

import java.util.Arrays;

/**
 * 随机快排
 * @author yitl
 *
 */
public class QuickSort {
	
	public static void quickSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		quickSort(arr, 0, arr.length-1);
	}
	
	/**
	 * 迭代部分
	 * 这里的swap操作解决了数组的特殊性对于快排性能的影响。 
	 * 假如处理{1，2，3，4，5，6}这样的数组，只能分成2个区域，一次partition只能解决一个数，这样实际的时间复杂度就是O（N²），
	 * 时间复杂度是O（N），可以看出瞬间就变得很垃圾。
	 * @时间复杂度：和归并排序类似，时间复杂度同样为：O(N*log(N))，同样是两个子过程，执行了两次子过程，还有一次
	 * partition操作，但这里和归并排序有区别， 归并排序借助了一个数组，而快排只用了几个常量，就因为这点，快排实用性更强。
	 * @空间复杂度：O（log（N）），这个值和概率有关，分块处理的时候是需要记住一个中间值，这样处理完前半部分才可以找到
	 * 后半部分继续处理，而每个子过程也要分，所以再平均情况下，arr.length能除以2几次，就需要几个中间值，也就是log(N)。 
	 * @param arr
	 * @param L
	 * @param R
	 */
	public static void quickSort(int[] arr, int L, int R) {
		if(L < R) {
			swap(arr, 1+(int)(Math.random() * (R-L+1)), R);
			int[] p = partition(arr, L, R);
			quickSort(arr, L, p[0]-1);
			quickSort(arr, p[1]+1, L);
		}
	}
	
	/**
	 * 核心逻辑
	 * 这里和荷兰国旗问题有一点区别，就是more指针的初始化。这样做就是把标准值即尾节点先放在more区域，最后再换出来。
	 * 这样就可以保证返回值一定是有两个值的数组，而不会产生错误的索引或者溢出。
	 * 
	 * @param arr
	 * @param L
	 * @param R
	 * @return
	 */
	public static int[] partition(int[] arr, int L, int R) {
		int less = L-1;
		int more = R;
		while(L < more) {
			if(arr[L] < arr[R]) {
				swap(arr, ++less, L++);
			}else if(arr[L] > arr[R]) {
				swap(arr, --more, L);
			}else {
				L++;
			}
		}
		swap(arr, more, R);
		return new int[] {less + 1, more};
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
			//mergeSort(arr1);
			quickSort(arr1);
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
	 * 值交换
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

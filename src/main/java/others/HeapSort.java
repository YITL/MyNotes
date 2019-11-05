package others;

import java.util.Arrays;

/**
 * 堆排序
 * 堆排序有两个主要过程，一个是构建大根堆（遍历+heapInsert），另一个就是不断从堆顶弹出最大值（遍历+heapify）。
 * 这两个方法简单来说，是一个是跟上比，一个是跟下比；一个上浮，一就个下沉。
 * 时间复杂度：准备大根堆的时候，花费的时间为log(1)+log(2)+log(3)+...+log(n)，这里的log（n）是树的深度，
 * 这个算式的结果是O（n），怎么算的是数学问题，此处不介绍。排序的总的时间复杂度为O（n*log(n))。
 * 空间复杂度：O（1），因为只用了几个常量。
 * @author yitl
 *
 */
public class HeapSort {
	
	public static void heapSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		for(int i=0; i<arr.length; i++) {
			heapInsert(arr, i);
		}
		int size = arr.length;
		swap(arr, 0, --size);
		while(size > 0) {
			heapify(arr, 0, size);
			swap(arr, 0, --size);
		}
	}
	
	/**
	 * 这个方法本意是从一个堆的末尾位置添加值，然后不断跟父节点比较，比父节点大则与父节点互换，达到上升的目的，
	 * 并进行下一轮比较，直到升不动为止。
	 * 这里隐含了一个判断，如果index为0，即到达了堆顶的位置后，（0-1）/2 = 0，循环依然停止
	 * 这里提一下int的小数判断机制，机制就是，直接舍弃。。。
	 * 不仅1.5==1，-0.5也等于-0，即0。
	 * @param arr
	 * @param index index一般为对的末尾，选择其他位置也可以
	 */
	public static void heapInsert(int[] arr, int index) {
		while(arr[index] > arr[(index-1)/2]) {
			swap(arr, index, (index-1)/2);
			index = (index - 1)/2;
		}
	}
	
	/**
	 * 主方法先把堆顶的最大值和堆的末尾进行值交换，这样整个数组的最大值就在数组的最后一个索引固定了，此时变量size
	 * 是数组的size-1，然后传入这个方法，也就是说，这个数组处理的堆已经不包含放在数组末尾的那个最大值了。
	 * 这个算法巧妙的使用了两个二元判断方法，要下沉，首先要满足左儿子必须存在（也可以说没有越界），然后再判断，如果
	 * 右儿子也存在并且值比左儿子大，那么large指针指在右儿子，两点不是同时满足，large指针都指在左儿子。接下来再与
	 * index比较，index大就跳出循环，index小则进行large和index的值交换，此时large指针已经指在了换下来的这个小值，
	 * 然后准备下一轮的判断条件，即准备index和左儿子left。
	 * @param arr
	 * @param index 在这个排序里，index一般都是0，也可以拿出使用在其他情况。
	 * @param size 注意，这里的size就是堆的大小，所以要处理的堆的最后一个索引是size-1。
	 */
	public static void heapify(int[] arr, int index, int size) {
		int left = index * 2 + 1;
		while(left < size) {
			int largest = (left + 1 < size && arr[left + 1] > arr[left]) ? left + 1: left;
			largest = arr[largest] > arr[index] ? largest : index;
			if(largest == index) {
				break;
			}
			swap(arr, largest, index);
			index = largest;
			left = index * 2 + 1;
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
			//mergeSort(arr1);
//			quickSort(arr1);
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

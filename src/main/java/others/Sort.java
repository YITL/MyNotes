package others;

/**
 * 三种简单排序：冒泡、选择、插入
 * @author yitl
 */
public class Sort {
	
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
	}
	
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int)((maxSize+1)*Math.random())];
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)((maxValue+1)*Math.random()) - (int)((maxValue)*Math.random());
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = {13, 54, 23, 1, 5};
		//bubbleSort(arr);
		//selectSort(arr);
		insertionSort(arr);
		print(arr);
		//int[] randomArray = generateRandomArray(7, 9);
		//print(randomArray);
	}
	
	/**
	 * 冒泡排序
	 * 每次都是前一位和后一位比较，相当于一个嵌套循环。每次小循环都把当前小循环队列的极值放到这个数组的末尾
	 * 或开头，这样依次进行，直到整个数组排序完毕。
	 * @时间复杂度：对于这个算法，共经过了n+(n-1)+(n-2)+...+3+2+1次常数操作，可以看出这就是一个等差数列。
	 * 根据求和公式，可以近似看为aN²+bN+c，然后忽略低阶项和高阶项的系数，我们可以得出n²，即O（N²）。
	 * @额外空间复杂度: O(1)
	 * @param arr
	 */
	public static void bubbleSort(int[] arr ) {
		if(arr == null || arr.length < 2) {
			return;
		}
		for(int end=arr.length-1; end>0; end--) {
			for(int i=0; i<end; i++) {
				if(arr[i] > arr[i+1]) {
					swap(arr, i, i+1);
				}
			}
		}
	}

	//优化版本
	public static void bubbleSort1(int[] arr) {
		if (arr.length <= 1) return;
		for (int i = arr.length-1; i > 0; --i) {
			boolean flag = false;
			for (int j = 0; j < i; ++j) {
				if (arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
					flag = true;
				}
			}
			if (!flag) break;
		}
	}

	/**
	 * 选择排序
	 * 同样是一个嵌套循环。每次小循环选出当前队列的最小值的索引，即minIndex，然后和大循环的指针i对应的索引互换。
	 * @时间复杂度：这个算法和冒泡很相似，只有选出极值的方法有细微区别，因此时间复杂度同样为O（N²）。
	 * @额外空间复杂度：O(1)
	 * @param arr
	 */
	public static void selectSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		for(int i=0; i < arr.length-1; i++) {
			int minIndex = i;
			for(int j=i+1; j < arr.length; j++) {
				minIndex = arr[j] < arr[minIndex] ? j : minIndex;
			}
			swap(arr, i, minIndex);
		}
	}
	
	/**
	 * 插入排序
	 * 仍旧是嵌套循环。大循环从索引1开始而不是0，因为0处只有一个数据，无需排序。每次大循环的i指针指向的数据，并入前面的队列，
	 * 然后与前面的有序队列的最后一位比较大小（和冒泡类似），直到找到自己的位置为止。
	 * @时间复杂度：不同于前两个排序方法，插入排序至今仍旧有利用价值。插入排序的复杂度和排序数据的特点有关系，以此算法为例，
	 * 假如数据为"1,2,3,4,5"，则实际复杂度为O（N），但假如数据为"5,4,3,2,1"，则实际复杂度为O（N²）。
	 * 但时间复杂度应该以最坏情况为标准，所以插入排序的时间复杂度为O（N²）。
	 * @额外空间复杂度: O(1)
	 * @param arr
	 */
	public static void insertionSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		for(int i=1; i<arr.length; i++) {
			for(int j=i-1; j>=0 && arr[j]>arr[j+1]; j--) {
				swap(arr, j, j+1);
			}
		}
	}

	//优化版本
	public static void insertSort(int[] arr) {
		if (arr.length <= 1) return;
		for (int i = 1; i < arr.length; ++i) {
			int value = arr[i];
			int j = i - 1;
			for (; j >= 0; --j) {
				if (arr[j] > value) {
					arr[j+1] = arr[j];
				} else {
					break;
				}
			}
			arr[j+1] = value;
		}
	}
	
	
	
}

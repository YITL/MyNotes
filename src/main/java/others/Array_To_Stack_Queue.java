package others;

public class Array_To_Stack_Queue {
	
	/**
	 * 数组简单实现的栈，初始化后，zise指针停在0位置，size始终停在数据的右边一位，满的时候即在数组外一位。
	 * 分别实现了进栈、弹栈、和获取栈顶。
	 * @author yitl
	 */
	public static class ArrayStack {
		
		private Integer[] arr;
		private Integer size;
		
		public ArrayStack(int initSize) {
			if(initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			size = 0;
		}
		
		public Integer peek() {
			if(size == 0) {
				return null;
			}
			return arr[size - 1];
		}
		
		public void push(int obj) {
			if(size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			arr[size++] = obj;
		}
		
		public Integer pop() {
			if(size == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			return arr[--size];
		}
		
	}
	
	/**
	 * 数组实现的队列。
	 * 此处维护了三个变量，size用于first和last的解耦；last用于数据的添加，和上面的ArrayStack相似，都在数据的右边一位，
	 * 不同的是，当last直到arr.length - 1的位置时，会重新回到0的位置上；first则用于弹出数据，始终指在数据左边头上，和
	 * last一样，也可以循环。
	 * 简单来说，就是first追着last跑。
	 * @author yitl
	 */
	public static class ArrayQueue {
		
		private Integer[] arr;
		private Integer size;
		private Integer first;
		private Integer last;
		
		public ArrayQueue(int initSize) {
			if(initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			size = 0;
			first = 0;
			last = 0;
		}
		
		public Integer peek() {
			if(size == 0) {
				return null;
			}
			return arr[first];
		}
		
		public void push(int obj) {
			if(size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			size++;
			arr[last] = obj;
			last = last == arr.length - 1 ? 0 : last + 1;
		}
		
		public Integer poll() {
			if(size == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			size--;
			int tmp = first;
			first = first == arr.length - 1 ? 0 : first + 1;
			return arr[tmp];
		}
		
	}
	
}

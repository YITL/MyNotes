package others;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueueConvert {

	/**
	 * 用两个栈实现队列。
	 * 存数据的时候都先放入push栈，需要取数据的时候，把push栈里面的数据全部弹入pop栈里面，并一直从pop栈取元素，
	 * pop栈只要还剩余有数据，就不重新从push栈取，一旦pop栈空了，再一次把push栈里的数据全部弹进去。 
	 * @author yitl
	 */
	public static class TwoStacksQueue {
		
		private Stack<Integer> stackPush;
		private Stack<Integer> stackPop;
		
		public TwoStacksQueue() {
			stackPush = new Stack<Integer>();
			stackPop = new Stack<Integer>();
		}
		
		public void push(int pushInt) {
			stackPush.push(pushInt);
		}
		
		public int poll() {
			if(stackPush.empty() && stackPop.empty()) {
				throw new RuntimeException("getMiddle is empty.");
			}else if(stackPop.empty()) {
				while(!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.pop();
		}
		
		public int peek() {
			if(stackPush.empty() && stackPop.empty()) {
				throw new RuntimeException("getMiddle is empty.");
			}else if(stackPop.empty()) {
				while(!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.peek();
		}
	}
	
	/**
	 * 用两个队列实现栈
	 * 存的时候直接存queue里面。取的时候queue队列往help队列里面放数据，放到只剩下一个数据为止，然后转换两个队列的索引。
	 * 即保持help队列始终为空的状态，pop和peek的区别就是peek用完最后一个数据后，再存入help队列中。 
	 * @author yitl
	 */
	public static class TwoQueuesStack {
		
		private Queue<Integer> queue;
		private Queue<Integer> help;
		
		public TwoQueuesStack() {
			queue = new LinkedList<Integer>();
			help = new LinkedList<Integer>();
		}
		
		public void push(int pushInt) {
			queue.add(pushInt);
		}
		
		public int peek() {
			if(queue.isEmpty()) {
				throw new RuntimeException("Stack is empty.");
			}
			while(queue.size() > 1) {
				help.add(queue.poll());
			}
			int res = queue.poll();
			help.add(res);
			swap();
			return res;
		}
		
		public int pop() {
			if(queue.isEmpty()) {
				throw new RuntimeException("Stack is empty.");
			}
			while(queue.size() > 1) {
				help.add(queue.poll());
			}
			int res = queue.poll();
			swap();
			return res;
		}
		
		private void swap() {
			Queue<Integer> tmp = help;
			help = queue;
			queue = tmp;
		}
	}
	
}

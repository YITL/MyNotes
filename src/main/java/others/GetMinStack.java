package others;

import java.util.Stack;

public class GetMinStack {
	
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	public GetMinStack() {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}
	
	//如果stackMin为空直接存入，否则两者选更小的一方来存。
	public void push(int newNum) {
		if(this.stackMin.isEmpty()) {
			this.stackMin.push(newNum);
		}else if(newNum < this.getMin()) {
			this.stackMin.push(newNum);
		}else {
			int newMin = this.stackMin.peek();
			this.stackMin.push(newMin);
		}
		this.stackData.push(newNum);
	}
	
	//只需要保持staciMin同步弹栈即可。
	public int pop() {
		if(this.stackData.isEmpty()) {
			throw new RuntimeException("Your stack is empty.");
		}
		this.stackMin.pop();
		return this.stackData.pop();
	}
	
	//只需要取出stackMin维护的栈顶即可。
	public int getMin() {
		if(this.stackMin.isEmpty()) {
			throw new RuntimeException("Your stack is empty.");
		}
		return this.stackMin.peek();
	}
	
}

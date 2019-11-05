package others;

import java.util.Stack;

/**
 * 判断是否为回文链表
 * @author yitl
 *
 */
public class IsPalindromeList {

	public static class Node{
		public int value;
		public Node next;
		public Node(int data) {
			this.value = data;
		}
	}
	
	/**
	 * 用了n的额外空间
	 * @param head
	 * @return
	 */
	public static boolean isPalindrome1(Node head) {
		Stack<Node> stack = new Stack<Node>();
		Node cur = head;
		while(cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while(head != null) {
			if(stack.pop().value != head.value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
	
	/**
	 * 用了n/2的额外空间
	 * @param head
	 * @return
	 */
	public static boolean isPalindrome2(Node head) {
		if(head.next == null || head == null) {
			return true;
		}
		Node right = head.next;
		Node cur = head;
		while(cur.next != null && cur.next.next != null) {
			right = right.next;
			cur = cur.next.next;
		}
		Stack<Node> stack = new Stack<Node>();
		while(right != null) {
			stack.push(right);
			right = right.next;
		}
		while(!stack.isEmpty()) {
			if(head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
	
	/**
	 * 用了O（1）的额外空间
	 * @param head
	 * @return
	 */
	public static boolean isPalindrome3(Node head) {
		if(head == null || head.next == null) {
			return true;
		}
		Node n1 = head;
		Node n2 = head;
		while(n2.next != null && n2.next.next != null) {
			n1 = n1.next;
			n2 = n2.next.next;
		}
		//复用n2指针，指向右半部分第一个节点
		n2 = n1.next;
		n1.next = null;
		Node n3 = null;//用作后趋指针
		//反转右半部分，此处复用了n1节点，用作前趋指针
		while(n2 != null) {
			n3 = n2.next;
			n2.next = n1;//这里为后面恢复做了准备
			n1 = n2;
			n2 = n3;
		}
		n3 = n1;//备份尾节点（后半部分反转后的头节点，为了复原用的）
		n2 = head;
		boolean res = true;
		while(n1 != null && n2 != null) {
			if(n1.value != n2.value) {
				res = false;
				break;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		
		//开始复原反转后的后半部分，n2用作前趋指针
		n1 = n3.next;//复用n3指针，用作后趋指针
		n3.next = null;
		while(n1 != null) {
			n2 = n1.next;
			n1.next = n3;
			n3 = n1;
			n1 = n2;
		}
		return res;
	}
	
	public static void printLinkedList(Node head) {
		System.out.print("Linked List: ");
		while(head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}

	//后面自己写的
	public static boolean isPalindrome (Node head) {
		Node fast = head;
		Node slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = slow.next;
		fast = reverse(fast);
		Node tmp = fast;
		slow = head;
		while (slow != null && fast != null) {
			if (slow.value != fast.value) return false;
			slow = slow.next;
			fast = fast.next;
		}
		reverse(tmp);
		return true;
	}

	public static Node reverse(Node head) {
		Node pre = null;
		Node cur = head;
		Node next;
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	
	public static void main(String[] args) {
		
		Node head = null;
		
		head = new Node(2);
		head.next = new Node(3);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
	}
}

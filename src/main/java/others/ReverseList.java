package others;

/**
 * 单项链表和双向链表的逆序
 * @author yitl
 *
 */
public class ReverseList {

	public static class Node{
		public int data;
		public Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static Node Reverse(Node head) {
		Node pre = null;
		Node next = null;
		while(head != null) {
			next = head.next;
			head.next = pre;
			//指针移动
			pre = head;
			head = next;
		}
		return pre;
	}
	
	public static class DoubleNode{
		public int data;
		public DoubleNode next;
		public DoubleNode pre;
		public DoubleNode(int data) {
			this.data = data;
		}
	}
	
	public static DoubleNode Reverse_double(DoubleNode head) {
		DoubleNode pre = null;
		DoubleNode next = null;
		while(head != null) {
			next = head.next;
			head.next = pre;
			head.pre = next;
			//指针移动
			pre = head;
			head = next;
		}
		return pre;
	}
	
	public static void PrintLinkedList(Node head) {
		System.out.print("Linked List : ");
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void PrintDoubleLinkedList(DoubleNode head) {
		System.out.print("Double Linked List : ");
		DoubleNode end = null;
		while(head != null) {
			System.out.print(head.data + " ");
			end = head;
			head = head.next;
		}
		System.out.print("| ");
		while(end != null) {
			System.out.print(end.data + " ");
			end = end.pre;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		PrintLinkedList(head1);
		head1 = Reverse(head1);
		PrintLinkedList(head1);
		
		DoubleNode head2 = new DoubleNode(4);
		head2.next = new DoubleNode(5);
		head2.next.pre = head2;
		head2.next.next = new DoubleNode(6);
		head2.next.next.pre = head2.next;
		PrintDoubleLinkedList(head2);
		head2 = Reverse_double(head2);
		PrintDoubleLinkedList(head2);
		
	}
}

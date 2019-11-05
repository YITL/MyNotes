package others;

import java.util.HashMap;

/**
 * 复制含有随机节点的链表
 * @author yitl
 */
public class CopyListWithRandom {

	public static class Node{
		public int value;
		public Node next;
		public Node rand;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	/**
	 * 用了一个hashmap作为辅助空间
	 * @param head
	 * @return
	 */
	public static Node copyListWithRandom1(Node head) {
		HashMap<Node, Node> map = new HashMap<>();
		Node cur = head;
		while(cur != null) {
			map.put(cur, new Node(cur.value));
			cur = cur.next;
		}
		cur = head;
		while(cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).rand = map.get(cur.rand);
			cur = cur.next;
		}
		return map.get(head);
	}
	
	/**
	 * 不借助辅助空间
	 * @param head
	 * @return
	 */
	public static Node copyListWithRandom2(Node head) {
		if(head == null) {
			return null;
		}
		
		//复制每个节点并放在本节点后面
		Node cur = head;
		Node next = null;
		while(cur != null) {
			next = cur.next;
			cur.next = new Node(cur.value);
			cur.next.next = next;
			cur = next;
		}
		
		//复制节点根据被复制节点的rand指针完成自己的rand指针
		cur = head;
		Node curCopy = null;
		while(cur != null) {
			next = cur.next.next;
			curCopy = cur.next;
			curCopy.rand = cur.rand != null ? cur.rand.next : null;
			cur = next;
		}
		
		//分离链表
		Node res = head.next;
		cur = head;
		while(cur != null) {
			next = cur.next.next;
			curCopy = cur.next;
			cur.next = next;
			curCopy.next = next != null ? next.next : null;
			cur = next;
		}
		
		return res;
	}
	
	//打印
	public static void printRandomLinkedList(Node head) {
		Node cur = head;
		System.out.println("order: ");
		while(cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println();
		cur = head;
		System.out.println("random: ");
		while(cur != null) {
			System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
			cur = cur.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node head = null;
		Node res1 = null;
		Node res2 = null;
		
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		head.rand = head.next.next.next.next.next; // 1 -> 6
		head.next.rand = head.next.next.next.next.next; // 2 -> 6
		head.next.next.rand = head.next.next.next.next; // 3 -> 5
		head.next.next.next.rand = head.next.next; // 4 -> 3
		head.next.next.next.next.rand = null; // 5 -> null
		head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4
		
		printRandomLinkedList(head);
		res1 = copyListWithRandom1(head);
		printRandomLinkedList(res1);
		res2 = copyListWithRandom2(head);
		printRandomLinkedList(res2);
		printRandomLinkedList(head);
	}
	
}

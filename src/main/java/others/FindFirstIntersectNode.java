package others;

public class FindFirstIntersectNode {

	public static class Node{
		public int value;
		public Node next;
		public Node(int value) {
			this.value = value;
		}
	}
	
	/**
	 * 总方法入口，判断这两个链表是哪种情况。
	 * 注意：一条有环一条无环是不可能相交的。
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static Node getIntersectNode(Node head1, Node head2) {
		if(head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		if(loop1 == null && loop2 == null) {
			return noLoop(head1, head2);
		}
		if(loop1 != null && loop2 != null) {
			return bothLoop(head1, loop1, head2, loop2);
		}
		return null;
	}
	
	/**
	 * 判断一个链表是不是有环，有的话则返回环的第一个节点
	 * 这里用了快慢指针，当快慢指针相遇的时候，快指针从头开始于慢指针一起走，都是一次跳一位，当再次相遇时，即为环的第一个节点。
	 * 别问我为什么，结论。。。
	 * @param head
	 * @return
	 */
	public static Node getLoopNode(Node head) {
		if(head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node n1 = head.next;
		Node n2 = head.next.next;
		while(n1 != n2) {
			if(n2.next == null || n2.next.next == null) {
				return null;
			}
			n2 = n2.next.next;
			n1 = n1.next;
		}
		n2 = head;
		while(n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
	}
	//后来我自己写的
	public static Node hasLoop(Node head) {
		if (head == null || head.next == null) return null;
		Node slow = head.next;
		Node fast = head.next.next;
		while (fast != null && fast.next != null && fast.next.next != null) {
			if (fast == slow) {
				fast = head;
				while (slow != fast) {
					fast = fast.next;
					slow = slow.next;
				}
				return slow;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return null;
	}
	
	/**
	 * 对于两个没有环的链表找相交部分的第一个节点。
	 * 首先两个链表各自走一遍，记录下差值n，（这里注意一下，如果最后一个节点都不一样，则肯定没有相交部分，直接退出即可）
	 * 让长的那个链表走n的长度后两个链表同时走，找出第一个相同的节点。
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static Node noLoop(Node head1, Node head2) {
		if(head1 == null || head2 == null) {
			return null;
		}
		Node cur1 = head1;
		Node cur2 = head2;
		int n = 0;
		while(cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}
		while(cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		if(cur1 != cur2) {
			return null;
		}
		cur1 = n > 0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		n = Math.abs(n);
		while(n != 0) {
			n--;
			cur1  = cur1.next;
		}
		while(cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}
	
	/**
	 * 对于两个都有环的链表，有三种情况：不相交；共享一个环，且起始点相同；共享一个环，但起始点不同，此时两个链表各对应一个起始点
	 * 随便返回一个就好。
	 * 首先判断如果起始点相同，则和上面处理两个没有环的方法一样，只不过停止点从尾部换成了环的起始点，即至少相交部分是从环的起始点
	 * 开始，这样做只是为了找出在起始点之前是否还有相交部分。
	 * 如果起始点不同的话，则从loop1开始遍历一下这个环，依次跟loop2比对，如果有相等的节点，则是第三种情况，否则是第一种情况。
	 * @param head1
	 * @param loop1
	 * @param head2
	 * @param loop2
	 * @return
	 */
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node cur1 = null;
		Node cur2 = null;
		if(loop1 == loop2) {
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while(cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while(cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while(n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while(cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		}else {
			cur1 = loop1.next;
			while(cur1 != loop1) {
				if(cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}
	
	public static void main(String[] args) {
		//两条无环的链表
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);
		
		//两条有环
		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4
		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		System.out.println(getIntersectNode(head1, head2).value);
	}
	
}

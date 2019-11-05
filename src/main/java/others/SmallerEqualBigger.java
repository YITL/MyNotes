package others;

/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 * @author yitl
 *
 */
public class SmallerEqualBigger {

	public static class Node{
		public int value;
		public Node next;
		public Node(int data) {
			this.value = data;
		}
	}
	
	/**
	 * 用的数组的荷兰国旗问题的解决办法（不推荐）
	 * 空间复杂度为O（N），要准备一个数组
	 * @param head
	 * @param pivot
	 * @return
	 */
	public static Node LinkedListPartition1(Node head, int pivot) {
		if(head == null) {
			return head;
		}
		Node cur = head;
		int i = 0;
		while(cur != null) {
			i++;
			cur = cur.next;
		}
		Node[] nodeArr = new Node[i];
		i = 0;
		cur = head;
		for(i = 0; i != nodeArr.length; i++) {
			nodeArr[i] = cur;
			cur = cur.next;
		}
		arrPartition(nodeArr, pivot);
		for(i = 1; i != nodeArr.length; i++) {
			nodeArr[i - 1].next = nodeArr[i];
		}
		nodeArr[i - 1].next = null;
		return nodeArr[0];
	}
	
	public static void swap(Node[] nodeArr, int a, int b) {
		Node tmp = nodeArr[a];
		nodeArr[a] = nodeArr[b];
		nodeArr[b] = tmp;
	}
	
	public static void arrPartition(Node[] nodeArr, int pivot) {
		int small = -1;
		int big = nodeArr.length;
		int index = 0;
		while(index != big) {
			if(nodeArr[index].value < pivot) {
				swap(nodeArr, ++small, index++);
			}else if(nodeArr[index].value > pivot) {
				swap(nodeArr, index, --big);
			}else {
				index++;
			}
		}
	}
	
	/**
	 * 方法二，准备三段，六个节点，遍历链表，根据大于等于小于标准值，分别链接到三段节点上，最后串到一起
	 * 空间复杂度为O（1），只用了几个常量
	 * @param head
	 * @param pivot
	 * @return
	 */
	public static Node LinkedListPartition2(Node head, int pivot) {
		Node sH = null;
		Node sT = null;
		Node eH = null;
		Node eT = null;
		Node bH = null;
		Node bT = null;
		Node next = null;
		while(head != null) {
			next = head.next;
			head.next = null;
			if(head.value < pivot) {
				if(sH == null) {
					sH = head;
					sT = head;
				}else {
					sT.next = head;
					sT = head;
				}
			}else if(head.value == pivot) {
				if(eH == null) {
					eH = head;
					eT = head;
				}else {
					eT.next = head;
					eT = head;
				}
			}else {
				if(bH == null) {
					bH = head;
					bT = head;
				}else {
					bT.next = head;
					bT = head;
				}
			}
			head = next;
		}
		if(sT != null) {
			sT.next = eH;
			eT = eT == null ? sT : eT;
		}
		if(eT != null) {
			eT.next = bH;
		}
		return sH != null ? sH : eH != null ? eH : bH;
	}
	
	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while(node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node head1 = new Node(7);
		head1.next = new Node(9);
		head1.next.next = new Node(1);
		head1.next.next.next = new Node(8);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(2);
		head1.next.next.next.next.next.next = new Node(5);
		printLinkedList(head1);
		head1 = LinkedListPartition1(head1, 5);
		printLinkedList(head1);
	}
}

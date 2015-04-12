package com.minhaz.algorithm.ds;

public class LinkedList {

	Node head;

	public void add(int data) {
		head = add(head, data);
	}
	public Node add(Node head, int data) {
		if (head == null) {
			head = new Node(data);
		} else {
			head.next = add(head.next, data);
		}
		return head;
	}

	public void print() {
		print(head);
	}
	public void print(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public void reverse() {
		this.head = reverse(head);
	}
	private Node reverse(Node head) {

		if (head.next == null) {
			return head;
		} else {
			Node temp = reverse(head.next);
			// print(temp);

			temp.next = head.next;
			// head.next.next = head;
			// head = head.next;
			head.next = null;
			return temp;
		}
	}

	public void sort() {
		if (head == null) {
			return;
		}
		Node end = head;
		while (end.next != null) {
			end = end.next;
		}
		doMergeSort(head, end);
	}

	private void doMergeSort(Node head, Node end) {
		// TODO Auto-generated method stub
		if ((head == null) || (head.next == null)) {
			return;
		}
		if (head != end) {
			Node middle = getMiddle(head, end);
			doMergeSort(head, middle);
			doMergeSort(middle.next, end);
			head = merge(head, end);
		}
	}
	private Node getMiddle(Node head, Node end) {
		Node fast = head;
		Node slow = head;
		while ((fast.next != end) && (fast.next.next != null)) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	private Node merge(Node head, Node end) {

		if (head == end) {
			return head;
		}
		Node result = null;
		if (head.data < end.data) {
			result = head;
			result.next = merge(head.next, end);
		} else {
			result = end;
			result.next = merge(head, end.next);
		}
		return result;
	}

	public void reverse(int k) {
		head = reverse(head, k);
	}
	private Node reverse(Node head, int k) {
		Node current = head;
		Node next = null;
		Node prev = null;
		int count = 0;

		/* reverse first k nodes of the linked list */
		while ((current != null) && (count < k)) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		/*
		 * next is now a pointer to (k+1)th node Recursively call for the list
		 * starting from current. And make rest of the list as next of first
		 * node
		 */
		if (next != null) {
			head.next = reverse(next, k);
		}

		/* prev is new head of the input list */
		return prev;
	}
	public void moveOddNumbersEnd() {
		head = moveOddEnd(head);
	}

	private Node moveOddEnd(Node head) {
		Node headRef = head;
		Node odd = null;
		Node even = null;
		Node oddHead = null;
		Node evenHead = null;

		while (head != null) {

			if ((head.data % 2) == 0) {
				if (even == null) {
					even = head;
					evenHead = head;
				} else {
					even.next = head;
					even = even.next;
				}

			} else {
				if (odd == null) {
					odd = head;
					oddHead = odd;
				} else {
					odd.next = head;
					odd = odd.next;
				}

			}
			head = head.next;
		}
		odd.next = null;
		even.next = oddHead;

		return evenHead;
	}

	public void rotateCounterClockWise(int k) {
		head = rotateCounterClockWise(head, k);
	}
	private Node rotateCounterClockWise(Node head, int k) {
		if ((head == null) && (k <= 0)) {
			return head;
		}
		Node startPointer = head;
		Node rotatePointer = null;
		Node newEndPointer = null;
		int i = 1;
		while ((i < k) && (head != null)) {
			head = head.next;
			i++;
		}
		rotatePointer = head.next;
		newEndPointer = head;

		while (head.next != null) {
			head = head.next;
		}
		newEndPointer.next = null;
		head.next = startPointer;

		return rotatePointer;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.add(5);
		list.add(15);
		list.add(8);
		list.add(85);
		list.add(45);
		list.add(7);
		list.add(6);
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(9);
		list.print();
		System.out.println();
		list.rotateCounterClockWise(3);
		list.print();

	}

	class Node {
		Node next;
		int data;
		Node(int value) {
			this.data = value;
		}
	}

}

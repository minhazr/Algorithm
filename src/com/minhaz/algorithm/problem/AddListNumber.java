package com.minhaz.algorithm.problem;

/**
 * 
 * 
 * Problem Statements
 * 
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 */
public class AddListNumber {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if ((l1 == null) && (l2 != null)) {
			return l2;
		} else if ((l1 != null) && (l2 == null)) {
			return l1;
		} else if ((l1 == null) && (l2 == null)) {
			return null;
		}

		int sum = l1.val + l2.val;
		int carry = sum / 10;
		sum = sum % 10;
		ListNode start;
		ListNode temp = new ListNode(sum);
		start = temp;
		l1 = l1.next;
		l2 = l2.next;
		while ((l1 != null) && (l2 != null)) {
			sum = l1.val + l2.val + carry;
			carry = sum / 10;
			sum = sum % 10;

			temp.next = new ListNode(sum);
			temp = temp.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			sum = l1.val + carry;
			carry = sum / 10;
			sum = sum % 10;
			temp.next = new ListNode(sum);
			temp = temp.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			sum = l2.val + carry;
			carry = sum / 10;
			sum = sum % 10;
			temp.next = new ListNode(sum);
			temp = temp.next;
			l2 = l2.next;
		}
		if (carry > 0) {
			temp.next = new ListNode(carry);
		}
		return start;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode first = new ListNode(2);
		first.next = new ListNode(4);
		first.next.next = new ListNode(3);

		ListNode seccond = new ListNode(5);
		seccond.next = new ListNode(6);
		seccond.next.next = new ListNode(4);

		AddListNumber list = new AddListNumber();
		ListNode result = list.addTwoNumbers(first, seccond);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}

	}

	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}

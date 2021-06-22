/**
 * @class Stack
 * @author chahat
 * @description Stack class contains all the mentioned functionalities.
 *
 */
package com.nagarro.training.assignment4.stack;

import java.util.*;

import com.nagarro.training.assignment4.linkedList.*;

/* Class linkedStack */
class Stack {
	protected static Node top;
	protected int size;

	/* Constructor */
	public Stack() {
		top = null;
		size = 0;
	}

	/* Function to check if stack is empty */
	public boolean isEmpty() {
		return top == null;
	}

	/* Function to get the size of the stack */
	public int getSize() {
		return size;
	}

	/* Function to push an element to the stack */
	public void push(int data) {
		Node nptr = new Node(data, null);
		if (top == null)
			top = nptr;
		else {
			nptr.setLink(top);
			top = nptr;
		}
		size++;
	}

	/* Function to pop an element from the stack */
	public int pop() {
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		Node ptr = top;
		top = ptr.getLink();
		size--;
		return ptr.getData();
	}

	/* Function to implement Contains Operation */
	public boolean search(Node top, int x) {
		Node current = top; // Initialize current
		while (current != null) {
			if (current.getData() == x)
				return true; // data found
			current = current.link;
		}
		return false; // data not found
	}

	/* Function to check the top element of the stack */
	public int peek() {
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		return top.getData();
	}

	/* Function to display the status of the stack */
	public void display() {
		System.out.print("Stack : ");
		if (size == 0) {
			System.out.print("Empty\n");
			return;
		}
		Node ptr = top;
		while (ptr != null) {
			System.out.print(ptr.getData() + " ");
			ptr = ptr.getLink();
		}
		System.out.println("\n");
	}

	/* Function to Reverse the stack */
	public void reverse() {
		Node prev, cur, succ;
		cur = prev = this.top;
		cur = cur.link;
		prev.link = null;
		while (cur != null) {

			succ = cur.link;
			cur.link = prev;
			prev = cur;
			cur = succ;
		}
		this.top = prev;
	}

	/* Function to iterate the stack */
	public void iterateStack() {
		System.out.print("Elements of List are:");
		iterateStack Iterator = new iterateStack();
		try {

			if (Iterator.hasNext() == false) {
				throw new NoSuchElementException("List is Empty");

			}

			while (Iterator.hasNext()) {
				System.out.print(Iterator.next() + " ");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public class iterateStack implements Iterator<Integer> {
		private Node current;

		public iterateStack() {
			current = Stack.top;
		}

		public boolean hasNext() {
			return current != null;
		}

		public Integer next() {
			int data = current.data;
			current = current.getLink();
			return data;
		}
	}
}
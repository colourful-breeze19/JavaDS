/**
 * @class  Queue 
 * @author chahat
 * @description  Queue  class contains all the mentioned functionalities.
 *
 */
package com.nagarro.training.assignment4.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.nagarro.training.assignment4.linkedList.*;

/*  Class linkedQueue  */
class Queue {
	protected static Node front;
	protected Node rear;
	public int size;

	/* Constructor */
	public Queue() {
		front = null;
		rear = null;
		size = 0;
	}

	/* Function to check if queue is empty */
	public boolean isEmpty() {
		return front == null;
	}

	/* Function to get the size of the queue */
	public int getSize() {
		return size;
	}

	/* Function to insert an element to the queue */
	public void insert(int data) {
		Node nptr = new Node(data, null);
		if (rear == null) {
			front = nptr;
			rear = nptr;
		} else {
			rear.setLink(nptr);
			rear = rear.getLink();
		}
		size++;
	}

	/* Function to remove front element from the queue */
	public int remove() {
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		Node ptr = front;
		front = ptr.getLink();
		if (front == null)
			rear = null;
		size--;
		return ptr.getData();
	}

	/* Function to check the front element of the queue */
	public int peek() {
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		return front.getData();
	}

	/* Function to Reverse the Queue */
	public void reverse() {
		Node curr = front;
		Node prev = null;
		Node forw;

		// traversing linked list until there is no more element
		while (curr.link != null) {

			// Saving reference of next node, since we are changing current node
			forw = curr.link;

			// Inserting node at start of new list
			curr.link = prev;
			prev = curr;

			// Advancing to next node
			curr = forw;

		}
		front = curr;
		front.link = prev;
	}
	
	/* Function to implement Contains Operation */
	public boolean search(Node front, int x) {
		Node current = front; // Initialize current
		while (current != null) {
			if (current.getData() == x)
				return true; // data found
			current = current.link;
		}
		return false; // data not found
	}

	/* Function to display the status of the queue */
	public void display() {
		System.out.print("\nQueue : ");
		if (size == 0) {
			System.out.print("Empty\n");
			return;
		}
		Node ptr = front;
		System.out.print(front.getData() + " ");
		ptr = front.getLink();
		while (ptr.getLink() != null) {
			System.out.print(ptr.getData() + " ");
			ptr = ptr.getLink();
		}
		System.out.print(ptr.getData());
	}
	
	/* Function to iterate the queue */
	public void iterateQueue() {
		System.out.print("Elements of List are:");
		iterateQueue Iter = new iterateQueue();
		try {

			if (Iter.hasNext() == false) {
				throw new NoSuchElementException("List is Empty");

			}

			while (Iter.hasNext()) {
				System.out.print(Iter.next() + " ");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public class iterateQueue implements Iterator<Integer> {
		private Node current;

		public iterateQueue() {
			current = Queue.front;
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
/**
 * @class LinkedList
 * @author chahat
 * @description LinkedList class contains all the mentioned functionalities.
 *
 */
package com.nagarro.training.assignment4.linkedList;

import java.util.*;

/* Class linkedList */
class LinkedList {
	public static Node start;
	public Node end;
	public int size;

	/* Constructor */
	public LinkedList() {
		start = null;
		end = null;
		size = 0;

	}

	/* Function to check if list is empty */
	public boolean isEmpty() {
		return start == null;
	}

	/* Function to get size of list */
	public int getSize() {
		return size;
	}

	/* Function to insert an element at beginning */
	public void insertAtStart(int val) {
		Node nptr = new Node(val, null);
		size++;
		if (start == null) {
			start = nptr;
			end = start;
		} else {
			nptr.setLink(start);
			start = nptr;
		}
	}

	/* Function to insert an element at end */
	public void insertAtEnd(int val) {
		Node nptr = new Node(val, null);
		size++;
		if (start == null) {
			start = nptr;
			end = start;
		} else {
			end.setLink(nptr);
			end = nptr;
		}
	}

	/* Function to insert an element at position */
	public void insertAtPos(int val, int pos) {
		Node nptr = new Node(val, null);
		Node ptr = start;
		pos = pos - 1;
		for (int i = 1; i < size; i++) {
			if (i == pos) {
				Node tmp = ptr.getLink();
				ptr.setLink(nptr);
				nptr.setLink(tmp);
				break;
			}
			ptr = ptr.getLink();
		}
		size++;
	}

	/* Function to delete an element at front */
	public void deleteFromStart() {

		// Checks if the list is empty
		
		if (start == null) {
			throw new NoSuchElementException("List is Empty");
		}		
		
		else {
			// Checks whether the list contains only one node
			// If not, the head will point to next node in the list and tail will point to
			// the new head.
			if (start != end) {
				start = start.link;
			}
			// If the list contains only one node
			// then, it will remove it and both head and tail will point to null
			else {
				start = end = null;
			}
		}
	}

	/* Function to delete an element at end */
	public void deleteFromEnd() {

		// Checks if the list is empty
		if (start == null) {
			System.out.println("List is empty");
			return;
		} else {
			// Checks whether the list contains only one element
			if (start != end) {
				Node current = start;
				// Loop through the list till the second last element such that current.next is
				// pointing to tail
				while (current.link != end) {
					current = current.link;
				}
				// Second last element will become new tail of the list
				end = current;
				end.link = null;
			}
			// If the list contains only one element
			// Then it will remove it and both head and tail will point to null
			else {
				start = end = null;
			}
		}
	}

	/* Function to delete an element at position */
	public void deleteAtPos(int pos) {
		if (pos == 1) {
			start = start.getLink();
			size--;
			return;
		}
		if (pos == size) {
			Node s = start;
			Node t = start;
			while (s != end) {
				t = s;
				s = s.getLink();
			}
			end = t;
			end.setLink(null);
			size--;
			return;
		}
		Node ptr = start;
		pos = pos - 1;
		for (int i = 1; i < size - 1; i++) {
			if (i == pos) {
				Node tmp = ptr.getLink();
				tmp = tmp.getLink();
				ptr.setLink(tmp);
				break;
			}
			ptr = ptr.getLink();
		}
		size--;
	}

	/* Function to find mid element */
	void printMiddle() {
		Node slow_ptr = start;
		Node fast_ptr = start;
		if (start != null) {
			while (fast_ptr != null && fast_ptr.link != null) {
				fast_ptr = fast_ptr.link.link;
				slow_ptr = slow_ptr.link;
			}
			System.out.println("The middle element is [" + slow_ptr.data + "] \n");
		}
	}

	/* Function to display elements */
	public void display() {

		if (size == 0) {
			System.out.print("Linked List is Empty\n");
			return;
		}
		if (start.getLink() == null) {
			System.out.println(start.getData());
			return;
		}
		Node ptr = start;
		System.out.print(start.getData() + " -> ");
		ptr = start.getLink();
		while (ptr.getLink() != null) {
			System.out.print(ptr.getData() + " -> ");
			ptr = ptr.getLink();
		}
		System.out.print(ptr.getData());
	}

	/* Function to Reverse the Linked List */
	public void reverse() {
		Node current = start;
		Node previous = null;
		Node forward = null;

		// traversing linked list until there is no more element
		while (current.link != null) {

			// Saving reference of next node, since we are changing current node
			forward = current.link;

			// Inserting node at start of new list
			current.link = previous;
			previous = current;

			// Advancing to next node
			current = forward;
		}
		start = current;
		start.link = previous;
	}

	/* Function to iterate the Linked List */
	public void iterateList() {
		System.out.print("Elements of List are:");
		ListIterator listIterator = new ListIterator();
		try {

			if (listIterator.hasNext() == false) {
				throw new NoSuchElementException("List is Empty");

			}

			while (listIterator.hasNext()) {
				System.out.print(listIterator.next() + " ");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public class ListIterator implements Iterator<Integer> {
		private Node current;

		public ListIterator() {
			current = LinkedList.start;
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

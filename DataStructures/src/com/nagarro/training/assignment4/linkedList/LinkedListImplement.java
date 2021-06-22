/**
 * @class LinkedListImplement
 * @author chahat
 * @description LinkedListImplement class implies all the mentioned functionalities.
 *
 */
package com.nagarro.training.assignment4.linkedList;
//import com.nagarro.training.assignment4.main.*;

import java.util.*;

import com.nagarro.training.assignment4.Main;
import com.nagarro.training.assignment4.constants.Constant;

public class LinkedListImplement {
	public void SinglyLinkedListMenu() {

		Scanner scan = new Scanner(System.in);
		/* Creating object of class linkedList */
		LinkedList list = new LinkedList();
		int choice=0;
		System.out.println("Linked List \n");
		
		/* Perform list operations */
		while(choice!=13) {
			System.out.println("\nLinked List Operations\n");
			System.out.println("1. Insert at begining");
			System.out.println("2. Insert at end");
			System.out.println("3. Insert at position");
			System.out.println("4. Delete from beginning");
			System.out.println("5. Delete at end");
			System.out.println("6. Delete at position");
			System.out.println("7. Check empty");
			System.out.println("8. Size");
			System.out.println("9. Center");
			System.out.println("10. Iterator");
			System.out.println("11. Display");
			System.out.println("12. Reverse");
			System.out.println("13. Back to Main Menu ");

			choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println(Constant.ENTER);
				list.insertAtStart(scan.nextInt());
				break;

			case 2:
				System.out.println(Constant.ENTER);
				list.insertAtEnd(scan.nextInt());
				break;

			case 3:
				System.out.println(Constant.ENTER);
				int num = scan.nextInt();
				System.out.println("Enter position");
				int pos = scan.nextInt();
				if (pos <= 1 || pos > list.getSize())
					System.out.println("Invalid position\n");
				else
					list.insertAtPos(num, pos);
				break;

			case 4:
				list.deleteFromStart();
				break;

			case 5:
				list.deleteFromEnd();
				break;

			case 6:
				System.out.println("Enter position");
				int p = scan.nextInt();
				if (p < 1 || p > list.getSize())
					System.out.println("Invalid position\n");
				else
					list.deleteAtPos(p);
				break;

			case 7:
				System.out.println("Empty status : " + list.isEmpty());
				break;

			case 8:
				System.out.println("Size : " + list.getSize() + " \n");
				break;

			case 9:
				list.printMiddle();
				break;

			case 10:
				list.iterateList();

				break;

			case 11:
				System.out.println("Linked List : ");
				list.display();
				break;

			case 12:
				System.out.println("Reversed Linked List : ");
				list.reverse();
				list.display();
				list.reverse();
				break;
			case 13:
				System.out.println(Constant.MAIN_MENU);
				Main m = new Main();
				m.main(null);
				break;

			default:
				System.out.println(Constant.WRONG_ENTRY);
				break;
			}		
		} 

	}
}

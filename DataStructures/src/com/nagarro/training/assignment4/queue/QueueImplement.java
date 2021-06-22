/**
 * @class  QueueImplement
 * @author chahat
 * @description QueueImplement class implies all the mentioned functionalities.
 *
 */
package com.nagarro.training.assignment4.queue;

import java.util.Scanner;

import com.nagarro.training.assignment4.Main;
import com.nagarro.training.assignment4.constants.Constant;

public class QueueImplement {
	public static void QueueImplementMenu() {
		Scanner scan = new Scanner(System.in);
		/* Creating object of class linkedQueue */
		Queue lq = new Queue();
		/* Perform Queue Operations */
		System.out.println("Linked Queue\n");
		int choice=0;
		while(choice!=9) {
			System.out.println("\nQueue Operations");
			System.out.println(Constant.ENQUEUE);
			System.out.println(Constant.DEQUEUE);
			System.out.println(Constant.PEEK);
			System.out.println(Constant.CONTAINS);
			System.out.println(Constant.SIZE);
			System.out.println(Constant.REVERSE);
			System.out.println("7. Iterator");
			System.out.println("8. Traverse / Print");
			System.out.println("9. Back to Main Menu ");
		    choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println(Constant.ENTER);
				lq.insert(scan.nextInt());
				break;
			case 2:
				try {
					System.out.println("Removed Element : " + lq.remove());
				} catch (Exception e) {
					System.out.println("Error : " + e.getMessage());
				}
				break;
			case 3:
				try {
					System.out.println("Topmost Element : " + lq.peek());
				} catch (Exception e) {
					System.out.println("Error : " + e.getMessage());
				}
				break;
			case 4:
				// Contains Operation
				System.out.print("Contains Operation\n\n");
				System.out.print("Enter element to check : ");
				int c = scan.nextInt();
				if (lq.search(lq.front, c)) {
					System.out.println("Yes, this element is present in the Queue");
				} else {
					System.out.println("No, this element is not present in the Queue");
				}

				break;

			case 5:
				System.out.println("Size : " + lq.getSize());
				break;

			case 6:
				// Reverse Operation
				System.out.print("Reversed Queue : ");
				lq.reverse();	
				lq.display();
				lq.reverse();

				break;

			case 7:
				// Iterator Operation
				lq.iterateQueue();
				break;

			case 8:
				lq.display();
				break;
			case 9:
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
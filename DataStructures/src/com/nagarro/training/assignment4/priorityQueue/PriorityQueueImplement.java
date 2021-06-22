/**
 * @class PriorityQueueImplement
 * @author chahat
 * @description PriorityQueueImplement class implies all the mentioned functionalities.
 *
 */
package com.nagarro.training.assignment4.priorityQueue;

import java.util.Scanner;

import com.nagarro.training.assignment4.Main;
import com.nagarro.training.assignment4.constants.Constant;

public class PriorityQueueImplement {
	public void PriorityQueueTestMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Priority Queue\n");
		PriorityQueue pq = new PriorityQueue();
		int choice=0;
		/* Perform Priority Queue operations */
		while(choice!=8) {
			System.out.println("\nPriority Queue Operations\n");
			System.out.println(Constant.ENQUEUE);
			System.out.println(Constant.DEQUEUE);
			System.out.println(Constant.PEEK);
			System.out.println(Constant.CONTAINS);
			System.out.println(Constant.SIZE);
			System.out.println(Constant.REVERSE);
			System.out.println(Constant.PRINT);
			System.out.println("8. Back to Main Menu ");

			choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Job : ");
				pq.enqueue(scan.nextInt());
				break;
				
			case 2:
				System.out.println("\nJob removed \n");
				pq.dequeue();
				break;
				
			case 3:
				System.out.print("\nPeek : " + pq.peek());
				break;
				
			case 4:
				System.out.print("Contains Operation\n\n");
				System.out.print("Enter element to check : ");
				int c = scan.nextInt();
				if (pq.contains(c)) {
					System.out.println("Yes, this Job is present in the Priority Queue");
				} else {
					System.out.println("No, this Job is not present in the Priority Queue");
				}
				break;

			case 5:
				System.out.print("\nSize : " + pq.size());
				break;
			case 6:
				System.out.print("Reversed Priority Queue : ");
				pq.reverse();
				pq.traverse();
				pq.reverse();
				break;
		
			case 7:
				System.out.print("Priority Queue : ");
				pq.traverse();
				break;
			case 8:
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
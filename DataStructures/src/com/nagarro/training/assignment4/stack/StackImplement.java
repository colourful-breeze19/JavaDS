/**
 * @class  StackImplement
 * @author chahat
 * @description StackImplement class implies all the mentioned functionalities.
 *
 */
package com.nagarro.training.assignment4.stack;

import java.util.Scanner;

import com.nagarro.training.assignment4.Main;
import com.nagarro.training.assignment4.constants.Constant;

public class StackImplement {
	private static String PUSH_STACK = "1. Push";
	public void StackImplementMenu() {
		Scanner scan = new Scanner(System.in);
		/* Creating object of class linkedStack */
		Stack ls = new Stack();
		int choice=0;
		/* Perform Stack Operations */
		System.out.println("Linked Stack\n");
		while(choice!=8) {
			System.out.println("\nStack Operations");
			System.out.println(PUSH_STACK);
			System.out.println("2. Pop");
			System.out.println("3. Peek");
			System.out.println("4. Contains");
			System.out.println("5. Size");
			System.out.println("6. Reverse");
			System.out.println("7. Iterator");
			System.out.println("8. Traverse / Print");
			System.out.println("9. Back to Main Menu ");

			choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter integer element to push : ");
				ls.push(scan.nextInt());
				break;
			case 2:
				try {
					System.out.println("Popped Element : " + ls.pop());
				} catch (Exception e) {
					System.out.println("Error : " + e.getMessage());
				}
				break;

			case 3:
				try {
					System.out.println("Topmost Element : " + ls.peek());
				} catch (Exception e) {
					System.out.println("Error : " + e.getMessage());
				}
				break;

			case 4:
				// Contains
				System.out.print("Contains Operation\n\n");
				System.out.print("Enter element to check : ");
				int c = scan.nextInt();
				if (ls.search(ls.top, c)) {
					System.out.println("Yes, this element is present in the Stack");
				} else {
					System.out.println("No, this element is not present in the Stack");
				}

				break;

			case 5:
				System.out.println("Size : " + ls.getSize());
				break;

			case 6:
				ls.reverse();
				System.out.print("Reversed Stack ");
				ls.display();
				ls.reverse();
				break;

			case 7:
				// Iterator
				ls.iterateStack();
				break;

			case 8:
				ls.display();
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
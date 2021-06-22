/**
 * @class HashImplement 
 * @author chahat
 * @description HashImplement  class implies all the mentioned functionalities.
 *
 */
package com.nagarro.training.assignment4.hashTable;

import java.util.*;

import com.nagarro.training.assignment4.Main;
import com.nagarro.training.assignment4.constants.Constant;

public class HashImplement {

	public static void HashMenu() {
		Scanner scan = new Scanner(System.in);
		// Display messages
		System.out.println("HashImplement Table\n\n");
		System.out.println("Enter size");

		// maxSizeake object of LinearProbingHashTable
		LinearProbingHashTable lpht = new LinearProbingHashTable(scan.nextInt());
		int choice=0;
			// Menu
			// Display messages
		while(choice!=7) {
			System.out.println("\nHash Table Operations\n");
			System.out.println("1. Insert ");
			System.out.println("2. Delete");
			System.out.println("3. Contains");
			System.out.println("4. Get value by key");
			System.out.println("5. Size");
			System.out.println("6. Traverse / Print");
			System.out.println("7. Back to Main Menu ");

			// Reading integer using nextInt()
			 choice = scan.nextInt();

			// Switch case
			switch (choice) {

			// Case 1
			case 1:
				// Display message
				System.out.println("Enter Key and Value : ");
				lpht.insert(scan.next(), scan.next());
				// Break statement to terminate a case
				break;

			// Case 2
			case 2:
				// Display message
				System.out.println("Enter key : ");
				lpht.remove(scan.next());
				// Break statement to terminate a case
				break;

			// Case 3
			case 3:
				System.out.print("Contains Operation\n\n");
				System.out.print("Enter element to check : ");
				String c = scan.next();
				if (lpht.search(c)) {
					System.out.print("Yes, this element is present in the HashImplement Table");
				} else {
					System.out.print("No, this element is not present in the HashImplement Table");
				}
				break;

			// Case 4
			case 4:
				// Print statements
				System.out.println("Enter Key : ");
				System.out.println("Value : " + lpht.get(scan.next()));
				// Break statement to terminate a case
				break;

			// Case 5
			case 5:
				// Print statement
				System.out.println("Size : " + lpht.getSize());
				break;

			case 6:
				lpht.printHashTable();
				System.out.println(" \n ");
				break;
			case 7:
				System.out.println(Constant.MAIN_MENU);
				Main m = new Main();
				m.main(null);
				break;

			default:
				// Print statement
				System.out.println(Constant.WRONG_ENTRY);
				// Break statement
				break;
			}

			
		}
	}

}
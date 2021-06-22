/**
 * @class TreeImplement
 * @author chahat
 * @description TreeImplement class implies all the mentioned functionalities.
 *
 */
package com.nagarro.training.assignment4.tree;

import java.util.*;

import com.nagarro.training.assignment4.Main;
import com.nagarro.training.assignment4.constants.Constant;

public class TreeImplement {

	public static void TreeImplementMenu() {

		Scanner scan = new Scanner(System.in);
		/* Creating object of BST */
		Tree bst = new Tree();
		System.out.println("Binary Search Tree Test\n");
		int choice=0;
		/* Perform tree operations */
		while(choice!=8) {
			System.out.println("\nBinary Search Tree Operations\n");
			System.out.println("1. Insert ");
			System.out.println("2. Delete");
			System.out.println("3. Contains");
			System.out.println("4. Get elements by Value");
			System.out.println("5. Get elements by Level");
			System.out.println("6. Traverse / Print Breadth First");
			System.out.println("7. Traverse / Print Depth First");
			System.out.println("8. Back to Main Menu ");

		   choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println(Constant.ENTER);
				bst.insert(scan.nextInt());
				break;

			case 2:
				System.out.println("Enter integer element to delete : ");
				bst.delete(scan.nextInt());
				break;

			case 3:
				System.out.println("Enter integer element to search : ");
				System.out.println("Search result : " + bst.search(scan.nextInt()));
				break;

			case 4:
				// Get elements by value
				System.out.println("Enter element : ");
				bst.searchIterative(scan.nextInt());
				break;

			case 5:
				System.out.println("Enter level : ");
				bst.printNodes(scan.nextInt());			
				break;

			case 6:
				// Traverse / Print Breadth First
				System.out.print("\nIn Breadth First Search we have : ");
				System.out.print("\nLevel Order : ");
				bst.printLevelOrder();
				break;

			case 7:
				// Traverse / Print Depth First
				System.out.print("\nIn Depth First Search we have 3 Methods : ");
				System.out.print("\nPost Order : ");
				bst.postorder();
				System.out.print("\nPre Order : ");
				bst.preorder();
				System.out.print("\nIn Order : ");
				bst.inorder();
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
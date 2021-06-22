/**
 * @class Main
 * @author chahat
 * @description takes the input.
 */
package com.nagarro.training.assignment4;

import java.util.Scanner;

import com.nagarro.training.assignment4.constants.Constant;
import com.nagarro.training.assignment4.hashTable.HashImplement;
import com.nagarro.training.assignment4.linkedList.*;
import com.nagarro.training.assignment4.priorityQueue.*;
import com.nagarro.training.assignment4.queue.*;
import com.nagarro.training.assignment4.stack.*;
import com.nagarro.training.assignment4.tree.TreeImplement;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int response = 0;
            while (response != 7) {
                System.out.println("\n*************************Main Menu*****************************\n");
                System.out.println("\n===============================================================\n");
                System.out.println(
                    "\n1.Linked List\n2.Stack\n3.Queue\n4.Priority Queue\n5.N child Tree\n6.Hash Table\n7.Exit\n");
                System.out.println("\nEnter your choice ?");
                response = sc.nextInt();
                switch (response) {
                    case 1:
                        LinkedListImplement ll = new LinkedListImplement();
                        ll.SinglyLinkedListMenu();
                        break;
                    case 2:
                        StackImplement s = new StackImplement();
                        s.StackImplementMenu();
                        break;
                    case 3:
                        QueueImplement.QueueImplementMenu();
                        break;
                    case 4:
                        PriorityQueueImplement pt = new PriorityQueueImplement();
                        pt.PriorityQueueTestMenu();
                        break;
                    case 5:
                        TreeImplement.TreeImplementMenu();
                        break;
                    case 6:
                        HashImplement.HashMenu();
                        break;
                    case 7:
                        {
                            System.out.println("Exiting....");
                            System.exit(0);
                            break;
                        }
                    default:
                        System.out.println(Constant.WRONG_ENTRY);

                }
            }
        }
    }

}
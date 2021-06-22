/**
 * @class PriorityQueue
 * @author chahat
 * @description PriorityQueue class contains all the mentioned functionalities.
 *
 */
package com.nagarro.training.assignment4.priorityQueue;
import java.util.*;

public class PriorityQueue {
    ArrayList<Integer> priorityqueue=new ArrayList<>();
    treenode head;
    public class treenode{
        int data;
        treenode left;
        treenode right;
        treenode(int input_data){
            this.data=input_data;
        }
    }
    public treenode maketree(ArrayList<Integer> arr, int index){
        if(index>arr.size()-1)
            return null;
        treenode temp_node=new treenode(arr.get(index));
        temp_node.left=maketree(arr, 2*index+1);
        temp_node.right=maketree(arr, 2*index+2);
        return temp_node;
    }
    void printInorder(treenode node)// no need of this method
    {
        if (node == null)
            return;
 
        /* first recur on left child */
        printInorder(node.left);
 
        /* then print the data of node */
        System.out.print(node.data + " ");
 
        /* now recur on right child */
        printInorder(node.right);
    }
    public void enqueue(int input_data){
        priorityqueue.add(input_data);
        heapify(priorityqueue);
        //head=maketree(priorityqueue, 0);

    }
    public void dequeue(){
    	try {
    		if(size()==0) {
    			throw new NoSuchElementException("Priority queue is Empty");
    	}
        priorityqueue.remove(0);
        heapify(priorityqueue);
        //head=maketree(priorityqueue, 0);
    	}catch (Exception e) {
			System.out.println(e.getMessage());
		} 
    }
    public int peek(){
        return priorityqueue.get(0); 
    }
    public boolean contains(int input_data){
        for(int iterator=0;iterator<priorityqueue.size();iterator++)
        {
            if(priorityqueue.get(iterator)==input_data)
                return true;
        }
        return false;
    }
    public int size(){
        return priorityqueue.size();
    }
    public void traverse(){
        for(int iterator=0;iterator<priorityqueue.size();iterator++)
        {
            System.out.print(priorityqueue.get(iterator)+" ");
        }
        System.out.println("");
    }
    public void reverse(){
        int starting_index=0;
        int ending_index=priorityqueue.size()-1;
        while(starting_index<ending_index)
        {
            int temp_value_holder=priorityqueue.get(starting_index);
            priorityqueue.set(starting_index, priorityqueue.get(ending_index));
            priorityqueue.set(ending_index, temp_value_holder);
            starting_index++;
            ending_index--;
        }
        
    }
    public void heapify(ArrayList<Integer> input_array){
        int index=(input_array.size()/2)-1;
        while(index>=0)
        {
            if(2*index+2<input_array.size())
            {
                int tmp_index=input_array.get(2*index+1)<input_array.get(2*index+2)?(2*index+2):(2*index+1);
                if(input_array.get(index)<input_array.get(tmp_index))
                {
                    int tmp_value=input_array.get(index);
                    input_array.set(index,input_array.get(tmp_index));
                    input_array.set(tmp_index,tmp_value);
                }
            }
            else
            {
                if(input_array.get(index)<input_array.get(2*index+1))
                {
                    int tmp_value=input_array.get(index);
                    input_array.set(index,input_array.get(2*index+1));
                    input_array.set(2*index+1,tmp_value);
                }
            }
            index--;
        }

    }
    
}
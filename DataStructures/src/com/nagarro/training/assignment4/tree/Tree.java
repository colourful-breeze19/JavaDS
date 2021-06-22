/**
 * @class Tree 
 * @author chahat
 * @description Tree  class contains all the mentioned functionalities.
 *
 */
package com.nagarro.training.assignment4.tree;
import java.util.*;

/* Class BST */
class Tree {
	private TreeNode root;
	public TreeNode parent;

	/* Constructor */
	public Tree() {
		root = null;
	}

	/* Function to check if tree is empty */
	public boolean isEmpty() {
		return root == null;
	}

	/* Functions to insert data */
	public void insert(int data) {
		root = insert(root, data);
	}

	/* Function to insert data recursively */
	private TreeNode insert(TreeNode node, int data) {
		if (node == null)
			node = new TreeNode(data);
		else {
			if (data <= node.getData())
				node.left = insert(node.left, data);
			else
				node.right = insert(node.right, data);
		}
		return node;
	}

	/* Functions to delete data */
	public void delete(int k) {
		if (isEmpty())
			System.out.println("Tree Empty");
		else if (search(k) == false)
			System.out.println("Sorry " + k + " is not present");
		else {
			root = delete(root, k);
			System.out.println(k + " deleted from the tree");
		}
	}

	private TreeNode delete(TreeNode root, int k) {
		TreeNode p, p2, n;
		if (root.getData() == k) {
			TreeNode lt, rt;
			lt = root.getLeft();
			rt = root.getRight();
			if (lt == null && rt == null)
				return null;
			else if (lt == null) {
				p = rt;
				return p;
			} else if (rt == null) {
				p = lt;
				return p;
			} else {
				p2 = rt;
				p = rt;
				while (p.getLeft() != null)
					p = p.getLeft();
				p.setLeft(lt);
				return p2;
			}
		}
		if (k < root.getData()) {
			n = delete(root.getLeft(), k);
			root.setLeft(n);
		} else {
			n = delete(root.getRight(), k);
			root.setRight(n);
		}
		return root;
	}

	/* Functions to count number of nodes */
	public int countNodes() {
		return countNodes(root);
	}

	/* Function to count number of nodes recursively */
	private int countNodes(TreeNode r) {
		if (r == null)
			return 0;
		else {
			int l = 1;
			l += countNodes(r.getLeft());
			l += countNodes(r.getRight());
			return l;
		}
	}

	/* Functions to search for an element */
	public boolean search(int val) {
		return search(root, val);
	}

	/* Function to search for an element recursively */
	private boolean search(TreeNode r, int val) {
		boolean found = false;
		while ((r != null) && !found) {
			int rval = r.getData();
			if (val < rval)
				r = r.getLeft();
			else if (val > rval)
				r = r.getRight();
			else {
				found = true;
				break;
			}
			found = search(r, val);
		}
		return found;
	}

	/* Function for inorder traversal */
	public void inorder() {
		inorder(root);
	}

	private void inorder(TreeNode r) {
		if (r != null) {
			inorder(r.getLeft());
			System.out.print(r.getData() + " ");
			inorder(r.getRight());
		}
	}

	/* Function for preorder traversal */
	public void preorder() {
		preorder(root);
	}

	private void preorder(TreeNode r) {
		if (r != null) {
			System.out.print(r.getData() + " ");
			preorder(r.getLeft());
			preorder(r.getRight());
		}
	}

	/* Function for postorder traversal */
	public void postorder() {
		postorder(root);
	}

	private void postorder(TreeNode r) {
		if (r != null) {
			postorder(r.getLeft());
			postorder(r.getRight());
			System.out.print(r.getData() + " ");
		}
	}
	

	/* Function for height of BST */
	int height(TreeNode r) {
		if (r == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(r.left);
			int rheight = height(r.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}


	public void printGivenLevel(TreeNode r, int level) {
		if (r == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printGivenLevel(r.left, level - 1);
			printGivenLevel(r.right, level - 1);
		}
	}
	/* Function for level order traversal */
	public void printLevelOrder() {
		printLevelOrder(root);
	}

	static void printLevelOrder(TreeNode r) {
	      Queue<TreeNode> queue = new LinkedList<TreeNode>();
	      queue.add(r);
	      while (!queue.isEmpty()) {
	          TreeNode temp = queue.poll();
	          System.out.print(temp.data + " ");
	 
	          /*add left child to the queue */
	          if (temp.left != null) {
	              queue.add(temp.left);
	          }
	 
	          /*add right right child to the queue */
	          if (temp.right != null) {
	              queue.add(temp.right);
	          }
	      }
	  }
	public void searchIterative(int val) {
			searchIterative(root,val);
		}
	// Iterative function to search in a given BST
    public static void searchIterative(TreeNode root, int key)
    {
        // start with the root node
        TreeNode curr = root;
 
        // pointer to store the parent of the current node
        TreeNode parent = null;
 
        // traverse the tree and search for the key
        while (curr != null && curr.data != key)
        {
            // update the parent to the current node
            parent = curr;
 
            // if the given key is less than the current node, go to the left subtree;
            // otherwise, go to the right subtree
            if (key < curr.data) {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }
 
        // if the key is not present in the key
        if (curr == null)
        {
            System.out.print("Key Not found");
            return;
        }
 
        if (parent == null) {
            System.out.print("The node with key " + key + " is root node");
        }
        else if (key < parent.data)
        {
            System.out.print("The given key is the left node of the node with key "
                            + parent.data);
        }
        else {
            System.out.print("The given key is the right node of the node with key "
                            + parent.data);
        }
    }
    /* Print elements in given level*/
    public void printNodes(int val) {
    	printNodes(root,val);
	}
    public static void printNodes(TreeNode root, int start)
    {
        if (root == null) {
            return;
        }
        System.out.println( "Elements on this level :");
        // create an empty queue and enqueue the root node
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
 
        // to store the current node
        TreeNode curr = null;
 
        // maintains the level of the current node
        int level = 0;
 
        // loop till queue is empty
        while (!queue.isEmpty())
        {
            // increment level by 1
            level++;
 
            // calculate the total number of nodes at the current level
            int size = queue.size();
 
            // process every node of the current level and enqueue their
            // non-empty left and right child
            while (size-- > 0)
            {
                curr = queue.poll();
               
                // print the node if its level is between given levels
                if (level >= start && level <= start) {
                    System.out.print( curr.data + " ");
                }
 
                if (curr.left != null) {
                    queue.add(curr.left);
                }
 
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
 
            if (level >= start && level <= start) {
                System.out.println();
            }
        }
    }
 
    
}
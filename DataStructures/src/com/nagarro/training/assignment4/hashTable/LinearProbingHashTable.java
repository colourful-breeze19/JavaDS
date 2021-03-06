/**
 * @class LinearProbingHashTable
 * @author chahat
 * @description LinearProbingHashTable class contains all the mentioned functionalities.
 *
 */
package com.nagarro.training.assignment4.hashTable;

class LinearProbingHashTable {
	// Member variables of this class
	private int currentSize, maxSize;
	private String[] keys;
	private String[] vals;

	// Constructor of this class
	public LinearProbingHashTable(int capacity) {
		currentSize = 0;
		maxSize = capacity;
		keys = new String[maxSize];
		vals = new String[maxSize];
	}

	// Method 1
	// Function to clear hash table
	public void makeEmpty() {
		currentSize = 0;
		keys = new String[maxSize];
		vals = new String[maxSize];
	}

	// Method 2
	// Function to get size of hash table
	public int getSize() {
		return currentSize;
	}

	// Method 3
	// Function to check if hash table is full
	public boolean isFull() {
		return currentSize == maxSize;
	}

	// Method 4
	// Function to check if hash table is empty
	public boolean isEmpty() {
		return getSize() == 0;
	}

	// Method 5
	// Fucntion to check if hash table contains a key
	public boolean contains(String key) {
		return get(key) != null;
	}

	// Method 6
	// Function to get hash code of a given key
	private int hash(String key) {
		return key.hashCode() % maxSize;
	}

	// Method 7
	// Function to insert key-value pair
	public void insert(String key, String val) {
		int tmp = hash(key);
		int i = tmp;

		// Do-while loop
		// Do part for performing actions
		do {
			if (keys[i] == null) {
				keys[i] = key;
				vals[i] = val;
				currentSize++;
				return;
			}

			if (keys[i].equals(key)) {
				vals[i] = val;
				return;
			}

			i = (i + 1) % maxSize;

		}

		// Do-while loop
		// while part for condition check
		while (i != tmp);
	}

	// Method 8
	// Function to get value for a given key
	public String get(String key) {
		int i = hash(key);
		while (keys[i] != null) {
			if (keys[i].equals(key))
				return vals[i];
			i = (i + 1) % maxSize;
		}
		return null;
	}

	// Method 9
	// Function to remove key and its value
	public void remove(String key) {
		if (!contains(key))
			return;

		// Find position key and delete
		int i = hash(key);
		while (!key.equals(keys[i]))
			i = (i + 1) % maxSize;
		keys[i] = vals[i] = null;

		// rehash all keys
		for (i = (i + 1) % maxSize; keys[i] != null; i = (i + 1) % maxSize) {
			String tmp1 = keys[i], tmp2 = vals[i];
			keys[i] = vals[i] = null;
			currentSize--;
			insert(tmp1, tmp2);
		}
		currentSize--;
	}

	// Method 10
	// Function to implement Contains Operation

	public boolean search(String s) {
		// Compute the index using the hash function
		int index = hash(s);
		// Search for an unused slot and if the index will exceed the hashTableSize then
		// roll back
		while (keys[index] != s && keys[index] != "")
			index = (index + 1) % keys.length;
		// Check if the element is present in the hash table
		if (keys[index] == s)
			return true;
		else
			return false;
	}

	/*
	 * public boolean search2(String s) { if (contains(s)) return false;
	 * 
	 * return true; }
	 */
	// Method 11
	// Function to print HashTable
	public void printHashTable() {
		System.out.println("\nHash Table : ");
		for (int i = 0; i < maxSize; i++)
			if (keys[i] != null)
				System.out.println("Key : " + keys[i] + " " + "Value : " + vals[i]);
		System.out.println();
	}
}
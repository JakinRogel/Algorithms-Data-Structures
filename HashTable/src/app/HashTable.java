package app;

import java.util.LinkedList;

public class HashTable {
  private class Entry {
    private int key;
    private String value;

    public Entry(int key, String value) {
      this.key = key;
      this.value = value;
    }
  }

  private LinkedList<Entry>[] entries = new LinkedList[5];
  private int incrementor;
  
  //adds an entry to hashtable
  public void put(int key, String value) { // T = O(n)
	  var index = hash(key);
	  if(entries[index] == null)
		  entries[index] = new LinkedList<>();
	  //checks list and updates key if match
	  var bucket = entries[index];
	  for (var entry : bucket) {
		  if(entry.key == key) {
			  entry.value = value;
			  return;
		  }
	  }
	  
	  var entry = new Entry(key, value);
	  bucket.addLast(entry);
  }
  
  //retrieves request from hashtable
  public String get(String value) { // T = O(n)
	  incrementor = 0; 
	  //creates key value from passed String
	  char[] array = value.toCharArray();
	  int key = 0;
	  for (int i = 0; i < array.length; i++) {
			key += array[i];
	}
	  //finds index and iterates over list 
	  var index = hash(key);
	  var bucket = entries[index];
	  if (bucket != null) {
	  for (var entry : bucket) {
		  if (entry.value.compareTo(value) == 0) {
			  System.out.println(incrementor + " elements inspected");
			  return entry.value;
		  }
	  incrementor++;
	  }
	  
	  }
	  
	  return null;
  }

  //hash function with Division Modulo Method
  private int hash(int key) { // T = O(1)
    return key % entries.length;
  }
}


import java.util.Arrays;
import java.lang.System;
import java.util.*;

public class StringArrayList implements StringList {

    private String[] list;
    private int elements;

    public StringArrayList() {
        this.list = new String[10];
        this.elements = 0;
    }
    
    public int add(String s) {
        if (elements > list.length-1) {
            String[] newList = new String[list.length*2 + 1];
            System.arraycopy(list, 0, newList, 0, elements);
            this.list = newList;
        }
        list[elements] = s;
        elements++;
        return elements;
    }

    /**
   * Retrieve the String at position i.
   */
    public String get(int i) {
        if (i > elements) throw new IndexOutOfBoundsException();
        else return list[i];
    }
  
    /**
     * Return true if this list contains String s.
     */
    public boolean contains(String s) {
        return indexOf(s) != -1;
    }
  
    /**
     * Return the index of String s in this list, or -1 if s is not in this list.
     */
    public int indexOf(String s) {
        for (int i = 0; i < elements; i++) {
            if (list[i].equals(s)) return i;
        }
        return -1;
    }
  
    /**
     * Return the current size of this list.
     */
    public int size() {
        return elements;
    }
  
    /**
     * Insert a string into this list in the specified index.
     * Note that this should move the rest of the values in the list.
     * @return the index where this String was inserted.
     */

    public int add(int index, String s) {
        
        if (index >= elements) throw new IndexOutOfBoundsException();

        add(null);
        for (int i = elements-1; i > index; i--) {
            list[i] = list[i-1];
        }
        list[index] = s;
        return index;
    }
  
    /**
     * Remove all strings from this list.
     */
    public void clear() {
        elements = 0;
    }
  
    /**
     * Return true if this list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return elements == 0;
    }

    /**
     * Remove a String at the specified position.
     * Note that all other values should move to fill the gap.
     */
    public String remove(int removeIndex) {
        String removedItem = list[removeIndex];
        StringArrayList removeList = new StringArrayList();
        for (int i = 0; i < elements; i++) {
            if (i == removeIndex) continue;
            else removeList.add(list[i]);
        }
        this.list = removeList.toArray();
        elements--;
        return removedItem;
    }
  
    /**
     * Set the value of the String in position index.
     */
    public void set(int index, String s) {
        list[index] = s;
    }
  
    /**
     * Return an array representation of this list.
     */
    public String[] toArray() {
        String[] shortArray = new String[elements];
        System.arraycopy(list, 0, shortArray, 0, elements);
        return shortArray.clone();
    }

    public void print() {
        System.out.println();
        System.out.println("PRINTING:");
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }
}
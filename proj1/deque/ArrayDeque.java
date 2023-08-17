package deque;

/** invariance:
 * 1. head will always be the index of the first item in the list.
 * 2. last will be the index of last item +1.
 * 3. if addFirst is call when the list is empty.
 * The first item will be at position items.length -1.
 */
public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int head;
    private int tail;

    /** Create a empty array deque. */
    public ArrayDeque(){
        items = (T[]) new Object[8]; // Casting Obejct to generic type T
        size = 0;
        head = 0;
        tail = 0;
    }

    /** Create an deep copy of other */
    public ArrayDeque(ArrayDeque<T> other){
        size = other.size();
        T[] items = (T[]) new Object[size];

        int i=0;
        while (i < size){
            items[i] = other.get(i);
            i += 1;
        }

        // Set head and tail
        head = 0;
        tail = size;
    }

    /** Return true if list is empty, false otherwise. */
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }

        return false;
    }

    /** Copy everything from array A to array B */
    private void ArrayCopy(T[] A, T[] B){
        /** 
         * The head of the ArrayDeque can be at the end of the list.
         * If head is at 0, just copy the whole array at once.
         * Else, Copy from head to array.length first 
         */
        if (head == 0){
            System.arraycopy(A, 0, B, 0, size);
        } 
        else {
            if(head + size < A.length){
                System.arraycopy(A, head, B, 0, size);
            } else {
                /** Copy first part of the array, from head to array.length */
                int itemsBefore = A.length - head;
                System.arraycopy(A, head, B, 0, itemsBefore);

                /** Copy the rest of the items, from 0 to tail -1 */
                System.arraycopy(A, 0, B, itemsBefore, tail);
            }
        }
    }

    /** Resizes the array to size x */
    private void resize(int x){
        // Create a new array with size x
        T[] a = (T[]) new Object[x];

        // Copy everything from array items to array a
        ArrayCopy(items, a);


        // Correct head and tail
        head = 0;
        tail = size;

        // Reassign reference of items to a
        items = a;
    }

    /** Halve the  Array capacity. */
    private void halve() {
        int newSize = (int) items.length / 2;

        // Create a new array of newSize
        T[] a = (T[]) new Object[newSize];

        // Copy everything from array items to array a
        ArrayCopy(items, a);

        // Correct head and tail
        head = 0;
        tail = size;

        // Reassign referenceof items to a
        items = a;
    }

    /** Add x to the end of the list */
    public void addLast(T x) {
        if (size == items.length){
            resize(size * 2);
        }

        if(tail == items.length){
            tail = 0;
        } 
        items[tail] = x;
        tail += 1;

        size += 1;
    
    }

    /** Add x to the front of the list. */
    public void addFirst(T x) {
        if (size == items.length) {
            resize(size * 2);
        }

        // Renew position of head
        if(head == 0) {
            head = items.length -1;
        } else {
            head -= 1;
        }

        // Insert x into position head.
        items[head] = x;

        size += 1;
    }

    /** Return number of items in the list. */
    public int size(){
        return size;
    }

    /** Return the ith items starting from the head of the list. 
     * 0 is at the head of the list, and 1 is head + 1. 
     * The method also accept negative Integer. -1 is at the tail -1 
     * -2 is the prev and so forth.
     * If ith is not exist, return null.
    */
    public T get(int i) {
        if(i >= 0 && i < size){
            int index = head + i;
            if(index >= items.length){
                index = index - items.length;
            }
            return items[index];
        }
        else if (i < 0 && i * -1 < size){
            int index = tail + i;
            if(index < 0){
                index = items.length + index;
            }

            return items[index];
        }
            
        return null;
    }
            
    /** Removes item at the front of the list and Returns that item. 
     * If the list is empty. Return null.
    */
    public T removeFirst(){
        if (isEmpty()){
            return null;
        }

        T first = items[head];
        items[head] = null; // Free memory

        if (head == items.length -1){
            head = 0;
        } else {
            head += 1;
        }

        size -= 1;

        // Halve array size if usage ratio is less than 0.25
        double R = (double) size / items.length;
        if (R < 0.25){
            halve();
        }
        
        return first;
    }
        
    /** 
    * Removes item at the end of the list and returns that item.
    * If item doesn't exist, return null.
    */
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        
        if(tail == 0){
            tail = items.length -1;
        } else {
            tail -= 1;
        }

        // Get last items of ArrayDeque
        T last = items[tail];

        // Free last items momery
        items[tail] = null;


        size -= 1;

        // Halve array size if usage ratio is less than 0.25
        double R = (double) size / items.length;
        if (R < 0.25){
            halve();
        }
        
        return last;
    }
    
    /** 
    * Prints all items in ArrayDeque. Items are seperated by space.
    * Print a newLine when all items are printed.
    */
    public void printDeque(){
        int currentIndex = head;
        int i=0;
        while (i<size){
            // If currentIndex reach the max length of items, go to 0
            if(currentIndex == items.length){
                currentIndex = 0;
            }

            // Print the currentIndex item
            System.out.print(items[currentIndex] + " ");
            
            // move currentIndex to the next index
            currentIndex += 1;

            // Increment i by 1
            i += 1;
        }
        // NewLine
        System.out.println();
    }

    /**
     * Returns wether or not the parameter o is equals to the deque.
     * o is considered equqals if it is a deque and if it contain the
     * same items in order. 
     */
    public boolean equals(Object o){
        if (!(o instanceof ArrayDeque)){
            return false;
        }
        ArrayDeque other = (ArrayDeque) o;
        if (size != other.size()){
            return false;
        }

        for (int i=0; i<size; i++){
            if(get(i) != other.get(i)){
                return false;
            }
        }

        return true;
    
}

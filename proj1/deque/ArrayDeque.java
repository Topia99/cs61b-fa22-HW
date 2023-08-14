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

    /** Resizes the array to size x */
    public void resize(int x){
        // Create a new array with size x
        T[] a = (T[]) new Object[x];

        /** Copy from 0 if head is at position 0. Otherwise, 
         * Copy items By two sections. First section copy from head 
         * to Length - 1. Second section copy from 0 to head -1.
         */
        if (head == 0){
            System.arraycopy(items, 0, a, 0, size);
        } 
        else {
            int ItemsBefore = size - head; 
            System.arraycopy(items, head, a, 0, ItemsBefore);
            System.arraycopy(items, 0, a, ItemsBefore, head);
        }

        // Reassign a as items
        items = a;
    }

    /** Add x to the end of the list */
    public void addLast(T x) {
        if (size == items.length){
            resize(size * 2);
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
        else if (i < 0 && -i <= size){
            int index = tail + i;
            if(index < 0){
                index = items.length + index;
            }

            return items[index];
        }

        return null;
    }

}

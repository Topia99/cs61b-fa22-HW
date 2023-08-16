package deque;

public class LinkedListDeque <T> {
    private class Node {
        public T item;
        public Node next;
        public Node prev;

        /** Create a Node of item i. Set next and prev null*/
        public Node(T i) {
            item = i;
            next = null;
            prev = null;
        }
    }


    // Instance class veriable
    private Node sentinel;
    private int size;

    /** Create an empty LinkedList Deque */
    public LinkedListDeque() {

        // Create the sentinel node
        sentinel = new Node(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;

        size = 0;
    }

    /** Creates a deep copy of "other" */
    public LinkedListDeque(LinkedListDeque<T> other){
        // Create the sentinel node
        sentinel = new Node(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;

        size = 0;

        for (int i=0; i<other.size(); i+=1){
            addLast(other.get(i));
        }
    }

    /** Adds item to the first of the Deque */
    public void addFirst(T item){
        /*  Create NewNode */
        Node newNode = new Node(item);

        /*  Get first node in the deque */
        Node first = sentinel.next;

        /*  Insert newNode inbetween sentinel and first */
        sentinel.next = newNode;
        newNode.prev = sentinel;

        first.prev = newNode;
        newNode.next = first;

        // Increment size by 1.
        size += 1;
    }

    /** Adds item to the end of the Deque */
    public void addLast(T item){
        Node newNode = new Node(item);

        Node last = sentinel.prev;

        // Insert newNode inbetween sentinel and last
        sentinel.prev = newNode;
        newNode.next = sentinel;

        last.next = newNode;
        newNode.prev = last;

        // Increment size by 1.
        size += 1;
    }

    /** Return true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    /** Return the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last,
     * separated by space.
     */
    public void printDeque() {
        if (this.isEmpty()){
            System.out.println("Deque is empty!");
            return;
        }

        Node first = sentinel.next;
        for(int i=0; i<size; i++){
            System.out.print(first.item + " ");
            first = first.next;
        }

        System.out.println();
    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeFirst(){
        if(this.isEmpty()){
            return null;
        }

        Node first = sentinel.next;
        Node newFirst = first.next;

        // Remvoe first from deque
        sentinel.next = newFirst;
        newFirst.prev = sentinel;

        // Decrement size by 1.
        size -= 1;

        // store item
        T result = first.item;

        // Release memory of first Node
        first = null;

        return result;
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, return null.
    */
    public T removeLast(){
        if(this.isEmpty()){
            return null;
        }

        Node last = sentinel.prev;
        Node newLast = last.prev;

        // Remove last from deque.
        sentinel.prev = newLast;
        newLast.next = sentinel;

        //Decrement size by 1;
        size -= 1;

        T result = last.item;

        last = null;

        return result;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, return null. 
    */
    public T get(int index) {
        // Eliminates all index that are not exist
        if(index >= size || index < 0){
            return null;
        }


        Node first = sentinel.next;

        // Moves to the index Node
        int i=0;
        while (i < index){
            first = first.next;
            i += 1;
        }

        return first.item;
    }
                
    /** Get the item at the given index using recursion. 
     * where 0 is the front and 1 is the next item and so forth.
     * If no such item exists, return null.
    */
    public T getRecursive(int index) {
        return null;
    }

    /** Returns whether or not the parameter o is equal to the deque.
     * o is considered equal if it is a deque and if it contains the
     * saame contents in the same order.
     */
    public boolean equals(Object o){
        if (!(o instanceof LinkedListDeque)) {
            return false;
        }
        LinkedListDeque other = (LinkedListDeque) o;
        // Return false if two Dequq do not have the same size.
        if (size != other.size()){
            return false;
        }

        for (int i=0; i<size; i++){
            if(this.get(i) != other.get(i)){
                return false;
            }
        }

        return true;
    }
}
    


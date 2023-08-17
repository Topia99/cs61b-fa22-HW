package deque;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestArrayDeque {
    @Test
    /**
     * Add a few items to the list, check methods addFirst() and size().
     * 
     */
    public void addFirstTest(){

        // Create a Object ArrayDeque that store String item
        ArrayDeque<String> l = new ArrayDeque<String>();


        // Call addFirst()
        l.addFirst("Alpha");
        l.addFirst("Beta");
        l.addFirst("Charlie");

        assertEquals(" Call addFirst three times, size should be 3 ", 3, l.size());

    }


    @Test
    /**
     * Create two ArrayDeque with different type
     * Add a few items to each deque using addlast(int x). Checking it with get()
     *
     */
     public void getTest() {
        ArrayDeque<Integer> l1 = new ArrayDeque<Integer>();
        ArrayDeque<Double> l2 = new ArrayDeque<Double>();

        // Add Integer items to the end of l1
        l1.addLast(1);
        l1.addLast(2);
        l1.addLast(3);

        // Get the first item in the list and check it with correct value
        assertEquals(" Get the first item in the list, should be 1 ", 1, (int) l1.get(0));
        // Get the last item in the list by using get(-1), and compare it with the correct value
        assertEquals(" The last item of the list should be 3 ", 3, (int)l1.get(-1));

        // Add Double items to the front of l2
        l2.addFirst(3.1415);
        l2.addFirst(9.99);
        l2.addFirst(100.99);

        // Get the second item in the list and compare it with correct value
        assertEquals(" The second items in the l2 should be 9.99 ", 9.99, (double)l2.get(1), 0.001);

     }

     @Test
     /** 
      * Insert mass items into the list and checking the last item in the list by using get(-1).
      * Testing effiiency of add and get.
      */
      public void InsertMassItemsGetTest(){
        ArrayDeque<Integer> l1 = new ArrayDeque<Integer>();

        // Add to the end of the list from 500,001 to 1,000,000
        for (int i=500001; i<= 1000000; i++){
            l1.addLast(i);
        }

        // AddFirst from 500,000 to 0
        for (int i= 500000; i >= 0; i--){
            l1.addFirst(i);
        }

        // The first item in the list should be 0
        assertEquals(0, (int)l1.get(0));
        
        // The second item should be 1
        assertEquals(1, (int)l1.get(1));

        // The 344th item should be 344
        assertEquals(344, (int)l1.get(344));

        // The last item should be 1000000
        assertEquals(999999, (int)(l1.get(-2)));

        // Test get that input exceeds size
        assertEquals(null, l1.get(-1000000000));
    }
        
    @Test
    /** 
    * Create a ArrayDeque with Integer Items {1, 2, 3, 4, 5}
    * Call removeFirst three time.
    * Check size(), Check return value from removeFirst.
    */
    public void removeFirstTest() {
        ArrayDeque<Integer> l1 = new ArrayDeque<Integer>();

        int i = 1;
        while (i <= 5) {
            l1.addLast(i);
            i += 1;
        }

        // Test size()
        assertEquals(" call size() should return 5 ", 5, l1.size());

        // Test removeFirst()
        assertEquals(" Call removeFirst should return 1 ", 1, (int)l1.removeFirst());
        assertEquals(" Call RemoveFirst the second time should return 2 ", 2, (int) l1.removeFirst());
        assertEquals(" Call removeFirst the thrid time should return 3 ", 3, (int) l1.removeFirst());
    }

    @Test
    /** Create a ArrayDeque.
     * The original arrayLength should be 8.
     * 
     * Add 8 items to the Deque.
     * The arrayLength should be 8 * 2 = 16.
     * 
     * Remove 5 items and left with 3 items in the Deque.
     * The array should halve its length and arrayLength should return 8.
     */
    public void TestResizeHalve() {
        ArrayDeque<Integer> l1 = new ArrayDeque<Integer>();

        // Add 9 items to l1
        for (int i=9; i>0; i--){
            l1.addFirst(i);
        }

        // Test size() should be 9
        assertEquals(9, l1.size());

        // Test arrayLength(), should be 16
        assertEquals(16, l1.arrayLength());

        // RemoveFirst for 5 time
        int result;
        for (int i=0; i< 5; i++){
            l1.removeFirst();
        }
        result = l1.removeFirst();

        assertEquals( "Should be 6" ,6, result); 

        // Check size()
        assertEquals(" Size should be 3 ", 3, l1.size());

        // Check whether halve method operate
        assertEquals(" Size of the array should reduce to 8 if there only 3 items in the list", 8, l1.arrayLength());
    }

    @Test
    /**
     * Create an arrayDeque and insert some items in it.
     * Remove two items from the front and two items from the last
     * Check all returns values.
     */
    public void TestRemoveLast() {
        ArrayDeque<String> l1 = new ArrayDeque<String>();

        l1.addLast("Alpha");
        l1.addLast("Beta");
        l1.addLast("Charlie");
        l1.addLast("Dog");

        l1.addFirst("a");


        assertEquals(" Call removeFirst should return a ", "a", l1.removeFirst());
        assertEquals("Call RemoveFirst should return Alpha", "Alpha", l1.removeFirst());
        assertEquals("Call removeLast should return Dog", "Dog", l1.removeLast());
        assertEquals("Call removeLast should return Charlie", "Charlie", l1.removeLast());
    }

    @Test
    /** Check empty remove. Should return null. */
    public void TestEmptyRemove() {
        ArrayDeque<Integer> l1 = new ArrayDeque<Integer>();

        assertEquals(null, l1.removeFirst());
        assertEquals(null, l1.removeLast());
    }

    @Test
    /** Testing printDeque */
    public void testPrintDeque() {
        ArrayDeque<Integer> l1 = new ArrayDeque<Integer>();

        for(int i=0; i<5; i++){
            l1.addFirst(i);
        }

        l1.printDeque();

        ArrayDeque<String> l2 = new ArrayDeque<String>();

        l2.addLast("Alpha");
        l2.addLast("Beta");
        l2.addLast("Charlie");
        l2.addLast("Dog");

        l2.printDeque();

    }

    @Test
    /** Testing equals() */
    public void testEquals(){
        ArrayDeque<Integer> l1 = new ArrayDeque<Integer>();
        ArrayDeque<Integer> l2 = new ArrayDeque<Integer>();


        for (int i=0; i<10; i++){
            l1.addLast(i);
            l2.addLast(i);
        }

        assertTrue(l1.equals(l2));

        // check equals with a ArrayDeque of different type
        ArrayDeque<String> l3 = new ArrayDeque<String>();
        l3.addFirst("abc");

        assertFalse(l1.equals(l3));


        // Check equals with a same type but different items
        ArrayDeque<Integer> l4 = new ArrayDeque<Integer>();
        l4.addFirst(3);
        l4.addLast(4);

        assertFalse(l1.equals(l4));
    }
}
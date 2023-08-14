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
        assertEquals(1000000, (int)(l1.get(-1)));
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

}

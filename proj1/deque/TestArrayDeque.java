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
     * Create two ArrayDeque
     * Add a few items to each deque using add last. Checking it with size()
     *
     */

     public void addLastTest() {
        
     }
}

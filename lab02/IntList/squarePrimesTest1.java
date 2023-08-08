package IntList;

import static org.junit.Assert.*;
import org.junit.Test;


public class squarePrimesTest1 {
    @Test
    public void testSquarePrimes(){
        IntList L = IntList.of(1, 2, 3, 4, 5, 6, 7, 8);
        boolean hasPrime = IntListExercises.squarePrimes(L);
        assertEquals("1 -> 4 -> 9 -> 4 -> 25 -> 6 -> 49 -> 8", L.toString());
        assertTrue(hasPrime);
    }

    @Test
    public void testSquarePrimes_noPrime(){
        IntList L = IntList.of(4, 6, 12, 14, 15);
        boolean hasPrime = IntListExercises.squarePrimes(L);
        assertEquals("4 -> 6 -> 12 -> 14 -> 15", L.toString());
        assertTrue(!hasPrime);
    }
}

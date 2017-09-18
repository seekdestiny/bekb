package synthesizer;
import static org.junit.Assert.*;
import org.junit.Test;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer<Double>(4);

        arb.enqueue(33.1);
        arb.enqueue(44.8);
        arb.enqueue(62.3);
        arb.enqueue(-3.4);

        for (double front : arb) {
            System.out.println(front);
        }

        double expected = arb.peek();
        double actual = 33.1;
        assertEquals("test peek failed", expected, actual, 0.0);

        expected = arb.dequeue();
        assertEquals("test dequeue failed", expected, actual, 0.0);

        expected = arb.peek();
        actual = 44.8;
        assertEquals("test dequeue failed", expected, actual, 0.0);

        for (double front : arb) {
            System.out.println(front);
        }

        arb.enqueue(0.5);
        for (double front : arb) {
            System.out.println(front);
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 

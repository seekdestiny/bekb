import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {
    @Test
    public void randomizedTest() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        OperationSequence fs = new OperationSequence();
        Integer expected = 0;
        Integer actual = 0;

        for (int i = 0; i < 1000; i += 1) {
            double numberBetweenZeroAndFour = StdRandom.uniform(4);

            if (numberBetweenZeroAndFour < 1) {
                sad.addLast(i);
                ads.addLast(i);
                fs.addOperation(new DequeOperation("addLast", i));
            } else if (numberBetweenZeroAndFour < 2) {
                sad.addFirst(i);
                ads.addFirst(i);
                fs.addOperation(new DequeOperation("addFirst", i));
            } else if (numberBetweenZeroAndFour < 3) {
                if (!sad.isEmpty()) {
                    actual = sad.removeLast();
                    fs.addOperation(new DequeOperation("removeLast"));
                }
                if (!ads.isEmpty()) {
                    expected = ads.removeLast();
                }
            } else {
                if (!sad.isEmpty()) {
                    actual = sad.removeFirst();
                    fs.addOperation(new DequeOperation("removeFirst"));
                }
                if (!ads.isEmpty()) {
                    expected = ads.removeFirst();
                }
            }

            assertEquals(fs.toString(), expected, actual);
        }
    }
}

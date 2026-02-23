package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private final int[] TEST_ARRAY = {1, 3, 4, 2, 5};
    private final int QUEUE_CAPACITY = 3;
    private CircularQueue queue;

    @BeforeEach
    public void beforeEach() {
        queue = new CircularQueueImpl(QUEUE_CAPACITY);
    }

    @Test
    public void testQueueIsInitiallyEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testQueueIsNotInitiallyFull() {
        assertFalse(queue.isFull());
    }

    @Test
    public void testGetFirstIfEmpty() {
        assertThrows(IllegalStateException.class, () -> queue.getFirst());
    }

    @Test
    public void testGetFirst() {
        int elementToAdd = 1;
        queue.add(elementToAdd);
        assertEquals(elementToAdd, queue.getFirst());
    }

    @Test
    public void testAddMoreElementsThanCapacity() {
        for (int i: TEST_ARRAY) {
            queue.add(i);
        }

    }
}

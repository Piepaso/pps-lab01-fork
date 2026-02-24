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
    public void testPopIfEmpty() {
        assertThrows(IllegalStateException.class, () -> queue.pop());
    }

    @Test
    public void testIsFull() {
        fillQueue();
        assertTrue(queue.isFull());
    }

    @Test
    public void testPeek() {
        fillQueue();
        for (int i = 0; i<2; i++) {
            assertEquals(TEST_ARRAY[0], queue.peek());
        }
    }

    @Test
    public void testPop() {
        fillQueue();
        for (int i = 0; i < QUEUE_CAPACITY; i++) {
            assertEquals(TEST_ARRAY[i], queue.pop());
        }
    }

    @Test
    public void testAddMoreElementsThanCapacity() {
        fillQueueOverCapacity();
    }

    @Test
    public void testCircularity() {
        fillQueueOverCapacity();
        for (int i = 0; i < QUEUE_CAPACITY; i++) {
            assertEquals(TEST_ARRAY[TEST_ARRAY.length - QUEUE_CAPACITY + i], queue.pop());
        }
    }

    @Test
    public void testIsEmptyAfterEmptying() {
        fillQueueOverCapacity();
        for (int i = 0; i < QUEUE_CAPACITY; i++) {
            queue.pop();
        }
        assertTrue(queue.isEmpty());
    }

    private void fillQueue() {
        for (int i = 0; i < QUEUE_CAPACITY; i++) {
            queue.add(TEST_ARRAY[i]);
        }
    }

    private void fillQueueOverCapacity() {
        for (int i: TEST_ARRAY) {
            queue.add(i);
        }
    }
}

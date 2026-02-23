package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    private MinMaxStack stack;
    private final int[] TEST_ARRAY = {1, 3, 4, 2};

    @BeforeEach
    public void beforeEach() {
        this.stack = new MinMaxStackImpl();
    }

    @Test
    public void testStackIsInitiallyEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testEmptyStackPop() {
        assertThrows(IllegalStateException.class, () -> stack.pop());
    }

    @Test
    public void testEmptyStackPeek() {
        assertThrows(IllegalStateException.class, () -> stack.peek());
    }

    @Test
    public void testEmptyStackMin() {
        assertThrows(IllegalStateException.class, () -> stack.getMin());
    }

    @Test
    public void testEmptyStackMax() {
        assertThrows(IllegalStateException.class, () -> stack.getMax());
    }

    @Test
    public void testPush() {
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPeek() {
        pushArray();
        for(int i = 1; i < 2; i++) {
            assertEquals(TEST_ARRAY[TEST_ARRAY.length - 1], stack.peek());
        }
    }

    @Test
    public void testPop() {
        pushArray();
        for(int i = 1; i < 2; i++) {
            assertEquals(TEST_ARRAY[TEST_ARRAY.length - i], stack.pop());
        }
    }

    @Test
    public void testEmpty() {
        stack.push(1);
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testMin() {
        pushArray();
        assertEquals(Arrays.stream(TEST_ARRAY).min().getAsInt(), stack.getMin());
    }

    @Test
    public void testMax() {
        pushArray();
        assertEquals(Arrays.stream(TEST_ARRAY).max().getAsInt(), stack.getMax());
    }

    private void pushArray() {
        for (int i : TEST_ARRAY) {
            stack.push(i);
        }
    }
}
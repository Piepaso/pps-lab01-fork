package tdd;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  <br>
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  <br>
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue {

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Checks if the queue is full.
     *
     * @return true if the queue is full, false otherwise.
     */
    boolean isFull();

    /**
     * Gets the capacity of the queue.
     *
     * @return The capacity of the queue.
     */
    int getCapacity();

    /**
     * Adds an integer to the queue. If the queue is full, it overwrites the oldest element.
     *
     * @param i The integer to add.
     */
    void add(int i);

    /**
     * Removes and returns the oldest element of the queue.
     *
     * @return The popped element.
     * @throws IllegalStateException if the queue is empty.
     */
    int pop();

    /**
     * Retrieves, but does not remove, the oldest element of the queue.
     *
     * @return The oldest element of the queue.
     * @throws IllegalStateException if the queue is empty.
     */
    int peek();
}
package tdd;

public class CircularQueueImpl implements CircularQueue {

    private final int capacity;
    private final int[] queue;
    private int firstIndex = -1;
    private int nextInsertIndex = 0;
    private int currentSize = 0;

    public CircularQueueImpl(int queueCapacity) {
        this.capacity = queueCapacity;
        queue = new int[capacity];
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public boolean isFull() {
        return currentSize == capacity;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void add(int i) {
        queue[nextInsertIndex] = i;
        updateNextInsertIndex();
        updateFirstIndex(false);
        currentSize += isFull() ? 0 : 1;
    }

    @Override
    public int pop() {
        checkForEmptyQueueRead();
        int temp = queue[firstIndex];
        updateFirstIndex(true);
        currentSize--;
        return temp;
    }

    @Override
    public int peek() {
        checkForEmptyQueueRead();
        return queue[firstIndex];
    }

    private void checkForEmptyQueueRead() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
    }

    private void updateNextInsertIndex() {
        nextInsertIndex = (nextInsertIndex + 1) % capacity;
    }

    private void updateFirstIndex(boolean on_pop) {
        if (isEmpty())
            firstIndex = 0;
        if (isFull() || on_pop)
            firstIndex = (firstIndex + 1) % capacity;
    }
}

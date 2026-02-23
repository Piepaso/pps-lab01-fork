package tdd;

public class CircularQueueImpl implements CircularQueue {

    private LinkedInteger first =  null;
    private LinkedInteger last =  null;
    private final int capacity;

    public CircularQueueImpl(int queueCapacity) {
        this.capacity = queueCapacity;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void add(int i) {

    }

    @Override
    public int getFirst() {
        throw new IllegalStateException();
    }
}

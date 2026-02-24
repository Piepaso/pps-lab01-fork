package tdd;

public class MinMaxStackImpl implements MinMaxStack {
    private LinkedInteger stackTop =  null;
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;
    private int size = 0;

    @Override
    public void push(int value) {
        stackTop = new LinkedInteger(value, stackTop);
        min = Math.min(min, value);
        max = Math.max(max, value);
        size++;
    }

    @Override
    public int pop() {
        checkForEmptyStackRead();
        size--;
        LinkedInteger temp = stackTop;
        stackTop = stackTop.getNext();
        return temp.getValue();
    }

    @Override
    public int peek() {
        checkForEmptyStackRead();
        return stackTop.getValue();
    }

    @Override
    public int getMin() {
        checkForEmptyStackRead();
        return min;
    }

    @Override
    public int getMax() {
        checkForEmptyStackRead();
        return max;
    }

    @Override
    public boolean isEmpty() {
        return stackTop == null;
    }

    @Override
    public int size() {
        return size;
    }

    private void checkForEmptyStackRead() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
    }
}

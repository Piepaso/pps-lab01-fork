package tdd;

public class LinkedInteger {
    private final int value;
    private final LinkedInteger next;

    public LinkedInteger(int value, LinkedInteger next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public LinkedInteger getNext() {
        return next;
    }
}

package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private final int PIN = 1234;
    private SmartDoorLock door;
    private final int wrongPin = PIN + 1;

    @BeforeEach
    public void beforeEach(){
        door = new SmartDoorLockImpl();
    }

    @Test
    void testDoorIsInitiallyUnlocked() {
        assertFalse(door.isLocked());
    }

    @Test
    void testDoorIsNoTInitiallyBlocked() {
        assertFalse(door.isBlocked());
    }

    @Test
    void testLockIfPinIsNotSet() {
        assertThrows(IllegalStateException.class, () -> door.lock());
    }

    @Test
    void testSetPin() {
        door.setPin(PIN);
    }

    @Test
    void testSetInvalidPin() {
        assertThrows(IllegalArgumentException.class, () -> door.setPin(10000));
        assertThrows(IllegalArgumentException.class, () -> door.setPin(-1));
    }

    @Test
    void testLock() {
        setPinAndLock();
        assertTrue(door.isLocked());
    }

    @Test
    void testCannotSetPinIfLocked() {
        setPinAndLock();
        assertThrows(IllegalStateException.class, () -> door.setPin(PIN));
        assertTrue(door.isLocked());
    }

    @Test
    void testUnlock()  {
        setPinAndLock();
        door.unlock(PIN);
        assertFalse(door.isLocked());
    }

    @Test
    void testWrongPinUnlock() {
        setPinAndLock();
        door.unlock(wrongPin);
        assertTrue(door.isLocked());
    }

    @Test
    void testGetFailedAttemptsNumber() {
        setPinAndLock();
        door.unlock(wrongPin);
        door.unlock(PIN);
        door.lock();
        for (int i = 0; i < door.getMaxAttempts(); i++) {
            door.unlock(wrongPin);
        }

    }

    @Test
    void testBlock() {
        block();
        assertTrue(door.isBlocked());
    }

    @Test
    void testReset() {
        block();
        door.reset();
        assertFalse(door.isBlocked());
        assertFalse(door.isLocked());
        assertThrows(IllegalStateException.class, () -> door.lock());
        assertEquals(0, door.getFailedAttempts());
    }

    private void setPinAndLock() {
        door.setPin(PIN);
        door.lock();
    }

    private void block() {
        setPinAndLock();
        for (int i = 0; i <= door.getMaxAttempts(); i++) {
            door.unlock(wrongPin);
        }
    }
}

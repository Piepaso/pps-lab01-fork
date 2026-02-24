package tdd;

public class SmartDoorLockImpl implements SmartDoorLock {

    private final int MAX_ATTEMPTS = 5;
    private final int MAX_PIN = 9999;
    private boolean locked;
    private int pin;
    private boolean isPinSet;
    private int failedAttempts;

    @Override
    public void setPin(int pin) {
        if (pin < 0 || pin > MAX_PIN) {
            throw new IllegalArgumentException("Invalid Pin");
        }
        if (this.isLocked()) {
            throw new IllegalStateException("Door is Locked");
        } else  {
            this.isPinSet = true;
            this.pin = pin;
        }
    }

    @Override
    public void unlock(int pin) {
        if (! (pin == this.pin)) {
            this.failedAttempts++;
        } else  {
            this.locked = isBlocked();
        }
    }

    @Override
    public void lock() {
        if (!this.isPinSet) {
            throw new IllegalStateException("Pin is not set");
        }
        this.locked = true;
    }

    @Override
    public boolean isLocked() {
        return this.locked;
    }

    @Override
    public boolean isBlocked() {
        return failedAttempts > getMaxAttempts();
    }

    @Override
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts() {
        return failedAttempts;
    }

    @Override
    public void reset() {
        locked = false;
        pin = 0;
        isPinSet = false;
        failedAttempts = 0;
    }
}

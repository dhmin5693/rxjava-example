package common;

public class VolatileCounter implements Counter {

    private volatile int count;

    @Override
    public void increment() {
        count++;
    }

    @Override
    public int get() {
        return count;
    }
}

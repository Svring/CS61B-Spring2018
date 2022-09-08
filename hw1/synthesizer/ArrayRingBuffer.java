package hw1.synthesizer;

//import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    @SuppressWarnings("unchecked")
    public ArrayRingBuffer(int capacity) {
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        this.capacity = capacity;
        this.fillCount = 0;
        first = 0;
        last = 0;
        rb = (T[]) new Object[capacity];
    }

    private int PlusOne(int i) {
        if (i + 1 == capacity) {
            i = 0;
        } else {
            i++;
        }
        return i;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        rb[last] = x;
        this.fillCount++;
        last = PlusOne(last);
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        T target = rb[first];
        rb[first] = null;
        this.fillCount--;
        first = PlusOne(first);
        return target;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        return rb[first];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
}

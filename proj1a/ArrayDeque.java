public class ArrayDeque<T> {

    private T[] items;
    private int size;
    private int length;
    private int nextFirst;
    private int nextLast;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int minusOne(int index) {
        if (index == 0) {
            return length - 1;
        }
        return index - 1;
    }

    private int plusOne(int index, int module) {
        index %= module;
        if (index == module - 1) {
            return 0;
        }
        return index + 1;
    }

    @SuppressWarnings("unchecked")
    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        length = 8;
        nextFirst = 4;
        nextLast = 4;
    }

    public void addFirst(T item) {
        if (size == length - 1) {
            resize();
        }
        nextFirst = minusOne(nextFirst);
        items[nextFirst] = item;
        size++;
    }

    public void addLast(T item) {
        if (size == length - 1) {
            resize();
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast, length);
        size++;
    }

    public T removeFirst() {
        if (length >= 16 && length / size >= 4) {
            resize();
        }
        if (size == 0) {
            return null;
        }
        T ans = items[nextFirst];
        nextFirst = plusOne(nextFirst, length);
        size--;
        return ans;
    }

    public T removeLast() {
        if (length >= 16 && length / size >= 4) {
            resize();
        }
        if (size == 0) {
            return null;
        }
        nextLast = minusOne(nextLast);
        size--;
        return items[nextLast];
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int p = nextFirst;
        for (int i = 0; i < index; i++) {
            p = plusOne(p, length);
        }
        return items[p];
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        if (size == length - 1) {
            T[] newitems = (T []) new Object[length * 2];
            int ptr = length;
            int front = nextFirst;
            while (front != nextLast) {
                newitems[ptr] = items[front];
                front = plusOne(front, length);
                ptr = plusOne(ptr, length * 2);
            }
            nextFirst = length;
            nextLast = ptr;
            items = newitems;
            length *= 2;
        } else if (length >= 16 && length / size >= 4) {
            T[] newitems = (T []) new Object[length / 2];
            int ptr = length / 4;
            int front = nextFirst;
            while (front != nextLast) {
                newitems[ptr] = items[front];
                front = plusOne(front, length);
                ptr = plusOne(ptr, length / 2);
            }
            nextFirst = length / 4;
            nextLast = ptr;
            items = newitems;
            length /= 2;
        }
    }

    public void printDeque() {
        int p = nextFirst;
        while (p != nextLast) {
            System.out.print(items[p] + " ");
            p = plusOne(p, length);
        }
    }
}

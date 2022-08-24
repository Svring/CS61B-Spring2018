public class ArrayDeque<T> {

    private T[] items;
    private int size;
    private int length;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        length = 8;
        nextFirst = 7;
        nextLast = 0;
    }

    public void addFirst(T item) {
        items[nextFirst] = item;
        nextFirst--;
        size++;
        resize();
    }

    public void addLast(T item) {
        items[nextLast] = item;
        nextLast++;
        size++;
        resize();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        for (int i = nextFirst + 1; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
        for (int i = 0; i < nextLast; i++) {
            System.out.print(items[i] + " ");
        }
    }

    public T removeFirst() {
        T ans = items[nextFirst + 1];
        items[nextFirst + 1] = null;
        nextFirst++;
        size--;
        resize();
        return ans;
    }

    public T removeLast() {
        T ans = items[nextLast - 1];
        items[nextLast - 1] = null;
        nextLast--;
        size--;
        resize();
        return ans;
    }

    public T get(int index) {
        return items[index];
    }

    private void resize() {
        if (size == length - 1) {
            int pos = nextFirst;
            T[] newitems = (T []) new Object[length * 2];
            System.arraycopy(items, 0, newitems, 0, pos);
            System.arraycopy(items, pos, newitems, newitems.length - (size - pos), size - pos);
            items = newitems;
            nextFirst = newitems.length - pos - 1;
            length = length * 2;
        } else if (size >= 16 && ratio() <= 0.25) {
            T[] newitems = (T []) new Object[length / 2];
            System.arraycopy(items, 0, newitems, 0, nextLast);
            System.arraycopy(items, nextFirst + 1, newitems, newitems.length - (items.length - nextFirst) + 1, (items.length - nextFirst) - 1);
            items = newitems;
            nextFirst = newitems.length - (items.length - nextFirst);
            length = length / 2;
        }
    }

    private int ratio() {
        return (1 - (nextFirst - nextLast) / size);
    }
}
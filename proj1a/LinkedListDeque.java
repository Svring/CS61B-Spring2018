public class LinkedListDeque<T> {

    /* abstraction level one */
    private class Node {

        /* instance variebles */
        private T item;
        private Node next;
        private Node prev;

        /* initialize */
        public Node(T i, Node n, Node p) {
            item = i;
            next = n;
            prev = p;
        }
        public Node() {
            item = null;
            next = null;
            prev = null;
        }
    }

    /* abstraction level two */
    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T var) {
        Node newList = new Node(var, sentinel.next, sentinel);
        sentinel.next.prev = newList;
        sentinel.next = newList;
        size++;
    }

    public void addLast(T var) {
        Node newList = new Node(var, sentinel, sentinel.prev);
        sentinel.prev.next = newList;
        sentinel.prev = newList;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node p = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return p.item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node p = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return p.item;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node p = sentinel.next;
        while (index > 0) {
            p = p.next;
            index--;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return helper(index, sentinel.next);
    }

    private T helper(int index, Node L) {
        if (index == 0) {
            return L.item;
        } else {
            return helper(index--, L.next);
        }
    }
}

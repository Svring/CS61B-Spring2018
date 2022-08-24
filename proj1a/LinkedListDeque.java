public class LinkedListDeque<T> {

    /* abstraction level one */
    public static class node<T> {

        /* instance variebles */
        public T item;
        public node<T> next;
        public node<T> prev;

        /* initialize */
        public node(T i, node<T> n, node<T> p){
            item = i;
            next = n;
            prev = p;
        }
        public node(){
            item = null;
            next = null;
            prev = null;
        }
    }

    /* abstraction level two */
    public node<T> sentinel = new node<>();
    public int size = 0;

    public LinkedListDeque() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void addFirst(T var) {
        sentinel.next = new node<>(var, sentinel.next, sentinel.prev);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }

    public void addLast(T var) {
        sentinel.prev.next = new node<>(var, sentinel, sentinel.prev);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        node<T> p = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    public T removeFirst() {
        node<T> p = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return p.item;
    }

    public T removeLast() {
        node<T> p = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return p.item;
    }

    public T get(int index) {
        if (index > size) return null;
        node<T> p = sentinel;
        while (index > 0) {
            p = p.next;
            index--;
        } return p.item;
    }

    public T getRecursion(int index) {
        return helper(index, this.sentinel);
    }

    public T helper(int index, node<T> L) {
        if (index == 0 || index > size) {
            return L.item;
        } else {
            return helper(index--, L.next);
        }
    }
}
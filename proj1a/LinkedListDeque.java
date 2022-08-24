public class LinkedListDeque<T> {

    /* abstraction level one */
    public class node {

        /* instance variebles */
        private T item;
        private node next;
        private node prev;

        /* initialize */
        public node(T i, node n, node p){
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
    public node sentinel = new node();
    public int size = 0;

    public LinkedListDeque() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void addFirst(T var) {
        sentinel.next = new node(var, sentinel.next, sentinel.prev);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }

    public void addLast(T var) {
        sentinel.prev.next = new node(var, sentinel, sentinel.prev);
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
        node p = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    public T removeFirst() {
        node p = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return p.item;
    }

    public T removeLast() {
        node p = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return p.item;
    }

    public T get(int index) {
        if (index > size) return null;
        node p = sentinel;
        while (index > 0) {
            p = p.next;
            index--;
        } return p.item;
    }

    public T getRecursion(int index) {
        return helper(index, this.sentinel);
    }

    public T helper(int index, node L) {
        if (index == 0 || index > size) {
            return L.item;
        } else {
            return helper(index--, L.next);
        }
    }
}
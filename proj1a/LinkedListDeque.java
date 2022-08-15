public class LinkedListDeque<T> {

    /* abstraction level one */
    public static class node<T> {

        /* instance variebles */
        public T item;
        public node<T> next;
        public node<T> prev;

        /* initialize */
        public node(T i, node<T> n){
            item = i;
            next = n;
        }
        public node(){
            item = null;
            next = null;
        }
    }

    /* abstraction level two */
    public node<T> sentinel = new node<>();
    public int size;

    public LinkedListDeque() {
        sentinel.next = new node<>();
        size = 0;
    }

    public void addFirst(T var) {
        sentinel.next = new node<>(var, sentinel.next);
        size += 1;
    }

    public void addLast(T var, LinkedListDeque<T> L) {

    }
}

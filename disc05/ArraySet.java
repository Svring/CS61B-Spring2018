package disc05;

import java.util.*;

public class ArraySet<T> {

    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;
    
        public ArraySetIterator() {
            wizPos = 0;
        }
    
        public boolean hasNext() {
            return wizPos < size;
        }
    
        public T next() {
            T returnItem = set[wizPos];
            wizPos += 1;
            return returnItem;
        }
    }

    private T[] set;
    private int size;

    @SuppressWarnings("unchecked")
    public ArraySet() {
        set = (T[]) new Object[8];
        size = 0;
    }

    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (T item: set) {
            if (item == null) {
                continue;
            }
            if (item.equals(x)) {
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map. 
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if (contains(x)) {
            return;
        }
        set[size] = x;
        size++;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<>();
        s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");        
        System.out.println(s.contains("horse"));        
        System.out.println(s.size());       
    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}

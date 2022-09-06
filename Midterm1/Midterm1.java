package Midterm1;

import static org.junit.Assert.*;

import org.junit.Test;

import lab3.IntList.IntList;

public class Midterm1 {
    public class Sans {
        public static int[] sans(int[] x, int y) {
            int[] xclean = new int[x.length];
            int c = 0;
            for (int i = 0; i < x.length; i += 1) {
                if (x[i] != y) {
                    xclean[c] = x[i];
                    c++;
                }
            }
            int[] r = new int[c];
            System.arraycopy(xclean, 0, r, 0, c);
            return r;
        }
        
        public static IntList ilsans(IntList x, int y) {
            if (x == null) {
                return null;
            }
            if (x.first == y) {
                return ilsans(x.rest, y);
            }
            return new IntList(x.first, ilsans(x.rest, y));
        }
        
        public static IntList dilsans(IntList x, int y) {
            if (x == null) {
                return null;
            }
            x.rest = dilsans(x.rest, y);
            if (x.first == y) {
                return x.rest;
            }
            return x;
        }
    }
    
    @Test
    public void testSans() {
        int[] x = new int[]{1, 2, 3, 2};
        int y = 2;
        int[] expected = new int[]{1, 3};
        int[] actual = Sans.sans(x, y);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testIlsans() {
        IntList x = IntList.of(1, 2, 3, 2);
        int y = 2;
        IntList expected = IntList.of(1, 3);
        IntList actual = Sans.ilsans(x, y);
        assertNotEquals(x, actual);
        assertEquals(expected, actual);
    }
    
    /*
    public interface Stack<Item> {
        public void push(Item x);
        public Item pop();
        public int size();
        public default void purge(Item x) {
            ArrayStack<Item> temp = new ArrayStack<>();
            while (size() > 0) {
                Item one = pop();
                if (!one.equals(x)) {
                    temp.push(one);
                }
            }
            while (temp.size() > 0) {
                push(temp.pop());
            }
        }
    }
    
    
    @SuppressWarnings("unchecked")
    public class ArrayStack<Item> implements Stack<Item> {
        private Item[] items;
        private int size;
    
        public ArrayStack() {
            items = (Item[]) new Object[8];
            size = 0;
        }
    
        private void resize(int capacity) {
            Item[] newItem = (Item[]) new Object[capacity];
            System.arraycopy(items, 0, newItem, 0, size);
            items = newItem;
        }
    
        public void push(Item x) {
            if (usageRatio() == 1) {
                resize(size * 2);
            }
            items[size] = x;
            size++;
        }
    
        public Item pop() {
            if (size == 0) { return null;}
            if (usageRatio() < 0.25 && items.length > 8) { resize(items.length / 2); }
            Item ans = items[size - 1];
            items[size - 1] = null;
            size--;
            return ans;
        }
    
        public int size() { return size; }
    
        private double usageRatio() { return ((double) size()) / items.length; }
    }
    
    public interface ComFunc {
        int apply(int a, int b);
    }
    
    /*
    public class Combine {
        public static int combine(ComFunc f, int[] x) {
            if (x.length == 0) {
                return 0;
            }
            if (x.length == 1) {
                return x[0];
            }
            int t = f.apply(x[0], x[1]);
            return combine(f, x, t, 2);
        }
    
        private static int combine(IntFunction f, int[] x, int t, int k) {
            if (k == x.length) {
                return t;
            }
            t = f.apply(x[k], t);
            return combine(f, x, t, k + 1);
        }
    
        private static int combineAlt(IntFunction f, int[] x) {
            int t = f.apply(x[0], x[1]);
            for (int i = 2; i < x.length; i += 1) {
                t = f.apply(x[i], t);
            }
            return t;
        }
    }
    
    public class Add implements ComFunc {
        public Add() {

        }

        public int apply(int a, int b) {
            return a + b;
        }
    
        public static int sumAll(int[] x) {
            return Combine.combine(new Add(), x);
        }
    }
    */
    
    public interface ListOfInts {
        public void addLast(int i);
        public int get(int i);
        public int size();
        public void set(int i, int value);
        default public void plusEquals(ListOfInts x) {
            if (size() != x.size()) {
                return;
            }
            for (int i = 0; i < size(); i++) {
                this.set(i, this.get(i) + x.get(i));
            }
        }
    }
    
    public class DLListOfInts implements ListOfInts {
        public class IntNode {
            public int item;
            public IntNode next, prev;
        }
        public IntNode sentinel;
        public int size;
    
        public void plusEquals(DLListOfInts x) {
            if (size() != x.size() || x == null) {
                return;
            }
            IntNode q = x.sentinel.next;
            for (IntNode p = sentinel.next; p.next != p; p = p.next, q = q.next) {
                p.item += q.item;
            }
        }

        @Override
        public void addLast(int i) {            
        }

        @Override
        public int get(int i) {
            return 0;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public void set(int i, int value) {
            
        }
    }

    public class PartC {
        public static DLListOfInts sumOfLists(DLListOfInts[] lists) {
            ListOfInts result = lists[0];
    
            for (int i = 1; i < lists.length; i += 1) {
                result.plusEquals(lists[i]);
            }
            return (DLListOfInts) result;
            // this is wrong, I just try to suppress warnings
        }
    }
}

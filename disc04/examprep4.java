package disc04;

import java.util.NoSuchElementException;

public class examprep4 {

    public class SLList {
        int item;
        SLList next;
        public SLList() {}
        public void insertFront(int x) {}
        public int indexOf(int x) {return 0;}
    }

    public class SLListVista extends SLList {
        @Override
        public int indexOf(int x) {
            int index = super.indexOf(x);
            if (index == -1) {
                throw new NoSuchElementException();
            }
            return index;
        }
    }

    public class DMSList {
        private IntNode sentinel;

        public DMSList() {
            sentinel = new IntNode(-1000, new node());
        }

        public int max() {
            return sentinel.next.max();
        }

        public class IntNode {
            public int item;
            public IntNode next;
            public IntNode(int i, IntNode h) {
                item = i;
                next = h;
            }
            public int max() {
                return Math.max(item, next.max());
            }
        }

        public class node extends IntNode {
            public node() {
                super(0, null);
            }

            @Override
            public int max() {
                return 0;
            }
        }
    }
}
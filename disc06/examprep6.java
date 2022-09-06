package disc06;

import java.util.Iterator;
import java.util.NoSuchElementException;
import lab3.IntList.IntList;

public class examprep6 {
    public class AltList<X, Y> {
        private X item;
        private AltList<Y, X> next;

        AltList(X item, AltList<Y, X> next) {
            this.item = item;
            this.next = next;
        }

        public AltList<Y, X> pairsSwapped() {
            AltList<Y, X> ans = new AltList<Y, X>(next.item, new AltList<X,Y>(item, null));
            if (next.next != null) {
                ans.next.next = next.next.pairsSwapped();
            }
            return ans;
        }
    }

    public class KthIntList implements Iterator <Integer> {
        public int k;
        private IntList curList;
        private boolean hasNext;

        public KthIntList(IntList I, int k) {
            this.k = k;
            this.curList = I;
            this.hasNext = true;
        }

        public boolean hasNext() {
            return this.hasNext;
        }

        public Integer next() {
            if (curList == null) {
                throw new NoSuchElementException();
            }
            Integer R = curList.first;
            while (k > 0 && curList != null) {
                curList = curList.rest;
                k--;
            }
            hasNext = (curList == null);
            return R;
        }
    }
}

package disc03;

public class examprep3 {
    public static int[] flatten(int[][] x) {
        int totalLength = 0;

        for (int[] L: x) {
            totalLength += L.length;
        }

        int[] a = new int[totalLength];
        int aIndex = 0;

        for (int[] L: x) {
            for (int i = 0; i < L.length; i++) {
                a[aIndex] = L[i];
                aIndex++;
            }
        }

        return a;
    }

    @SuppressWarnings("unused")
    private class IntList {
        public int first;
        public IntList rest;
        
        public IntList (int f, IntList r) {
            this.first = f;
            this.rest = r;
        }

        public void skippify() {

            IntList p = this;
            int n = 1;

            while (p != null) {
    
                IntList next = p.rest;
    
                for (int j = 0; j < n; j++) {
                    if (next == null) {
                        break;
                    }
                    next = next.rest;
                }

                p.rest = next;
                p = next;
                n++;
            }
        }

        public static void removeDuplicates(IntList p) {
            if (p == null) {
                return;
            }

            IntList current = p.rest;
            IntList previous = p;

            while (current != null) {
                if (previous.first == current.first) {
                    previous.rest = current.rest;
                } else {
                    previous = current;
                }
                current = previous.rest;
            }
        }
    }
}
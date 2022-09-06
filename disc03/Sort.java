package disc03;

public class Sort {
    /** Sorts strings destructively. */
    public static void sort(String[] x) {
           sort(x, 0);
    }

    private static void sort(String[] x, int start) {
        if (start == x.length) {
            return;
        } else {
            int smallest = findSmallest(x, start);
            swap(x, start, smallest);
            sort(x, start + 1);
        }
    }

    /** Returns the smallest string in x. */
    public static int findSmallest(String[] x, int start) {
        int smallest = start;
        for (int i = start; i < x.length; i++) {
            if (x[smallest].compareTo(x[i]) > 0) {
                smallest = i;
            }
        }
        return smallest;
    }

    public static void swap(String[] x, int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }
}
public class Sort {
    /** Sorts strings destructively. */
    public static void sort(String[] x) { 
           // find the smallest item
           // move it to the front
           // selection sort the rest (using recursion?)
           
    }

    /** Returns the smallest string in x. */
    public static int findSmallest(String[] x) {
        int smallest = 0;
        for (int i = 0; i < x.length; i++) {
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
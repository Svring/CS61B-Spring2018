public class Max {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int len = m.length, i = 0, target = 0;
        while (i < len) {
            if (m[i] > target) {
                target = m[i];
            } i = i + 1;
        }
        System.out.println(target);
        return 0;
    }
    /** Remake max */
    public static int max_re(int[] m) {
        int target = 0;
        for (int len = m.length, i = 0; i < len; i += 1) {
            if (m[i] > target) {
                target = m[i];
            } i += 1;
        }
        System.out.println(target);
        return 0;
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
       max(numbers);
       max_re(numbers);
    }
}
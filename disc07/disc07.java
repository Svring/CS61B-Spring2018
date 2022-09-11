package disc07;

import java.util.HashSet;
import java.util.Set;

public class disc07 {
    public static boolean findSum(int[] A, int x) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[i] + A[j] == x) {
                    return true;
                } 
            }
        }
        return false;
    }

    public static boolean advancedfindSum(int[] A, int x) {
        int remnant = x - A[0];
        for (int i = 0; i < A.length; i++) {
            if (A[i] == remnant) {
                return true;
            }
        }
        return false;
    }

    public static Set<Integer> union(int[] A, int[] B) {
        Set<Integer> C = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            C.add(A[i]);
        }
        for (int j = 0; j < B.length; j++) {
            if (!C.contains(B[j])) {
                C.add(B[j]);
            } else {
                intersect.add(B[j]);
            }
        }
        return C;
    }
}

public class disc02 {
    public static IntList square(IntList L) {
        if (L == null) {
            return null;
        } else {
            return new IntList(L.first * L.first, square(L.rest));
        }
    }

    public static IntList squareiter(IntList L) {
        IntList p = new IntList();
        while (L != null) {
            p.rest = new IntList(L.first * L.first, null);
            L = L.rest;
        }
        return p.rest;
    }

    public static IntList squareMutative(IntList L) {
        IntList p = L;
        while (p != null) {
            p.first = p.first * p.first;
            p = p.rest;
        }
        return L;
    }

    public static void squareMutativerecur(IntList L) {
        if (L == null) {
        } else {
            L.first = L.first * L.first;
            squareMutativerecur(L.rest);
        }
    }
}

class IntList {
    public int first;
    public IntList rest;        

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public IntList() {
        first = 0;
        rest = null;
    }
}
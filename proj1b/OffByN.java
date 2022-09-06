package proj1b;

public class OffByN implements CharacterComparator {

    private int set;

    public OffByN(int N) {
        set = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == set;
    }
}

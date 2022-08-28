public class OffByN implements CharacterComparator{

    private int set;

    public OffByN(int N) {
        set = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return x == (char) ((int) y + set) || x == (char) ((int) y - set);
    }
}

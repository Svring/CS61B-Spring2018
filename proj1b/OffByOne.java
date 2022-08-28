public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y) {
        return x == (char) ((int) y + 1) || x == (char) ((int) y - 1);
    }
}

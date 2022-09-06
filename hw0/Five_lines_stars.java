package hw0;

public class Five_lines_stars {
    public static void main(String[] args) {
        int i = 1;
        while (i < 6) {
            int j = i;
            while (j > 0) {
                System.out.print('*');
                j = j - 1;
            }
            System.out.print("\n");
            i = i + 1;
        }
    }
}

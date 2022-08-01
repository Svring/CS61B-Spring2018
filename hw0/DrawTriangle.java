public class DrawTriangle {

    public static void drawTriangle(int N) {
        int i = 1;
        while (i < N + 1) {
            int j = i;
            while (j > 0) {
                System.out.print('*');
                j = j - 1;
            }
            System.out.print("\n");
            i = i + 1;
        }
    }

    public static void main(String[] args) {
        int N = 10;
        drawTriangle(N);
    }
}

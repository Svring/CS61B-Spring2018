import static org.junit.Assert.*;
import org.junit.Test;

/* The only thing could put you down is THE AMOUNT OF DATA */
public class TestArrayDequeGold {
    @Test
    public void test() {
        StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> exp = new ArrayDequeSolution<>();
        ArrayDequeSolution<String> messageBox = new ArrayDequeSolution<>();
        String message;
        for (int i = 0; i < 1000; i++) {
            double factor = StdRandom.uniform();
            if (factor < 0.25) {
                message = "addFirst" + "(" + i + ")";
                stu.addFirst(i);
                exp.addFirst(i);
            } else if (factor >= 0.25 && factor < 0.5) {
                message = "addLast" + "(" + i + ")";
                stu.addLast(i);
                exp.addLast(i);
            } else if (factor >= 0.5 && factor <0.75) {
                if (stu.isEmpty() || exp.isEmpty()) {
                    continue;
                }
                message = "removeFirst()";
                Integer actual = stu.removeFirst();
                Integer expect = exp.removeFirst();
                assertEquals(ErrorMessage(messageBox, message), expect, actual);
            } else {
                if (stu.isEmpty() || exp.isEmpty()) {
                    continue;
                }
                message = "removeLast()";
                Integer actual = stu.removeLast();
                Integer expect = exp.removeLast();
                assertEquals(ErrorMessage(messageBox, message), expect, actual);
            }
            messageBox.addLast(message);
            if (messageBox.size() > 2) {
                messageBox.removeFirst();
            }
        }
    }

    private String ErrorMessage(ArrayDequeSolution<String> mb, String m) {
        String message = "";
        for (int i = 0; i < mb.size(); i++) {
            message += mb.getFirst() + "\n";
        }
        message += m;
        return message;
    }

    public static void main(String[] args) {
        TestArrayDequeGold l = new TestArrayDequeGold();
        l.test();
    }
}

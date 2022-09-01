import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void test() {
        StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> exp = new ArrayDequeSolution<>();
        for (int i = 0; i < 10; i++) {
            double factor = StdRandom.uniform();
            if (factor < 0.25) {
                stu.addFirst(i);
                exp.addFirst(i);
            } else if (factor >= 0.25 && factor < 0.5) {
                stu.addLast(i);
                exp.addLast(i);
            } else if (factor >= 0.5 && factor <0.75) {
                if (stu.isEmpty() || exp.isEmpty()) {
                    continue;
                }
                Integer actual = stu.removeFirst();
                Integer expect = exp.removeFirst();
                assertEquals(expect, actual);
            } else {
                if (stu.isEmpty() || exp.isEmpty()) {
                    continue;
                }
                Integer actual = stu.removeLast();
                Integer expect = exp.removeLast();
                assertEquals(expect, actual);
            }
            /*
            assertEquals(exp.size(), stu.size());
            for (int j = 0; j < stu.size(); j++) {
                Integer expect = exp.get(j);
                Integer actual = stu.get(j);
                assertEquals(expect, actual);
            }
            */
        }
    }

    public static void main(String[] args) {

    }
}

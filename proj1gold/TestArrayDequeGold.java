import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void test() {
        StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
        ArrayDeque<Integer> exp = new ArrayDeque<>();
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
                stu.removeFirst();
                exp.removeFirst();
            } else {
                if (stu.isEmpty() || exp.isEmpty()) {
                    continue;
                }
                stu.removeLast();
                exp.removeLast();
            }
            assertEquals(exp.size(), stu.size());
            for (int j = 0; j < stu.size(); j++) {
                assertEquals(exp.get(j), stu.get(j));
            }
        }
    }
}

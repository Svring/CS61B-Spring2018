package disc06;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class exercise8 {
    private class Stack<Item> {
        private List<Item> l = new LinkedList<>();
        public void push(Item x) {
            l.add(x);
        }
    }
}

package disc05;

import java.util.Stack;

public class disc05 {

    public class Queue<T> {

        Stack<T> in = new Stack<>();
        Stack<T> out = new Stack<>();

        public void push(T item) {
            check();
            in.push(item);
        }

        public T pop() {
            check();
            return out.pop();
        }

        private void check() {
            if (in.isEmpty()) {
                while (! out.isEmpty()) {
                    in.push(out.pop());
                }
            } else if (out.isEmpty()) {
                while (! in.isEmpty()) {
                    out.push(in.pop());
                }
            }
        }
    }
}

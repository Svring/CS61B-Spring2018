package disc06;

public class BadIntegerStack {
    private class Node {
        public Integer value;
        public Node prev;

        public Node(Integer v, Node p) {
            value = v;
            prev = p;
        }
    }

    private Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(Integer num) {
        top = new Node(num, top);
    }

    public Integer pop() {
        Integer ans = top.value;
        top = top.prev;
        return ans;
    }

    public Integer peek() {
        return top.value;
    }

    public static void main(String[] args) {
        /* 
        try {
            BadIntegerStack stack = new BadIntegerStack();
            stack.pop();
        } catch (NullPointerException e) {
            System.out.println("Success!");
        }
         */

        /* BadIntegerStack stack = new BadIntegerStack();
        stack.push(1);
        stack.top.prev = stack.top;
        while (!stack.isEmpty()) {
            stack.pop();
        } */
    }
}

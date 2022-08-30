import java.util.*;

public class examprep5 {

    public boolean twoSum(int[] A, int k) {
        Set<Integer> prevSeen = new HashSet<>();
        for (int i : A) {
            if (prevSeen.contains(k - i)) {
                return true;
            }
            prevSeen.add(i);
        }
        return false;
    }

    public static void topFivePopularWords(String[] words, int k) {
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            if (!counts.containsKey(word)) {
                counts.put(word, 1);
            } else {
                counts.put(word, counts.get(word) + 1);
            }
        }
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return counts.get(b) - counts.get(a);
            }
        });
        for (String word : counts.keySet()) {
            pq.add(word);
        }
        for (int i = 0; i < k; i++) {
            System.out.println(pq.poll());
        }
    }

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

    /* This method work incorrectly on my laptop, yet this is not my fault */
    /* 
    public class SortedStack<T> implements Comparable<T>{

        private Stack<T> a;
        private Stack<T> b;

        public SortedStack() {
            a = new Stack<>();
            b = new Stack<>();
        }

        @Override
        public int compareTo(T t) {
            return 0;
        }

        public void push(T t) {
            while (!a.empty() && a.peek().compareTo(t) < 0) {
                b.push(a.pop());
            }
            a.push(t);
            while (!b.empty()) {
                a.push(b.pop());
            }
        }

        public T pop() {
            return a.pop();
        }
    }
    */
}

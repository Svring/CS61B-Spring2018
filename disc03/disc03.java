public class disc03 {
    @SuppressWarnings("unused")
    private class SLList {
        public class IntNode {
            public int item;
            public IntNode next;
            public IntNode(int item, IntNode next) {
                this.item = item;
                this.next = next;
            }
        }

        private IntNode first;

        public void addFirst(int x) {
            first = new IntNode(x, first);
        }

        public void insert(int item, int pos) {
            IntNode p = this.first;
            while (pos > 1) {
                if (p.next == null) {
                    p.next = new IntNode(item, null);
                    return;
                } else {
                    p = p.next;
                    pos--;
                }
            }
            p.next = new IntNode(item, p.next);
        }

        public void reverse() {
            IntNode front = null;
            IntNode current = first;
            while (current != null) {
                IntNode remind = current.next;
                current.next = front;
                front = current;
                current = remind;
            }
            first = front;
        }

        public void reverserecur() {
            first = reverserecursion(first);
        }

        public IntNode reverserecursion(IntNode front) {
            if (front == null || front.next == null) {
                return front;
            } else {
                IntNode reversed = reverserecursion(front.next);
                front.next.next = front;
                front.next = null;
                return reversed;
            }
        }

        public static int[] insert(int[] arr, int item, int position) {
            int[] a = new int[arr.length + 1];
            if (position >= arr.length) {
                System.arraycopy(arr, 0, a, 0, arr.length);
                a[arr.length] = item;
            } else {
                System.arraycopy(arr, 0, a, 0, position);
                a[position] = item;
                System.arraycopy(arr, position, a, position + 1, arr.length - position);
            }
            return a;
        }

        public static void reverse(int[] arr) {
            for (int i = 0; i <= (arr.length / 2); i++) {
                int tmp = arr[i];
                arr[i] = arr[arr.length - i - 1];
                arr[arr.length - i - 1] = tmp;
            }
        }

        public static int[] replicate(int[] arr) {
            int sum = 0, index = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }

            int[] a = new int[sum];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[index]; j++) {
                    a[index] = arr[i];
                    index++;
                }
            }
            return a;
        }

    }
}
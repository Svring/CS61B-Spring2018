public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> que = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            que.addLast(word.charAt(i));
        }
        return que;
    }

    public boolean isPalindrome(String word) {
        return word.equals(helper(wordToDeque(word)));
    }
    /* just like good old days with scheme */

    private String helper(Deque<Character> que) {
        if (que.isEmpty()) {
            return "";
        } else {
            return que.removeLast() + helper(que);
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        for (int i = 0; i < (word.length() - 1) / 2; i++) {
            if (cc.equalChars(word.charAt(i), word.charAt(word.length() - i - 1))) {
                continue;
            }
            return false;
        }
        return true;
    }
}

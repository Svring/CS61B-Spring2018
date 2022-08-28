import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque<Character> d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        String puppet0 = "horse";
        String puppet1 = "roaeaor";
        String puppet2 = "L";
        String puppet3 = "Roaeaor";
        String puppet4 = "";
        assertFalse(palindrome.isPalindrome(puppet0));
        assertTrue(palindrome.isPalindrome(puppet1));
        assertTrue(palindrome.isPalindrome(puppet2));
        assertFalse(palindrome.isPalindrome(puppet3));
        assertTrue(palindrome.isPalindrome(puppet4));
    }

    @Test
    public void testnewisPalindrome() {
        CharacterComparator ob = new OffByOne();
        String puppet0 = "flake";
        String puppet1 = "word";
        String puppet2 = "L";
        String puppet3 = "";
        assertTrue(palindrome.isPalindrome(puppet0, ob));
        assertFalse(palindrome.isPalindrome(puppet1, ob));
        assertTrue(palindrome.isPalindrome(puppet2, ob));
        assertTrue(palindrome.isPalindrome(puppet3, ob));
    }
}

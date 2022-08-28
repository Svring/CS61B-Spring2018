import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testequalChars() {
        char puppet0 = 'a';
        char puppet1 = 'b';
        char puppet2 = 'c';
        assertFalse(offByOne.equalChars(puppet0, puppet0));
        assertTrue(offByOne.equalChars(puppet0, puppet1));
        assertFalse(offByOne.equalChars(puppet0, puppet2));
        assertTrue(offByOne.equalChars(puppet2, puppet1));
    }
}

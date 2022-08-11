public class TestSort {
    public static void testFindSmallest() {
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;
    
        int actual = Sort.findSmallest(input);
        org.junit.Assert.assertEquals(expected, actual);        
    
        String[] input2 = {"there", "are", "many", "pigs"};
        int expected2 = 1;
    
        int actual2 = Sort.findSmallest(input2);
        org.junit.Assert.assertEquals(expected2, actual2);
    }

    public static void main(String[] args) {
        testFindSmallest(); // note: we changed this from testSort!
    }
}
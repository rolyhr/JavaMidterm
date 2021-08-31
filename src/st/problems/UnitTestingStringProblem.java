package st.problems;

import org.testng.Assert;

import java.util.Map;

public class UnitTestingStringProblem {

    public static void main(String[] args) {
        UnitTestingStringProblem unitTest = new UnitTestingStringProblem();

        unitTest.testAnagram();
        unitTest.testDetermineLargestWord();
        unitTest.testIsPalindrome();
    }

    public void testAnagram() {
        boolean actualResult = Anagram.isAnagram("cat", "aCt");
        boolean expectedResult = true;
        Assert.assertEquals(actualResult, expectedResult, "Failed - testAnagram");
    }

    public void testDetermineLargestWord() {
        String s = "Human brain is a biological learning machine";

        Map<Integer, String> actualResult = DetermineLargestWord.findTheLargestWord(s);
        String expectedResult = "10 biological";
        Assert.assertEquals(actualResult, expectedResult, "Failed - testDetermineLargestWord");
    }

    public void testIsPalindrome() {
        String s = "Hannah";

        String actualResult = Palindrome.isPalindrome(s);
        String expectedResult = "Mom is a palindrome";
        Assert.assertEquals(actualResult, expectedResult, "Failed - testIsPalindrome");
    }


}

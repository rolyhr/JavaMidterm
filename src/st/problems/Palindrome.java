package st.problems;

public class Palindrome {

    public static void main(String[] args) {
        /*
          If a String is reversed and it remains unchanged, that is called a palindrome.
            Example: MOM, DAD, MADAM are palindromes.

            Write a method to check if a given String is a palindrome or not.
         */

        System.out.println(isPalindrome("Mom"));

    }

    public static String isPalindrome(String text) {
        String lowerCase = text.toLowerCase();
        int forward = 0;
        int backward = lowerCase.length() - 1;
        while (backward > forward) {
            char forwardChar = lowerCase.charAt(forward++);
            char backwardChar = lowerCase.charAt(backward--);
            if (forwardChar != backwardChar)
                return text = text + " is not a palindrome";
        }
        return text = text + " is a palindrome";
    }
}

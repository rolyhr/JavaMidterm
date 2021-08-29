package string.problems;

import java.util.Arrays;

public class Anagram {

    /*
    Write a Java Program to check if two Strings are Anagrams.
        Two String are called Anagrams when both Strings use the same characters but in different order.
        Example: "CAT" and "ACT", "ARMY" and "MARY", "FART" and "RAFT"
    */

    public static void main(String[] args) {
        System.out.println(isAnagram("cat", "aCt"));
        isAnagram2("Debit Card", "Bad Credit");
    }

    //This method can only track 26 characters of the alphabet
    //Used ASCII values
    public static boolean isAnagram(String a, String b) {
        int a_length = a.length();
        int b_length = b.length();

        if (a_length != b_length) {
            return false;
        }

        a = a.toLowerCase();
        b = b.toLowerCase();

        int[] char_frequencies = new int[26];

        for (int i = 0; i < a_length; i++) {
            char current_char = a.charAt(i);
            int index = current_char-'a';
            char_frequencies[index]++;
        }

        for (int i = 0; i < b_length; i++) {
            char current_char = b.charAt(i);
            int index = current_char-'a';
            char_frequencies[index]--;
        }

        for (int i = 0; i < 26; i++) {
            if (char_frequencies[i] != 0) {
                return false;
            }
        }
        return true;
    }

    //This method can track 26 characters of the alphabet including any spaces
    static void isAnagram2(String str1, String str2) {
        String s1 = str1.replaceAll("\\s", "");
        String s2 = str2.replaceAll("\\s", "");
        boolean status = true;
        if (s1.length() != s2.length()) {
            status = false;
        } else {
            char[] ArrayS1 = s1.toLowerCase().toCharArray();
            char[] ArrayS2 = s2.toLowerCase().toCharArray();
            Arrays.sort(ArrayS1);
            Arrays.sort(ArrayS2);
            status = Arrays.equals(ArrayS1, ArrayS2);
        }
        if (status) {
            System.out.println("Is Anagram");
        } else {
            System.out.println("Not Anagram");
        }
    }
}

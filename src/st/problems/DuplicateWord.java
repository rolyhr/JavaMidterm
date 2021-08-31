package st.problems;

import java.util.Locale;
import java.util.Objects;

public class DuplicateWord {

    public static void main(String[] args) {

        /*
         Write a java program to find the duplicate words and their number of occurrences in the string.
            Also Find the average length of the words.
         */

        String st = "Java is a programming Language Java is also an Island of Indonesia. Java is widely used language";

        findDuplicateWords(st);
    }

    public static void findDuplicateWords(String str) {
        int count;
        String duplicates = "";
        String[] lcWords = str.toLowerCase().trim().split("\\s");
        for(int i = 0; i < lcWords.length; i++) {
            count = 1;
            for (int j = i + 1; j < lcWords.length; j++) {
                if (lcWords[i].equals(lcWords[j])) {
                    count++;
                    lcWords[j] = "0";
                }
            }
            if(count > 1 && !lcWords[i].equals("0"))
                System.out.println(lcWords[i]);
        }
    }

}

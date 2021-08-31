package string.problems;

import java.util.Locale;
import java.util.Objects;

public class DuplicateWord {

    public static void main(String[] args) {

        /*
         Write a java program to find the duplicate words and their number of occurrences in the string.
            Also Find the average length of the words.
         */

//        String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";
//        st = st.toLowerCase(Locale.ROOT);
//        String[] lowerCaseWords = st.split("\\s");
//
//        int count = 0;
//        for (int i = 0; i < lowerCaseWords.length; i++) {
//            count = 1;
//            for (int j = i+1; j < lowerCaseWords.length; j++) {
//                if (lowerCaseWords[i].equals(lowerCaseWords[j])) {
//                    count++;
//                    lowerCaseWords[j] = "0";
//                }
//            }
//            if(count > 1 && lowerCaseWords[i] != "0")
//                System.out.println(lowerCaseWords[i]);
//            System.out.println(count);
//        }



        String string = "Big black bug bit a big black dog on his big black nose";
        int count;

        //Converts the string into lowercase
        string = string.toLowerCase();

        //Split the string into words using built-in function
        String[] words = string.split(" ");

        System.out.println("Duplicate words in a given string : ");
        for(int i = 0; i < words.length; i++) {
            count = 1;
            for(int j = i+1; j < words.length; j++) {
                if(words[i].equals(words[j])) {
                    count++;
                    //Set words[j] to 0 to avoid printing visited word
                    words[j] = "0";
                }
            }

            //Displays the duplicate word if count is greater than 1
            if(count > 1 && !Objects.equals(words[i], "0"))
                System.out.println(words[i]);
        }



//        for (int i = 0; i < words.length; i++) {
//            if (words[i].length() > maxLength) {
//                maxLength = words[i].length();
//                st = words[i];
//            }
//        }

    }

}

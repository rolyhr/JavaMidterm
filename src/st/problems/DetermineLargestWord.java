package string.problems;

import java.util.HashMap;
import java.util.Map;

public class DetermineLargestWord {

    public static void main(String[] args) {
        /*
         Implement to Find the length and longest word in the given sentence below
         Should return "10 biological"
         */
        String s = "Human brain is a biological learning machine";
        Map<Integer, String> wordNLength = findTheLargestWord(s);


    }

    public static Map<Integer, String> findTheLargestWord(String wordGiven) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        String st = "";

        String[] words = wordGiven.split("\\s");
        for (int i = 0; i < words.length; i++){
            map.put(i+1, words[i]);
        }

        int maxLength = 0;
        for (Map.Entry<Integer, String> x : map.entrySet()) {
            if (x.getValue().length() > maxLength) {
                maxLength = x.getValue().length();
                st = x.getValue();
            }
        }

        System.out.println(maxLength + " " + st);

        return map;
    }
}

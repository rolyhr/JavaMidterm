package datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UseMap {

    public static void main(String[] args) {
        /*
         * Demonstrate how to use Map that includes storing and retrieving elements.
         * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
         * Use For-Each loop and While-loop with Iterator to retrieve data.
         *
         * Store and retrieve data from/to a database table.
         */

        Map<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> team1 = new ArrayList<>();
        team1.add("Roly");
        team1.add("Sousanna");
        team1.add("Anjuman");
        team1.add("Mona");
        team1.add("Dihia");
        team1.add("Pushpo");
        team1.add("Farah");
        map.put(1, team1);

        ArrayList<String> team2 = new ArrayList<>();
        team2.add("Asjad");
        team2.add("Taqiyy");
        team2.add("Lamia");
        team2.add("Rabiul");
        team2.add("Abdus");
        team2.add("Aissam");
        team2.add("Taha");
        team2.add("Solomon");
        team2.add("Mohammad");
        map.put(2, team2);

        ArrayList<String> team3 = new ArrayList<>();
        team3.add("Rabai");
        team3.add("Salma");
        team3.add("Farida");
        team3.add("Tanveer");
        team3.add("Fateh");
        team3.add("Bilal");
        team3.add("Syeda");
        team3.add("Houria");
        team3.add("Mohammad");
        map.put(3, team3);

        //Print all members in HashMap using enhanced for loop
        for (Map.Entry<Integer, ArrayList<String>> kv : map.entrySet()) {
            System.out.print("Team " + kv.getKey() + "\t");
            System.out.println(kv.getValue());
        }

        //Checks if specified key exists in a Map
        System.out.println(map.containsKey(3));

        //Get the size of the map
        System.out.println("Size of the map: " + map.size());

        //Remove specified member in a map
        map.remove(2);
        System.out.println("Updated size of the map after remove one member: " + map.size());
        //Then print the updated list in the map
        for (Map.Entry<Integer, ArrayList<String>> kv : map.entrySet()) {
            System.out.print("Team " + kv.getKey() + "\t");
            System.out.println(kv.getValue());
        }

    }

}

package datastructure;

import java.util.HashMap;
import java.util.Map;

public class CollectionView {

    public static void main(String[] args) {
        /*
         Map is created and some data is inserted into it.
         Retrieve the Collection view of the values present in map
         */

        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "NYC");
        map.put(2, "LA");
        map.put(3, "Denver");
        map.put(4, "Boston");
        map.put(5, "San Jose");
        map.put(6, "Seattle");

        //This FOR LOOP will print the key & value from map collection in organized format.
        System.out.println("KEY" + "\t\t" + "VALUE");
        for (Map.Entry<Integer, String> kv : map.entrySet()) {
            System.out.print(kv.getKey() + "\t\t");
            System.out.println(kv.getValue());
        }

    }

}

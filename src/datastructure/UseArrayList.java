package datastructure;

import java.util.ArrayList;
import java.util.List;

public class UseArrayList {

    public static void main(String[] args) {
        /*
         * Demonstrate how to use ArrayList that includes using the add, peek, remove & retrieve methods.
         * Use For-Each loop and While-loop with Iterator to retrieve data.
         *
         * Store and retrieve data from/to a database table.
         */

        List<Integer> arrayList = new ArrayList<>();

        arrayList.add(5);
        arrayList.add(10);
        arrayList.add(15);
        arrayList.add(20);
        arrayList.add(25);

        //Prints the entire arrayList
        System.out.println(arrayList);

        //Used enhanced for loop to print each element of the array list
        for (Integer x : arrayList) {
            System.out.println(x);
        }

        //View the element at specified index
        System.out.println("Element at Index 4: " + arrayList.get(4));

        //Removes an element from specified index
        arrayList.remove(2);
        System.out.println(arrayList);

        //Print the updated size of the arrayList
        System.out.println(arrayList.size());


    }

}

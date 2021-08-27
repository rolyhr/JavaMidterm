package datastructure;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class UseQueue {

    public static void main(String[] args) {
        /*
         * Demonstrate how to use Queue that includes add, peek, remove & poll elements.
         * Use For-Each loop and While-Loop with Iterator to retrieve data.
         *
         * Store and retrieve data from/to a database table.
         */

        Queue<String> queue = new LinkedList<>();

        queue.add("Pagani Huayra");
        queue.add("Porsche 911 Turbo S");
        queue.add("BMW M3");
        queue.add("Ford Mustang Shelby GT500");
        queue.add("Chevy Corvette ZR1");

        //Check the list
        for (String car : queue) {
            System.out.println(car);
        }

        System.out.println("*********************");
        //Removes the head of queue
        queue.remove();

        //Add tesla at the back of the queue
        queue.add("Tesla Model S");

        //Check the list
        for (String car : queue) {
            System.out.println(car);
        }
        System.out.println("*********************");
        //Check the element at the head of the queue
        System.out.println("Head of the queue: " + queue.peek());

        System.out.println("*********************");
        //Checks if the element exist in the queue
        System.out.println(queue.contains("BMW M3"));



    }

}

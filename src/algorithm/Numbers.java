package algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import databases.ConnectToSqlDB;

public class Numbers {

    /*
     Show all the different kind of sorting algorithm by applying into (num array).
     Display the execution time for each sorting.Example in below.

     Use any databases[MongoDB, Oracle or MySql] to store data and retrieve data.

     At the end. After running all the sorting algo, come to a conclusion which one is suitable on given data set.
     */

    public static void main(String[] args) throws Exception {

        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();

        int[] num = new int[100000];
        storeRandomNumbers(num);
        Sort algo = new Sort();

        connectToSqlDB.insertDataFromArrayToSqlTable(num, "selection_sort", "SortingNumbers");
        List<String> numbers = connectToSqlDB.readDataBase("selection_sort", "SortingNumbers");
        printValue(numbers);

        int n = num.length;
        randomize(num, n);

        //Selection Sort
        algo.selectionSort(num);
        double selectionSortExecutionTime = algo.executionTime;
        System.out.println("Total Execution Time of " + num.length + " numbers in Selection Sort took: "
                + selectionSortExecutionTime + " seconds");

        // Insertion Sort
        algo.insertionSort(num);
        double insertionSortExecutionTime = algo.executionTime;
        System.out.println("Total Execution Time of " + num.length + " numbers in Insertion Sort took: "
                + insertionSortExecutionTime + " seconds");

        //Bubble Sort
        algo.bubbleSort(num);
        double bubbleSortExecutionTime = algo.executionTime;
        System.out.println("Total Execution Time of " + num.length + " numbers in Bubble Sort took: "
                + insertionSortExecutionTime + " seconds");

        //Merge Sort
        algo.mergeSort(num, num[0], num.length-1);
        double mergeSortExecutionTime = algo.executionTime;
        System.out.println("Total Execution Time of " + num.length + " numbers in Bubble Sort took: "
                + insertionSortExecutionTime + " seconds");


        /*
        Can you come to conclusion about which sorting algorithm is most efficient, given the size of the data set?

        Time stamps to sort 10,000 numbers:
        9.561 seconds to sort using SelectionSort
        0.003 seconds to sort using InsertionSort
        2.655 seconds to sort using BubbleSort
        0.000 seconds to sort using MergeSort

        Out of these four types of sort, Merge sort would be the quickest.
        */
    }

    /*
    HELPER METHODS
     */
    public static void storeRandomNumbers(int[] num) {
        Random rand = new Random();
        for (int i = 0; i < num.length; i++) {
            num[i] = rand.nextInt(100);
        }
    }

    public static void randomize(int[] arr, int n) {
        Random r = new Random();
        // Start from the last element and swap one by one. We don't
        // need to run for the first element that's why i > 0
        for (int i = n - 1; i > 0; i--) {
            int j = r.nextInt(i);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void printValue(List<String> array) {
        for (String st : array) {
            System.out.println(st);
        }
    }
}

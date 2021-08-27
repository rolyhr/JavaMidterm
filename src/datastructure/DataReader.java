package datastructure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {

    String systemPath = System.getProperty("user.dir");
    String relativePath = "\\src\\data\\self-driving-car.txt";
    String path = systemPath + relativePath;
    FileReader fileReader;
    BufferedReader bufferedReader;

    public static void main(String[] args) {
        /*
         * Create an API to read the below textFile and print it to the console.
         *      HINT: Use BufferedReader class
         * Use try-catch block to handle Exceptions
         *
         * Store and retrieve the file to/from a database table.
         *
         * After reading from file using BufferedReader API, store each word into Stack and LinkedList. So each word
         * should construct a node in LinkedList.Then iterate/traverse through the list to retrieve as FIFO
         * order from LinkedList and retrieve as FILO order from Stack.
         *
         * Demonstrate how to use Stack using push, peek, search & pop methods.
         * Use For-Each & While-loop with Iterator to retrieve data.
         */

        DataReader dr = new DataReader();
        dr.readFiles();

    }

    //This readFiles() method will read any text file that you specified in the path
    void readFiles() {
        String data;
        try {
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
        } catch (IOException e) {
            System.out.println("Unable to find file path!");
        }

        try {
            while ((data = bufferedReader.readLine()) != null) {
                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

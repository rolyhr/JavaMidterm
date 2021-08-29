package datastructure;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UseArrayList {

    public static void main(String[] args) throws SQLException {
        /*
         * Demonstrate how to use ArrayList that includes using the add, peek, remove & retrieve methods.
         * Use For-Each loop and While-loop with Iterator to retrieve data.
         *
         * Store and retrieve data from/to a database table.
         */

        //Created an ArrayList
        List<String> arrayList = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //Get a connection to database
            connection = DriverManager.getConnection("jdbc:mysql://localhost/test_schema_1?serverTimezone=UTC&useSSL=false",
                                                    "root" ,
                                                "tesT210?");
            //Create a statement
            statement = connection.createStatement();
            //Executing the query
            resultSet = statement.executeQuery("SELECT * FROM `test_schema_1`.`students`");
            //Getting the result from SQL server
            while (resultSet.next()) {
                arrayList.add(resultSet.getString("firstName"));
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            //Closing all the open connection
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        //Prints the initial size of the arrayList
        System.out.println("Initial size of the array: " + arrayList.size());

        //Prints the entire arrayList
        System.out.println(arrayList);

        //Used enhanced for loop to print each element of the array list
        for (String x : arrayList) {
            System.out.println(x);
        }

        //View the element at specified index
        System.out.println("Element at Index 1: " + arrayList.get(1));

        //Removes an element from specified index
        arrayList.remove(0);
        System.out.println(arrayList);

        //Print the updated size of the arrayList
        System.out.println("Updated size of the array: " + arrayList.size());
    }
}

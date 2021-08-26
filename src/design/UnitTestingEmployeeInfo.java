package design;

import org.testng.Assert;

public class UnitTestingEmployeeInfo {

    public static void main(String[] args) {
        // Use this class to write unit tests for all user-defined methods that you have implemented in this package.
        EmployeeInfo unitTest = new EmployeeInfo();

        //Testing employeeID() method from EmployeeInfo.java
        System.out.println(unitTest.employeeId());
    }
}

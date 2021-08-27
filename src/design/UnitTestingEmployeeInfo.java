package design;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestingEmployeeInfo {
    // Use this class to write unit tests for all user-defined methods that you have implemented in this package.
    EmployeeInfo empInfo;

    public static void main(String[] args) {
        UnitTestingEmployeeInfo unitTest = new UnitTestingEmployeeInfo();

        unitTest.testCalculateSalary();
        unitTest.testCalculateBonus();
        unitTest.testEmployeeID();
    }

    @Test ////Testing calculateSalary() method from EmployeeInfo.java
    public void testCalculateSalary() {
        empInfo = new EmployeeInfo();
        /*
        TEST DATA
        When prompted, enter the following test data:
        Hours worked last week: 45
        */
        double actualResult = empInfo.calculateSalary(empInfo.getTotalHrsInput());
        double expectedResult = 1959.375;
        Assert.assertEquals(actualResult, expectedResult, "Failed - Calculate Salary");
    }

    @Test //Testing calculateEmployeeBonus() method from EmployeeInfo.java
    public void testCalculateBonus() {
        empInfo = new EmployeeInfo();
        /*
        TEST DATA
        When prompted, enter the following test data:
        Total Yearly Salary: 95000
        Performance Score: 925
        */
        double actualResult = empInfo.calculateEmployeeBonus();
        double expectedResult = 7600;
        Assert.assertEquals(actualResult, expectedResult, "Failed - Calculate Bonus");
    }

    @Test //Testing employeeID() method from EmployeeInfo.java
    public void testEmployeeID() {
        empInfo = new EmployeeInfo();
        double actualResult = empInfo.employeeId();
        double expectedResult = empInfo.employeeID;
        Assert.assertEquals(actualResult, expectedResult, "Failed - Mismatch Employee ID");
    }
}

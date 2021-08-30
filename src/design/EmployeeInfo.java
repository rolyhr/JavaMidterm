package design;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class EmployeeInfo extends EmpData{

    /*
    This class should implement the Employee interface. You can do that by directly implementing it,
    however you must also implement the Employee interface into an abstract class. So create an Abstract
    class then inherit that abstract class into this EmployeeInfo class. Once you're done with designing
    EmployeeInfo class, go to FortuneEmployee class to apply all the fields and attributes.

    Important: YOU MUST USE:
        - OOP (Abstraction, Encapsulation, Inheritance and Polymorphism) concepts in every level possible.
        - Use all kind of keywords (super, this, static, final, etc)
        - Implement nested class below (DateConversion)
        - Use Exception Handling
     */

    /*
     * Make sure to declare and use static, non-static & final fields
     */
    String companyName;
    private String firstName, lastName, deptName, email, password;
    int employeeID;
    private final int HOURLY_RATE = 55;
    Scanner userInput;

    //Format how the $ amount will print out
    String pattern = "###,##0.00";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);

    /*
     You must implement the logic for below 2 methods and
        following 2 methods are prototype as well for other methods need to be design,
        as you will come up with the new ideas.
     */

    /*
     You must have/use multiple constructors
     */
    public EmployeeInfo() {

    }

    public EmployeeInfo(String companyName) {
        this.companyName = companyName;
    }

    public void initialize() {
        userInput = new Scanner(System.in);
        System.out.println("Welcome to " + companyName + "!");
        System.out.println("\tOption 1: Create New Employee Email");
        System.out.println("\tOption 2: Calculate Weekly Salary");
        System.out.println("\tOption 3: Check Yearly Bonus");
        System.out.println("\tOption 4: Check Total Pension");
        System.out.print("Make a selection from the top menu (i.e. For \"Option 2\", enter only \"2\"): ");
        int selection = userInput.nextInt();

        switch (selection) {
            case 1:
                generateEmail();
                initialize();
                break;
            case 2:
                System.out.println(firstName + " " + lastName + "'s " + "weekly salary is: " + decimalFormat.format(calculateSalary(getTotalHrsInput())));
                initialize();
                break;
            case 3:
                System.out.println(firstName + " " + lastName + "'s " + "yearly bonus is: " + decimalFormat.format(calculateEmployeeBonus()));
                initialize();
            case 4:
                System.out.println(firstName + " " + lastName + "'s " + "total pension is: " + decimalFormat.format(calculateEmployeePension()));
                initialize();
            default:
                System.out.println("INVALID SELECTION!");
                initialize();
        }
    }

    public void generateEmail() {
        employeeName();
        assignDepartment();
        employeeId();
        formatEmail();
        System.out.println("Email created for: " + firstName + " " + lastName +
                           "\n" + "Your Email is: " + email);
        generatePassword();
        System.out.println("Your default password is: " + password);
        System.out.println("Your Employee ID: " + employeeID);
    }

    /*
      You need to implement the logic of this method as such:
           It should calculate Employee bonus based on salary and performance.
           It should return the total yearly bonus.
      Example: 10% of salary for best performance, 8% of salary for average performance and so on.
      You can set arbitrary number for performance, so you probably need to send 2 arguments.
     */
    public double calculateEmployeeBonus() {
        userInput = new Scanner(System.in);
        double bonus = 0;

        System.out.print("Enter " + firstName + " " + lastName + "'s " + "total yearly salary: ");
        double yearlySalary = userInput.nextDouble();
        System.out.print("Enter " + firstName + " " + lastName + "'s " + "performance score: ");
        int performanceScore = userInput.nextInt();

        if (performanceScore >= 850 && yearlySalary >= 125000) {
            return bonus = (yearlySalary * 10) * 0.01;
        } else if (performanceScore >= 700 && yearlySalary >= 85000) {
            return bonus = (yearlySalary * 8) * 0.01;
        } else if (performanceScore >= 500 && yearlySalary >= 70000) {
            return bonus = (yearlySalary * 5) * 0.01;
        } else {
            return bonus = (yearlySalary * 1) * 0.01;
        }
    }

    /*
     You need to implement the logic of this method as such:
        It should calculate Employee pension based on salary and numbers of years with the company.
        It should return the total pension amount.
            Example: Employee will receive 5% of salary as pension for every year they are with the company
     */
    public double calculateEmployeePension() {
        userInput = new Scanner(System.in);
        System.out.print("Enter " + firstName + ", " + lastName + "'s " + " salary: ");
        int salary = userInput.nextInt();
        System.out.print("Enter start date in format (example: May,2015): ");
        String joiningDate = userInput.nextLine();
        System.out.print("Enter today's date in format (example: August,2017): ");
        String todaysDate = userInput.nextLine();
        String convertedJoiningDate = DateConversion.convertDate(joiningDate);
        String convertedTodaysDate = DateConversion.convertDate(todaysDate);

        // Figure out how to extract the number of years the employee has been with the company, using the above 2 dates
        int totalNumOfYears = Integer.parseInt(convertedTodaysDate.substring(convertedTodaysDate.length() - 4)) -
                              Integer.parseInt(convertedJoiningDate.substring(convertedJoiningDate.length() - 4));

        // Calculate pension
        double yearlyPension = (salary * 5) * 0.01;

        //return total;
        return yearlyPension * totalNumOfYears;
    }

    //generate a new employee ID & store the new id to employeeID global variable
    @Override
    public int employeeId() {
        int upperBound = 999999;
        int lowerBound = 100000;
        return this.employeeID = lowerBound + (int)(Math.random() * ((upperBound - lowerBound) + 1));
    }

    //Gather first & last name then initialize value to the global variables
    @Override
    public void employeeName() {
        userInput = new Scanner(System.in);
        System.out.print("Enter first name: ");
        this.firstName = userInput.nextLine();

        System.out.print("Enter last name: ");
        this.lastName = userInput.nextLine();
    }

    //Gather department name then initialize value to the global variables
    @Override
    public void assignDepartment() {
        userInput = new Scanner(System.in);
        System.out.print("Enter department name: ");
        this.deptName = userInput.nextLine();
    }

    //Calculate regular salary as well as overtime hours
    @Override
    public double calculateSalary(double totalHrsWorked) {
        double grossEarnings, incomeTax, netEarnings, regularEarnings, overTimeEarnings;
        final int INCOME_TAX_RATE = 25;

        if (totalHrsWorked > 40) {
            //Calculate overtime
            double overTimeHrs = totalHrsWorked - 40;
            regularEarnings = HOURLY_RATE * (totalHrsWorked - overTimeHrs);
            overTimeEarnings = overTimeHrs * (HOURLY_RATE * 1.5);
            grossEarnings = regularEarnings + overTimeEarnings;
            incomeTax = (grossEarnings * INCOME_TAX_RATE) * 0.01;
            netEarnings = grossEarnings - incomeTax;
        } else {
            //Calculate regular hours worked
            grossEarnings = HOURLY_RATE * totalHrsWorked;
            incomeTax = (grossEarnings * INCOME_TAX_RATE) * 0.01;
            netEarnings = grossEarnings - incomeTax;
        }
        return netEarnings;
    }

    //Helper method - Returns an int value that passes into calculateSalary() method as an argument
    public int getTotalHrsInput() {
        userInput = new Scanner(System.in);
        System.out.print("How many hours have you worked last week? ");
        int totalHours = userInput.nextInt();
        while (totalHours <= 0) {
            System.out.println("WARNING! Enter a valid number.");
            System.out.print("How many hours have you worked last week? ");
            totalHours = userInput.nextInt();
        }
        return totalHours;
    }

    @Override
    public void benefitLayout() {

    }

    //Generate a new email based on employee info & department
    @Override
    public void formatEmail() {
        this.email = firstName.toLowerCase(Locale.ROOT)   +
                "."                                       +
                this.lastName.toLowerCase(Locale.ROOT)    +
                "."                                       +
                this.deptName.toLowerCase(Locale.ROOT)    +
                "."                                       +
                "@"                                       +
                this.companyName.toLowerCase(Locale.ROOT) +
                ".com";
    }

    //Generate a random password for the email
    @Override
    public void generatePassword() {
        SecureRandom random = new SecureRandom();
        StringBuilder customString = new StringBuilder();

        final String chars = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789@!$%.&";
        int defaultPasswordLength = 10;

        for (int i = 0; i < defaultPasswordLength; i++) {
            int randomIndex = random.nextInt(chars.length());
            this.password = customString.append(chars.charAt(randomIndex)).toString();
        }
    }

    private static class DateConversion {

        public DateConversion(Months months) {
        }

        public static String convertDate(String date) {
            String[] extractMonth = date.split(",");
            String givenMonth = extractMonth[0];
            int monthDate = whichMonth(givenMonth);
            return monthDate + "/" + extractMonth[1];
        }

        public static int whichMonth(String givenMonth) {
            Months months = Months.valueOf(givenMonth);
            int date = 0;
            switch (months) {
                case January:
                    date = 1;
                    break;
                case February:
                    date = 2;
                    break;
                case March:
                    date = 3;
                    break;
                case April:
                    date = 4;
                    break;
                case May:
                    date = 5;
                    break;
                case June:
                    date = 6;
                    break;
                case July:
                    date = 7;
                    break;
                case August:
                    date = 8;
                    break;
                case September:
                    date = 9;
                    break;
                case October:
                    date = 10;
                    break;
                case November:
                    date = 11;
                    break;
                case December:
                    date = 12;
                    break;
                default:
                    break;
            }
            return date;

        }
    }
}

package math.problems;

public class Factorial {

    /*
     Write a method to return the Factorial of any given number using Recursion as well as Iteration
     Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120
     */

    public static void main(String[] args) {

        System.out.println("Calculated using recursion: " + factorial(5));
        System.out.println("Calculated using iteration: " + iteration(5));
    }

    //This method used recursion to calculate factorial
    public static long factorial(int number) {
        long factorial;
        if (number >= 1) {
            factorial = factorial(number - 1) * number;
            return factorial;
        } else {
            return 1;
        }
    }

    //This method used for loop to iterate through a number to calculate factorial
    public static long iteration(int number) {
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}

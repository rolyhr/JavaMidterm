package math.problems;

public class Factorial {

    /*
     Write a method to return the Factorial of any given number using Recursion as well as Iteration

     Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120
     */

    public static void main(String[] args) {

        System.out.println(factorial(5));
    }

    public static long factorial(int number) {
        if (number >= 1) {
            return factorial(number - 1) * number;
        } else {
            return 1;
        }
    }
}

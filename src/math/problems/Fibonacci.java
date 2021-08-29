package math.problems;

public class Fibonacci {

    /*
    Write a method that will print or return at least 40 Fibonacci numbers

      0,1,1,2,3,5,8,13
     */

    public static void main(String[] args) {

        fibSequence(40);
    }

    public static void fibSequence(int number) {
        /*
        Each number in the sequence is the sum of the two numbers that precede it.
        So, the sequence goes: 0, 1, 1, 2, 3, 5, 8 and so on.
         */
        int previousNum = 0;
        int nextNum = 1;

        System.out.print("Fibonacci Sequence: ");
        for (int i = 1; i <= number; ++i)
        {
            System.out.print(previousNum+" ");

            int sum = previousNum + nextNum; //Storing the sum of previous and next number in "sum" variable.
            previousNum = nextNum; //Whatever value of "nextNum" in this current iteration, storing that value to "previousNum" variable
            nextNum = sum; //Updating value of "nextNum"
            //REPEAT until the iteration complete ("i" is less than or equal to "number")
        }
    }


}

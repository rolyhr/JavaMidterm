package math.problems;

public class FindMissingNumber {

    public static void main(String[] args) {
        /*
         If n = 10, then array will have 9 elements in the range from 1 to 10.
            For example {10, 2, 1, 4, 5, 3, 7, 8, 6}. One number will be missing in array (9 in this case).

         Write a method to find the missing number from the array.
         */
        int[] array = new int[] {10, 2, 1, 4, 5, 3, 7, 8, 6};

        System.out.println(findMissingNum(array));
        System.out.println(findMissingNum2(array, array.length));

    }

    //Method 1
    public static int findMissingNum(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) { //getting index out of bound exception
            if (array[0] + array[i+1] != array[i+2]) {
                temp = (array[0] + array[i+1]);
            }
        }
        return temp;
    }

    //Method 2
    public static int findMissingNum2(int[] array, int length) {
        int missingNum = 1;
        for (int i = 2; i <= (length + 1); i++) {
            missingNum = missingNum + i;
            missingNum = missingNum - array[i - 2];
        }
        return missingNum;
    }
}

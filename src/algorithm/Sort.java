package algorithm;

public class Sort {

    double executionTime = 0;
    /*
     * Please implement all the sorting algorithm. Feel free to add helper methods.
     * Store all the sorted data into one of the databases.
     */

    public static void printSortedArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public int[] selectionSort(int[] array) {
        final long startTime = System.currentTimeMillis();

        for (int j = 0; j < array.length - 1; j++) {
            int min = j;
            for (int i = j + 1; i < array.length; i++) {
                if (array[i] < array[min])
                    min = i;
            }

            int temp = array[min];
            array[min] = array[j];
            array[j] = temp;
        }

        final double endTime = System.currentTimeMillis();
        double totalTime = endTime - startTime;
        this.executionTime = totalTime / 1000; //Converted milliseconds to seconds
        return array;
    }

    public int[] insertionSort(int[] array) {
        final long startTime = System.currentTimeMillis();

        int i, j, key, temp;
        for (i = 1; i < array.length; i++) {
            key = array[i];
            j = i - 1;
            while (j >= 0 && key < array[j]) {
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                j--;
            }
        }
        final double endTime = System.currentTimeMillis();
        double totalTime = endTime - startTime;
        this.executionTime = totalTime / 1000; //Converted milliseconds to seconds
        return array;
    }

    public int[] bubbleSort(int[] array) {
        final long startTime = System.currentTimeMillis();

        int i, j, temp = 0;
        for (i = 0; i < array.length - 1; i++) {
            for (j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        final double endTime = System.currentTimeMillis();
        double totalTime = endTime - startTime;
        this.executionTime = totalTime / 1000; //Converted milliseconds to seconds
        return array;
    }

    public int[] mergeSort (int[] array, int lowIndex, int highIndex) {
        final long startTime = System.currentTimeMillis();

        if (lowIndex == highIndex) {
        }
        else {
            int midIndex = (lowIndex + highIndex) / 2;
            mergeSort(array, lowIndex, midIndex);
            mergeSort(array, midIndex + 1, highIndex);
            merge(array, lowIndex, midIndex, highIndex);
        }
        final double endTime = System.currentTimeMillis();
        double totalTime = endTime - startTime;
        this.executionTime = totalTime / 1000; //Converted milliseconds to seconds
        return array;
    }
    //mergeSort Helper Method
    public void merge(int[] array, int lowIndex, int midIndex, int highIndex) {
        int[] L = new int[midIndex - lowIndex + 2];

        for (int i = lowIndex; i <= midIndex; i++) {
            L[i - lowIndex] = array[i];
        }
        L[midIndex - lowIndex + 1] = Integer.MAX_VALUE;
        int[] R = new int[highIndex - midIndex + 1];

        for (int i = midIndex + 1; i <= highIndex; i++) {
            R[i - midIndex - 1] = array[i];
        }
        R[highIndex - midIndex] = Integer.MAX_VALUE;
        int i = 0, j = 0;

        for (int k = lowIndex; k <= highIndex; k++) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            }
            else {
                array[k] = R[j];
                j++;
            }
        }
    }

    public int[] quickSort(int[] array) {
        int[] list = array;
        //implement here

        return list;
    }

    public int[] heapSort(int[] array) {
        int[] list = array;
        //implement here

        return list;
    }

    public int[] bucketSort(int[] array) {
        int[] list = array;
        //implement here

        return list;
    }

    public int[] shellSort(int[] array) {
        int[] list = array;
        //implement here

        return list;
    }
}

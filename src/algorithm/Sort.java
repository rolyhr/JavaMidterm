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

        int i, j, key, temp; //Declared all the variables are in the loop
        for (i = 1; i < array.length; i++) { //Start the iteration from 1st index to be able to check the item to the left
            key = array[i]; //Assign a key

            j = i - 1; //Decrementing will help to check the item to the left
            while (j >= 0 && key < array[j]) { //Check if the key is less than the item to the left
                temp = array[j]; //Swap
                array[j] = array[j + 1]; //Swap
                array[j + 1] = temp; //Swap
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

        int i, j, temp = 0; //Declared all the variables are in the loop
        for (i = 0; i < array.length - 1; i++) {
            for (j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) { //Checking first item to the adjacent item
                    temp = array[j]; //Swap
                    array[j] = array[j + 1]; //Swap
                    array[j + 1] = temp; //Swap
                }
            }
        }
        final double endTime = System.currentTimeMillis();
        double totalTime = endTime - startTime;
        this.executionTime = totalTime / 1000; //Converted milliseconds to seconds
        return array;
    }

    //Still getting exception on LINE: 84
    //Get stackoverflow error when use the randomizer
    public int[] mergeSort (int[] array, int lowIndex, int highIndex) {
        final long startTime = System.currentTimeMillis();

        int midIndex = 0;
        if (lowIndex < highIndex) {
            midIndex = (lowIndex + highIndex) / 2;
        }

        mergeSort(array, lowIndex, midIndex); //Still getting exception on LINE: 84
        mergeSort(array, midIndex + 1, highIndex);
        merge(array, lowIndex, midIndex, highIndex);

        final double endTime = System.currentTimeMillis();
        double totalTime = endTime - startTime;
        this.executionTime = totalTime / 1000; //Converted milliseconds to seconds
        return array;
    }

    //mergeSort Helper Method
    public void merge(int[] array, int lowIndex, int midIndex, int highIndex) {
        int[] l = new int[midIndex - lowIndex + 2];

        for (int i = lowIndex; i <= midIndex; i++) {
            l[i - lowIndex] = array[i];
        }
        l[midIndex - lowIndex + 1] = Integer.MAX_VALUE;
        int[] r = new int[highIndex - midIndex + 1];

        for (int i = midIndex + 1; i <= highIndex; i++) {
            r[i - midIndex - 1] = array[i];
        }
        r[highIndex - midIndex] = Integer.MAX_VALUE;
        int i = 0, j = 0;

        for (int k = lowIndex; k <= highIndex; k++) {
            if (l[i] <= r[j]) {
                array[k] = l[i];
                i++;
            }
            else {
                array[k] = r[j];
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

    public int[] shellSort(int[] array, int arrayLength) {
        final long startTime = System.currentTimeMillis();

        for (int interval = arrayLength / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < arrayLength; i += 1) {
                int temp = array[i];
                int j;
                for (j = i; j >= interval && array[j - interval] > temp; j -= interval) {
                    array[j] = array[j - interval];
                }
                array[j] = temp;
            }
        }
        final double endTime = System.currentTimeMillis();
        double totalTime = endTime - startTime;
        this.executionTime = totalTime / 1000; //Converted milliseconds to seconds
        return array;
    }
}

package algorithm;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class UnitTestSorting {
    /*
      This class is used to help with unit testing of sorting algorithms from the Sort class
     */

    Sort sort; //Declared variable of type Sort
    int[] unSortedArray = {80, 50, 10, 30, 60, 20, 40};
    int[] sortedArray = {10, 20, 30, 40, 50, 60, 80};

    // Implement Unit test for rest of the sorting algorithms below

    @Test //Testing selectionSort() method from Sort.java
    public void testSelectionSort() {
        // Create instance of Sort class
        sort = new Sort();

        int[] actualResult = sort.selectionSort(unSortedArray);
        int[] expectedResult = sortedArray;
        Assert.assertEquals(actualResult, expectedResult, "Selection Sort Failed - Not Sorted!");
    }

    @Test //Testing insertionSort() method from Sort.java
    public void testInsertionSort() {
        // Create instance of Sort class
        sort= new Sort();

        int[] actualResult = sort.insertionSort(unSortedArray);
        int[] expectedResult = sortedArray;
        Assert.assertEquals(actualResult, expectedResult, "Insertion Sort Failed - Not Sorted!");
    }

    @Test //Testing bubbleSort() method from Sort.java
    public void testBubbleSort() {
        // Create instance of Sort class
        sort= new Sort();

        int[] actualResult = sort.bubbleSort(unSortedArray);
        int[] expectedResult = sortedArray;
        Assert.assertEquals(actualResult, expectedResult, "Bubble Sort Failed - Not Sorted!");
    }

    @Test //Testing mergeSort() method from Sort.java
    public void testMergeSort() {
        // Create instance of Sort class
        sort= new Sort();

        int[] actualResult = sort.mergeSort(unSortedArray, unSortedArray[0], unSortedArray.length-1);
        int[] expectedResult = sortedArray;
        Assert.assertEquals(actualResult, expectedResult, "Merge Sort Failed - Not Sorted!");
    }

    @Test //Testing shellSort() method from Sort.java
    public void testShellSort() {
        // Create instance of Sort class
        sort= new Sort();

        int[] actualResult = sort.shellSort(unSortedArray, unSortedArray.length);
        int[] expectedResult = sortedArray;
        Assert.assertEquals(actualResult, expectedResult, "Shell Sort Failed - Not Sorted!");
    }
}

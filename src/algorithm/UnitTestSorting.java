package algorithm;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class UnitTestSorting {
    /*
      This class is used to help with unit testing of sorting algorithms from the Sort class
     */

    Sort sort; //Declared variable of type Sort
    int[] unSortedArray = {6, 9, 2, 5, 1, 0, 4};
    int[] sortedArray = {0, 1, 2, 4, 5, 6, 9};

    public static void main(String[] args) {
        UnitTestSorting unitTest = new UnitTestSorting();
        Sort sort = new Sort();

        unitTest.testSelectionSort();
        unitTest.testInsertionSort();
        unitTest.testBubbleSort();
        unitTest.testMergeSort();

        //Sorting and printing an array using mergeSort()
        //System.out.println(Arrays.toString(sort.mergeSort(unitTest.unSortedArray, unitTest.unSortedArray[0], unitTest.unSortedArray.length - 1)));
    }

    // Implement Unit test for rest of the sorting algorithms below

    @Test ////Testing selectionSort() method from Sort.java
    public void testSelectionSort() {
        // Create instance of Sort class
        sort = new Sort();

        int[] actualResult = sort.selectionSort(unSortedArray);
        int[] expectedResult = sortedArray;
        Assert.assertEquals(actualResult, expectedResult, "Selection Sort Failed - Not Sorted!");
    }

    @Test ////Testing insertionSort() method from Sort.java
    public void testInsertionSort() {
        // Create instance of Sort class
        sort= new Sort();

        int[] actualResult = sort.insertionSort(unSortedArray);
        int[] expectedResult = sortedArray;
        Assert.assertEquals(actualResult, expectedResult, "Insertion Sort Failed - Not Sorted!");
    }

    @Test ////Testing bubbleSort() method from Sort.java
    public void testBubbleSort() {
        // Create instance of Sort class
        sort= new Sort();

        int[] actualResult = sort.bubbleSort(unSortedArray);
        int[] expectedResult = sortedArray;
        Assert.assertEquals(actualResult, expectedResult, "Bubble Sort Failed - Not Sorted!");
    }

    @Test ////Testing mergeSort() method from Sort.java
    public void testMergeSort() {
        // Create instance of Sort class
        sort= new Sort();

        int[] actualResult = sort.mergeSort(unSortedArray, unSortedArray[0], unSortedArray.length-1);
        int[] expectedResult = sortedArray;
        Assert.assertEquals(actualResult, expectedResult, "Merge Sort Failed - Not Sorted!");
    }
}

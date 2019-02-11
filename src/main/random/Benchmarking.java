package random;

import java.util.Arrays;

public class Benchmarking {

    /** Comparing run time of Isnertion sort and Arrays.sort() algorithms
     * @param args
     */
    public static void main(String[] args) {

        final int SIZE = 10000;
        System.out.println("\nArray size: " + SIZE + " elements.\n");

        // Creating two arrays of type int[] with the same SIZE
        int[] array1 = new int[SIZE];
        int[] array2 = new int[SIZE];

        // Filling the arrays with random integers
        for (int i=0; i<SIZE; i++) {
            int randomInt = (int)(Integer.MAX_VALUE * Math.random());
            array1[i] = randomInt;
            array2[i] = randomInt;
        }

        // Sorting the first array using Insertion Sort
        long startTime = System.currentTimeMillis();
        insertionSort(array1);
        long runTime = System.currentTimeMillis() - startTime;
        System.out.println("Insertion sort run time: " + runTime + " milliseconds.\n");

        // Sorting the second array using Arrays.sort()
        startTime = System.currentTimeMillis();
        Arrays.sort(array2);
        runTime = System.currentTimeMillis() - startTime;
        System.out.println("Arrays.sort() run time: " + runTime + " milliseconds.\n");
    }

    /**
     * Sorting the array A into increasing order
     * @param
     */
    static void insertionSort(int[] A) {

        int itemsSorted; // Number of items that have been sorted so far.

        for (itemsSorted = 1; itemsSorted < A.length; itemsSorted++) {
            // Assume that items A[0], A[1], ... A[itemsSorted-1]
            // have already been sorted.  Insert A[itemsSorted]
            // into the sorted part of the list.

            int temp = A[itemsSorted];  // The item to be inserted.
            int loc = itemsSorted - 1;  // Start at end of list.

            while (loc >= 0 && A[loc] > temp) {
                A[loc + 1] = A[loc]; // Bump item from A[loc] up to loc+1.
                loc = loc - 1;       // Go on to next location.
            }

            A[loc + 1] = temp; // Put temp in last vacated space.
        }
    }
}
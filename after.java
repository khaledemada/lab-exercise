import java.util.*;

/**
 * A class that demonstrates sorting algorithms.
 * Includes quick sort and merge sort.
 * 
 * @author YourName
 * @version 1.0
 */
public class SortExample {

    /**
     * Main method to run sorting examples.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // This is an unsorted array
        Integer[] array1 = new Integer[] {12, 13, 24, 10, 3, 6, 90, 70};
        int array2[] = {2, 6, 3, 5, 1};

        // Sort using quick sort
        quickSort(array1, 0, array1.length - 1);
        System.out.println("QuickSorted Array1: " + Arrays.toString(array1));

        // Sort using merge sort
        mergeSort(array2, array2.length);
        System.out.println("MergeSorted Array2: " + Arrays.toString(array2));
    }

    /**
     * Quick sort algorithm implementation.
     * 
     * @param arr  the array to be sorted
     * @param low  the starting index of the array
     * @param high the ending index of the array
     */
    public static void quickSort(Integer[] arr, int low, int high) {
        // Check for empty or null array
        if (arr == null || arr.length == 0) return;
        if (low >= high) return;

        // Get the pivot element from the middle of the list
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // Make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        // Recursive calls to sort sub-arrays
        if (low < j) quickSort(arr, low, j);
        if (high > i) quickSort(arr, i, high);
    }

    /**
     * Swaps two elements in an array.
     * 
     * @param array the array containing elements to swap
     * @param x     index of the first element
     * @param y     index of the second element
     */
    public static void swap(Integer[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    /**
     * Merge sort algorithm implementation.
     * 
     * @param a the array to be sorted
     * @param n the size of the array
     */
    public static void mergeSort(int[] a, int n) {
        if (n < 2) return;

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) left[i] = a[i];
        for (int i = mid; i < n; i++) right[i - mid] = a[i];

        mergeSort(left, mid);
        mergeSort(right, n - mid);
        merge(a, left, right, mid, n - mid);
    }

    /**
     * Merges two subarrays into one.
     * 
     * @param a     the original array
     * @param left  the left half of the array
     * @param right the right half of the array
     * @param lSize the size of the left array
     * @param rSize the size of the right array
     */
    public static void merge(int[] a, int[] left, int[] right, int lSize, int rSize) {
        int i = 0, j = 0, k = 0;

        while (i < lSize && j < rSize) {
            if (left[i] <= right[j]) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }

        while (i < lSize) a[k++] = left[i++];
        while (j < rSize) a[k++] = right[j++];
    }

    /**
     * Checks if an array is sorted in ascending order.
     * 
     * @param x the array to check
     * @return true if the array is sorted, false otherwise
     */
    private static boolean isSorted(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            if (x[i] > x[i + 1]) return false;
        }
        return true;
    }
}

package Recuperacion;
import java.util.Arrays;

public class Sorts {

    // Bubble sort (in-place) for double[]
    public static void bubbleSort(double[] a) {
        int n = a.length;
        for (int i = 0; i < n-1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n-1-i; j++) {
                if (a[j] > a[j+1]) {
                    double t = a[j]; a[j] = a[j+1]; a[j+1] = t;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Selection sort
    public static void selectionSort(double[] a) {
        int n = a.length;
        for (int i = 0; i < n-1; i++) {
            int minIdx = i;
            for (int j = i+1; j < n; j++)
                if (a[j] < a[minIdx]) minIdx = j;
            double t = a[i]; a[i] = a[minIdx]; a[minIdx] = t;
        }
    }

    // Insertion sort
    public static void insertionSort(double[] a) {
        for (int i = 1; i < a.length; i++) {
            double key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }
    }

    // Merge sort
    public static void mergeSort(double[] a) {
        if (a.length <= 1) return;
        mergeSortRecursive(a, 0, a.length-1);
    }

    private static void mergeSortRecursive(double[] a, int l, int r) {
        if (l >= r) return;
        int m = (l + r) / 2;
        mergeSortRecursive(a, l, m);
        mergeSortRecursive(a, m+1, r);
        merge(a, l, m, r);
    }

    private static void merge(double[] a, int l, int m, int r) {
        double[] left = java.util.Arrays.copyOfRange(a, l, m+1);
        double[] right = java.util.Arrays.copyOfRange(a, m+1, r+1);
        int i=0,j=0,k=l;
        while (i<left.length && j<right.length) {
            if (left[i] <= right[j]) a[k++] = left[i++];
            else a[k++] = right[j++];
        }
        while (i<left.length) a[k++] = left[i++];
        while (j<right.length) a[k++] = right[j++];
    }

    // Quick sort
    public static void quickSort(double[] a) {
        quickSortRecursive(a, 0, a.length-1);
    }

    private static void quickSortRecursive(double[] a, int low, int high) {
        if (low < high) {
            int p = partition(a, low, high);
            quickSortRecursive(a, low, p-1);
            quickSortRecursive(a, p+1, high);
        }
    }

    private static int partition(double[] a, int low, int high) {
        double pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                double t = a[i]; a[i] = a[j]; a[j] = t;
            }
        }
        double t = a[i+1]; a[i+1] = a[high]; a[high] = t;
        return i+1;
    }

    // Helper to print arrays
    public static String toString(double[] a) {
        return Arrays.toString(a);
    }
}
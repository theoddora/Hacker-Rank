package sorting;

import java.util.Scanner;

public class RunningTimeOfQuicksort {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] arrQuick = new int[n];
        int[] arrInsertion = new int[n];

        for (int i = 0; i < n; ++i) {
            int element = scan.nextInt();
            arrQuick[i] = element;
            arrInsertion[i] = element;
        }

        scan.close();

        int[] counterQuickSort = new int[] { 0 };
        int[] counterInsertionSort = new int[] { 0 };

        quickSort(arrQuick, 0, arrQuick.length - 1, counterQuickSort);
        insertionSort(arrInsertion, counterInsertionSort);

        System.out.println(counterInsertionSort[0] - counterQuickSort[0]);
    }

    public static void insertionSort(int[] arr, int[] counter) {

        for (int i = 1; i < arr.length; ++i) {
            int element = arr[i];
            int index = i - 1;

            while (index >= 0 && arr[index] > element) {
                counter[0]++;
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = element;
        }

    }

    public static void quickSort(int[] arr, int low, int high, int[] counter) {

        if (low < high) {
            int p = partition(arr, low, high, counter);
            quickSort(arr, low, p - 1, counter);
            quickSort(arr, p + 1, high, counter);
        }

    }

    private static int partition(int[] arr, int low, int high, int[] counter) {

        int pivot = arr[high];

        int index = low - 1;
        for (int j = low; j < high; ++j) {
            if (arr[j] <= pivot) {
                swap(++index, j, arr);
                counter[0]++;
            }
        }
        swap(++index, high, arr);
        counter[0]++;
        return index;
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

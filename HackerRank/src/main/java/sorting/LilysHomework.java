package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class LilysHomework {

    public static void main(String[] args) {

        int[] swapsAsc = new int[1];
        int[] swapsDsc = new int[1];

        int[] arrAsc = readInput();

        int[] arrDsc = Arrays.copyOf(arrAsc, arrAsc.length);

        int asc = selectionSortAsc(arrAsc, swapsAsc);
        int dsc = selectionSortDsc(arrDsc, swapsDsc);
        System.out.println(asc < dsc ? asc : dsc);

    }

    private static int selectionSortAsc(int[] arr, int[] swaps) {

        for (int i = 0, j = arr.length - 1; i < arr.length - 1; ++i, --j) {
            int currentMinIndex = i;
            int currentMaxIndex = j;
            for (int k = i + 1; k < j + 1; ++k) {
                if (arr[k] < arr[currentMinIndex]) {
                    currentMinIndex = k;
                }
                if (arr[k] > arr[currentMaxIndex]) {
                    currentMaxIndex = k;
                }
            }
            if (currentMaxIndex == i && currentMinIndex == j && currentMinIndex != i && currentMaxIndex != j) {
                swap(currentMaxIndex, currentMinIndex, arr);
                swaps[0]++;
                continue;
            }
            if (currentMinIndex != i) {
                swap(currentMinIndex, i, arr);
                swaps[0]++;
            }
            if (currentMaxIndex != j) {
                swap(currentMaxIndex, j, arr);
                swaps[0]++;
            }
        }

        return swaps[0];
    }

    private static int selectionSortDsc(int[] arr, int[] swaps) {

        for (int i = 0, j = arr.length - 1; i < arr.length - 1; ++i, --j) {
            int currentMinIndex = i;
            int currentMaxIndex = j;
            for (int k = i + 1; k < arr.length; ++k) {
                if (arr[k] > arr[currentMinIndex]) {
                    currentMinIndex = k;
                }
                if (arr[k] < arr[currentMaxIndex]) {
                    currentMaxIndex = k;
                }
            }
            if (currentMaxIndex == i && currentMinIndex == j && currentMinIndex != i && currentMaxIndex != j) {
                swap(currentMaxIndex, currentMinIndex, arr);
                swaps[0]++;
                continue;
            }
            if (currentMinIndex != i) {
                swap(currentMinIndex, i, arr);
                swaps[0]++;
            }
            if (currentMaxIndex != j) {
                swap(currentMaxIndex, j, arr);
                swaps[0]++;
            }
        }

        return swaps[0];
    }

    private static int[] readInput() {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        return arr;
    }

    private static void swap(int i, int right, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;
    }

    static void heapify(int[] arr, int length, int currentRoot) {

        int max = currentRoot;
        int leftChildIndex = 2 * currentRoot + 1;
        int rightChildIndex = leftChildIndex + 1;

        if (leftChildIndex < length && arr[leftChildIndex] > arr[max]) {
            max = leftChildIndex;
        }
        if (rightChildIndex < length && arr[rightChildIndex] > arr[max]) {
            max = rightChildIndex;
        }

        if (max != currentRoot) {
            swap(currentRoot, max, arr);
            heapify(arr, length, max);
        }
    }

    static void buildHeap(int[] arr) {

        for (int i = arr.length / 2 - 1; i >= 0; --i) {
            heapify(arr, arr.length, i);
        }
    }

    static void heap(int arr[], int[] swaps) {

        buildHeap(arr);

        for (int i = arr.length - 1; i >= 1; --i) {
            swap(0, i, arr);
            swaps[0]++;
            heapify(arr, i, 0);
        }
    }

}

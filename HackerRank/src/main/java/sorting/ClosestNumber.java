package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClosestNumber {

    public static void main(String[] args) {

        int[] arr = readInput();
        quickSort(arr, 0, arr.length - 1);

        List<Integer> pairs = sweep(arr);

        printResult(pairs);
    }

    public static int[] readInput() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < arr.length; ++i) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        return arr;
    }

    public static List<Integer> sweep(int[] arr) {
        List<Integer> pairs = new ArrayList<>();

        int minAbsolute = arr[1] - arr[0];
        for(int i = 1; i < arr.length - 1; ++i) {
            if(arr[i+1] - arr[i] <= minAbsolute) {
                minAbsolute  = arr[i+1] - arr[i];
            }
        }

        for(int i = 0; i < arr.length - 1; ++i) {
            if(arr[i + 1] - arr[i] == minAbsolute) {
                pairs.add(arr[i]);
                pairs.add(arr[i+1]);
            }
        }

        return pairs;
    }

    public static void printResult(List<Integer> pairs) {
        for (Integer pair : pairs) {
            System.out.print(pair + " ");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {

        if(left < right) {

            int index = partiton(arr, left, right);
            quickSort(arr, left, index - 1);
            quickSort(arr, index + 1, right);
        }
    }

    private static int partiton(int[] arr, int left, int right) {
        int pivot = arr[right];

        int index = left - 1;
        for (int j = left; j < right; ++j) {
            if (arr[j] <= pivot) {
                swap(++index, j, arr);
            }
        }
        swap(++index, right, arr);
        return index;
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

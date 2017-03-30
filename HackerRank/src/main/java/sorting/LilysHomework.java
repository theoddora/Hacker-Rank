package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class LilysHomework {

    public static void main(String[] args) {

        int[] arrAsc = readInput();
        int[] arrDsc = Arrays.copyOf(arrAsc, arrAsc.length);

        int[] swapsAsc = new int[1];
        int[] swapsDsc = new int[1];

        int[] sortedArrAsc = Arrays.copyOf(arrAsc, arrAsc.length);
        int[] sortedArrDsc = Arrays.copyOf(arrAsc, arrAsc.length);

        Arrays.sort(sortedArrAsc);
        reverseSortedArray(sortedArrDsc);

        findSwapsAsc(arrAsc, sortedArrAsc, swapsAsc);

        System.out.println(swapsAsc[0]);
    }

    private static void findSwapsAsc(int[] arr, int[] sortedArr, int[] swaps) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] != sortedArr[i]) {
                swap(indexOf(sortedArr[i], arr), i, arr);
                swaps[0]++;
            }
        }
    }

    private static int indexOf(int search, int[] arr) {
        int returning = -1;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == search) {
                returning = i;
                break;
            }
        }
        return returning;
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

    private static void reverseSortedArray(int[] arr) {

        for (int k = 0; k < arr.length / 2; ++k) {
            int temp = arr[k];
            arr[k] = arr[arr.length - (1 + k)];
            arr[arr.length - (1 + k)] = temp;
        }
    }

}

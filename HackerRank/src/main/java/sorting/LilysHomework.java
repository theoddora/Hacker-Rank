package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class LilysHomework {

    public static void main(String[] args) {

        int[] arr = readInput();
        int[] swapsA = new int[1];
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        findSwapsAscending(arr, sortedArr, swapsA);
        System.out.println(swapsA[0]);
    }

    private static void findSwapsAscending(int[] arr, int[] sortedArr, int[] swaps) {
        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] != sortedArr[i]) {
                swap(indexOf(arr[i], sortedArr), i, arr);
                swaps[0]++;
            }
        }
    }

    private static int indexOf(int search, int[] arr) {
        int returning = -1;
        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] == search) {
                returning = i; break;
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


}

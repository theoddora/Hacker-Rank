package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class FindTheMedian {

    public static void main(String[] args) {

        int[] arr = readInput();
        Arrays.sort(arr);
        int median = sweep(arr);

        System.out.print(median);
    }

    public static int[] readInput() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        return arr;
    }

    public static int sweep(int[] arr) {
        return arr[arr.length / 2];
    }
}

package sorting;

import sun.rmi.server.InactiveGroupException;

import java.util.*;

public class LilysHomework {

    public static void main(String[] args) {

        /*
        Prep stage:
        create map with:
        keys : values from input list,
        values : indexes of values from input list,
        make a copy of sorted input list
        Algo stage:
        Iterate through input list, and compare current value (lets call it currentValue) against value from sorted list (lets call it sortedValue). If it is diffrent:
            increment number of swaps
            get index of the sortedValue from map - map[sortedValue],
            in input list swap currentValue with sortedValue,
            update map[cv]=map[sortedValue] (map[sortedValue] does not need to be updated as we are not going to use it any more)
        Then you need to execute it on input list and reversed input list - the smaller return value - is the answer.
        Time complexity is equal to sort time complexity (usually O(n logn) ). Space O(n)
         */

        int[] swapsAsc = new int[1];
        int[] swapsDsc = new int[1];

        Map<Integer, Integer> arrAsc = readInput();

        Map<Integer,Integer> sortedArr = sortMapValue(new HashMap<>(arrAsc), 0, arrAsc.size() - 1);

        int swaps = 0;
        for(int i = 0; i < arrAsc.size(); ++i) {
            int currentValue = arrAsc.get(i);
            int sortedValue = sortedArr.get(i);
            if(currentValue != sortedValue) {
                swaps++;

            }
        }

    }

    private static Map<Integer, Integer> sortMapValue(Map<Integer, Integer> arrAsc, int left, int right) {
        int index = partition(arrAsc, left, right);
        if (left < index - 1) {
            sortMapValue(arrAsc, left, index - 1);
        }
        if (index < right) {
            sortMapValue(arrAsc, index, right);
        }
        return arrAsc;
    }

    public static void swap(Map<Integer, Integer> array, int i, int j) {
        int temp = array.get(i);
        array.put(i, j);
        array.put(j, temp);
    }

    public static int partition(Map<Integer, Integer> arrAsc, int left, int right) {

        int pivot = arrAsc.get((left + right) / 2);

        while (left <= right) {
            while(arrAsc.get(left) < pivot) {
                left++;
            }

            while (arrAsc.get(right) > pivot) {
                right--;
            }

            if (left <= right) {
                swap(arrAsc, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static Map<Integer, Integer> readInput() {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<Integer, Integer> arr = new HashMap<>(n);

        for (int i = 0, input; i < n; ++i) {
            input = sc.nextInt();
            arr.put(i, input);
        }
        sc.close();
        return arr;
    }

}

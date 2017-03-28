package sorting;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountingSortOne {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] arr = new int[n];
        Map<Integer, Integer> helper = new TreeMap<>();

        for (int i = 0; i < arr.length; ++i) {
            int element = scan.nextInt();
            arr[i] = element;
            if(!helper.containsKey(element)) {
                helper.put(element, 0);
            }
            helper.put(element, helper.get(element) + 1);
        }
        scan.close();

        for (Map.Entry<Integer, Integer> entry : helper.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }

    }
}

package sorting;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountingSortThree {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr = new int[n];
        Map<Integer, Integer> helper = new TreeMap<>();

        for (int i = 0; i < arr.length; ++i) {
            int element = scan.nextInt();
            scan.next();
            arr[i] = element;
            if (!helper.containsKey(element)) {
                helper.put(element, 0);
            }
            helper.put(element, helper.get(element) + 1);
        }
        scan.close();

        long print;
        Iterator<Map.Entry<Integer, Integer>> iterator = helper.entrySet().iterator();
        if (iterator.hasNext()) {
            print = iterator.next().getValue();
            System.out.print(print + " ");

            for(int i = 1; i < 100; ++i) {
                if (iterator.hasNext()) {
                    print += iterator.next().getValue();
                }
                System.out.print(print + " ");
            }
        }
    }
}

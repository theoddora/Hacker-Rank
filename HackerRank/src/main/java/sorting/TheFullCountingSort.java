package sorting;

import java.util.*;

public class TheFullCountingSort {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr = new int[n];
        Map<Integer, List<String>> helper = new TreeMap<>();

        for (int i = 0; i < arr.length; ++i) {
            int element = scan.nextInt();
            String string = scan.next();
            arr[i] = element;
            if (!helper.containsKey(element)) {
                helper.put(element, new ArrayList<String>());
            }
            if (i < arr.length / 2) {
                helper.get(element).add("-");
            } else {
                helper.get(element).add(string);
            }
        }
        scan.close();

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, List<String>> integerListEntry : helper.entrySet()) {

            List<String> currentElement = integerListEntry.getValue();

            for (String aCurrentElement : currentElement) {
                sb.append(aCurrentElement).append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}

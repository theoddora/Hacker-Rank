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
        Iterator<Map.Entry<Integer, List<String>>> iterator = helper.entrySet().iterator();
        while (iterator.hasNext()) {

            List<String> currentElement = iterator.next().getValue();

            for(int i = 0; i < currentElement.size(); ++i) {
                sb.append(currentElement.get(i) + " ");
            }
        }
        System.out.println(sb.toString());
    }
}

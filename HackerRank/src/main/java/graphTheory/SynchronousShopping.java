package graphTheory;

import java.util.*;

public class SynchronousShopping {

    static class Fishmonger {

        int numberOfTypesOfFishSoled;
        List<Integer> fishTypes = new ArrayList<>();
        Map<Integer, Integer> shoppingCentersToGo = new HashMap<>(); // shop and cost to go
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int roads, centers, typesOfFish;

        centers = sc.nextInt(); roads = sc.nextInt(); typesOfFish = sc.nextInt();

        Fishmonger[] shoppingCenters = new Fishmonger[centers];
        for(int i = 0; i < centers; ++i) {

            int ti, tj;
            ti = sc.nextInt();

            shoppingCenters[i].numberOfTypesOfFishSoled = ti;
            for(int j = 0; j < ti; ++j) {
                tj = sc.nextInt();
                shoppingCenters[i].fishTypes.add(tj);
            }
        }

        for(int i = 0; i < roads; ++i) {
            int from, to, cost;
            from = sc.nextInt() - 1;
            to = sc.nextInt() - 1;
            cost = sc.nextInt();

            shoppingCenters[from].shoppingCentersToGo.put(to, cost);
            shoppingCenters[to].shoppingCentersToGo.put(from, cost);
        }

    }

}

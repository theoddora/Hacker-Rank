import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoadsAndLibraries {

    static class CitiesMap {

        private int costOfLibrary;
        private int costOfRoad;
        private List<List<Integer>> roads;

        private long totalCost;

        public CitiesMap(int numberOfCities, int costOfLibrary, int costOfRoad) {
            this.totalCost = 0;
            this.costOfLibrary = costOfLibrary;
            this.costOfRoad = costOfRoad;
            roads = new ArrayList<>();
            for (int i = 0; i < numberOfCities; ++i) {
                roads.add(new ArrayList<Integer>());
            }
        }

        public List<List<Integer>> getRoads() {
            return roads;
        }

        public void buildLibraries(int city, boolean visited[]) {

            List<Integer> citiesToGo = roads.get(city);

            for (Integer aCitiesToGo : citiesToGo) {
                if (!visited[aCitiesToGo]) {

                    visited[aCitiesToGo] = true;
                    if (costOfLibrary > costOfRoad) {
                        totalCost += this.costOfRoad;
                        buildLibraries(aCitiesToGo, visited);
                    } else {
                        totalCost += this.costOfLibrary;
                        buildLibraries(aCitiesToGo, visited);
                    }
                }
            }

        }

        public long buildLibraries() {
            boolean visited[] = new boolean[roads.size()];
            for (int i = 0; i < roads.size(); ++i) {
                if (!visited[i]) {
                    visited[i] = true;
                    totalCost += this.costOfLibrary;
                    buildLibraries(i, visited);
                }
            }
            return totalCost;
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numberOfQueries = scan.nextInt();

        CitiesMap citiesMaps[] = new CitiesMap[numberOfQueries];

        for (int i = 0; i < numberOfQueries; ++i) {
            int numberOfCities = scan.nextInt();
            int numberOfRoads = scan.nextInt();
            int costOfLibrary = scan.nextInt();
            int costOfRoads = scan.nextInt();

            citiesMaps[i] = new CitiesMap(numberOfCities, costOfLibrary, costOfRoads);

            for (int j = 0; j < numberOfRoads; ++j) {
                int cityOne = scan.nextInt(), cityTwo = scan.nextInt();

                citiesMaps[i].getRoads().get(cityOne - 1).add(cityTwo - 1);
                citiesMaps[i].getRoads().get(cityTwo - 1).add(cityOne - 1);
            }
        }

        scan.close();

        for (CitiesMap city : citiesMaps) {
            System.out.println(city.buildLibraries());
        }
    }

}

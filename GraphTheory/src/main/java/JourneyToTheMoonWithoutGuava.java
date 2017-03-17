import java.util.*;

public class JourneyToTheMoonWithoutGuava {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int astronautsNumber = scan.nextInt();
        int pairs = scan.nextInt();

        List<List<Integer>> astronauts = new ArrayList<>(astronautsNumber);
        for (int i = 0; i < astronautsNumber; ++i) {
            astronauts.add(new ArrayList<Integer>());
        }

        boolean paired[] = new boolean[astronautsNumber];
        for (int i = 0; i < pairs; ++i) {

            int cityOne = scan.nextInt(), cityTwo = scan.nextInt();
            astronauts.get(cityOne).add(cityTwo);
            astronauts.get(cityTwo).add(cityOne);
            paired[cityOne] = true;
            paired[cityTwo] = true;
        }
        scan.close();

        long numberOfPairs = 0;
        Map<Integer, Long> peopleInGroups = findGroups(astronauts, paired);

        for (int i = 1; i <= peopleInGroups.size(); ++i) {

            int indexOfNext = i + 1;

            while (indexOfNext <= peopleInGroups.size()) {
                long currentNumberOfPairs = peopleInGroups.get(i);
                currentNumberOfPairs *= peopleInGroups.get(indexOfNext);
                numberOfPairs += currentNumberOfPairs;
                indexOfNext++;
            }
        }

        System.out.println(numberOfPairs);
    }

    public static Map<Integer, Long> findGroups(List<List<Integer>> astronauts, boolean paired[]) {

        Map<Integer, Long> numberOfPeopleInCountry = new HashMap<>();

        boolean visitedAstronaut[] = new boolean[astronauts.size()];
        for (int i = 0, groupId = 0; i < astronauts.size(); ++i) {

            if(!paired[i]) {
                numberOfPeopleInCountry.put(++groupId, 1L);
                continue;
            }

            if (!visitedAstronaut[i]) {
                visitedAstronaut[i] = true;
                numberOfPeopleInCountry.put(++groupId, 1L);
                findGroups(astronauts, i, groupId, visitedAstronaut, numberOfPeopleInCountry);
            }
        }

        return numberOfPeopleInCountry;
    }

    private static void findGroups(List<List<Integer>> astronauts, int astronautNumber, int groupId, boolean visitedAstronaut[],
        Map<Integer, Long> numberOfPeopleInCountry) {

        for (int i = 0; i < astronauts.get(astronautNumber).size(); ++i) {

            int astronaut = astronauts.get(astronautNumber).get(i);

            if (!visitedAstronaut[astronaut]) {
                visitedAstronaut[astronaut] = true;
                numberOfPeopleInCountry.put(groupId, numberOfPeopleInCountry.get(groupId) + 1);
                findGroups(astronauts, astronaut, groupId, visitedAstronaut, numberOfPeopleInCountry);
            }

        }
    }
}

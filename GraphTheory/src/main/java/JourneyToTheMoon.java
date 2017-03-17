import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.common.util.concurrent.AtomicLongMap;

public class JourneyToTheMoon {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int astronautsNumber = scan.nextInt();
        int pairs = scan.nextInt();

        List<List<Integer>> astronauts = new ArrayList<>(astronautsNumber);
        for (int i = 0; i < astronautsNumber; ++i) {
            astronauts.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < pairs; ++i) {

            int cityOne = scan.nextInt(), cityTwo = scan.nextInt();
            astronauts.get(cityOne).add(cityTwo);
            astronauts.get(cityTwo).add(cityOne);
        }
        scan.close();

        long numberOfPairs = 0;
        AtomicLongMap<Integer> peopleInGroups = findGroups(astronauts);

        for (int i = 1; i <= peopleInGroups.size(); ++i) {

            int indexOfNext = i + 1;
            long currentNumberOfPairs = peopleInGroups.get(i);

            while (indexOfNext <= peopleInGroups.size()) {
                currentNumberOfPairs *= peopleInGroups.get(indexOfNext);
                numberOfPairs += currentNumberOfPairs;
                indexOfNext++;
            }
        }

        System.out.println(numberOfPairs);
    }

    public static AtomicLongMap<Integer> findGroups(List<List<Integer>> astronauts) {

        AtomicLongMap<Integer> numberOfPeopleInCountry = AtomicLongMap.create();

        boolean visitedAstronaut[] = new boolean[astronauts.size()];
        for (int i = 0, groupId = 0; i < astronauts.size(); ++i) {

            if (!visitedAstronaut[i]) {
                visitedAstronaut[i] = true;
                numberOfPeopleInCountry.put(++groupId, 1);
                findGroups(astronauts, i, groupId, visitedAstronaut, numberOfPeopleInCountry);
            }
        }

        return numberOfPeopleInCountry;
    }

    private static void findGroups(List<List<Integer>> astronauts, int astronautNumber, int groupId, boolean visitedAstronaut[],
        AtomicLongMap<Integer> numberOfPeopleInCountry) {


        for (int i = 0; i < astronauts.get(astronautNumber).size(); ++i) {

            int astronaut = astronauts.get(astronautNumber).get(i);

            if (!visitedAstronaut[astronaut]) {
                visitedAstronaut[astronaut] = true;
                numberOfPeopleInCountry.getAndIncrement(groupId);
                findGroups(astronauts, astronaut, groupId, visitedAstronaut, numberOfPeopleInCountry);
            }

        }
    }
}

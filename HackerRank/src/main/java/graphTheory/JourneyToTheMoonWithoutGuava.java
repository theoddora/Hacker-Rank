package graphTheory;

import java.util.*;

public class JourneyToTheMoonWithoutGuava {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int astronautsNumber = scan.nextInt();
        int pairs = scan.nextInt();

        List<Integer> astronauts[] = new ArrayList[astronautsNumber];

        for (int i = 0; i < astronautsNumber; ++i) {
            astronauts[i] = new ArrayList<>();
        }

        Set<Integer> indexesOfPaired = new TreeSet<>();
        for (int i = 0; i < pairs; ++i) {

            int cityOne = scan.nextInt(), cityTwo = scan.nextInt();
            astronauts[cityOne].add(cityTwo);
            astronauts[cityTwo].add(cityOne);
            indexesOfPaired.add(cityOne);
            indexesOfPaired.add(cityTwo);
        }
        scan.close();

        long numberOfPairs = 0;
        Integer peopleInGroups[] = findGroups(astronauts, indexesOfPaired);

        int numberOfNotPaired = astronauts.length - indexesOfPaired.size();

        for (int i = 0; i < peopleInGroups.length; ++i) {

            int indexOfNext = i + 1;

            while (indexOfNext < peopleInGroups.length) {
                int currentNumberOfPairs = peopleInGroups[i];
                currentNumberOfPairs *= peopleInGroups[indexOfNext];
                numberOfPairs += currentNumberOfPairs;
                indexOfNext++;
            }
            numberOfPairs += peopleInGroups[i] * numberOfNotPaired;
        }

        while (numberOfNotPaired > 0) {
            int sumOfOnes = --numberOfNotPaired;
            numberOfPairs += sumOfOnes;
        }

        System.out.println(numberOfPairs);
    }

    public static Integer[] findGroups(List<Integer> astronauts[], Set<Integer> indexesOfPaired) {

        Map<Integer, Integer> numberOfPeopleInCountry = new HashMap<>();

        boolean visitedAstronaut[] = new boolean[astronauts.length];

        int groupId = 0;
        for (Integer index : indexesOfPaired) {

            if (!visitedAstronaut[index]) {
                visitedAstronaut[index] = true;
                numberOfPeopleInCountry.put(++groupId, 1);
                findGroups(astronauts, index, groupId, visitedAstronaut, numberOfPeopleInCountry);
            }
        }

        return numberOfPeopleInCountry.values().toArray(new Integer[numberOfPeopleInCountry.values().size()]);
    }

    private static void findGroups(List<Integer> astronauts[], int astronautNumber, int groupId, boolean visitedAstronaut[],
        Map<Integer, Integer> numberOfPeopleInCountry) {

        for (int i = 0; i < astronauts[astronautNumber].size(); ++i) {

            int astronaut = astronauts[astronautNumber].get(i);

            if (!visitedAstronaut[astronaut]) {
                visitedAstronaut[astronaut] = true;
                numberOfPeopleInCountry.put(groupId, numberOfPeopleInCountry.get(groupId) + 1);
                findGroups(astronauts, astronaut, groupId, visitedAstronaut, numberOfPeopleInCountry);
            }
        }
    }
}

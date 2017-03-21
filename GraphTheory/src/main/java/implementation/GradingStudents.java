package implementation;

import java.util.Scanner;

public class GradingStudents {

    public static void main(String[] args) {

        int[] grades = readGrades();
        calculateGrades(grades);
        printResult(grades);
    }

    public static int[] readGrades() {

        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();

        int[] grades = new int[size];
        for(int i = 0; i < grades.length; ++i) {
            grades[i] = scan.nextInt();
        }

        scan.close();

        return grades;
    }

    public static void calculateGrades(int[] grades) {

        int nextFiveMultiple = 0;
        for(int i = 0; i < grades.length; ++i) {

            if(grades[i] < 38) {
                continue;
            }
            nextFiveMultiple = 5 - (grades[i] % 5) + grades[i];
            if(nextFiveMultiple - grades[i] < 3) {
                grades[i] = nextFiveMultiple;
            }
        }
    }

    public static void printResult(int[] grades) {

        for(int i = 0; i < grades.length; ++i) {
            System.out.println(grades[i]);
        }
    }
}

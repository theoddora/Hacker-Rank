package implementation;

import java.util.Scanner;

public class AppleAndOrange {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int houseDistanceX, houseDistanceY, appleTree, orangeTree, apples, oranges;
        houseDistanceX  = sc.nextInt();
        houseDistanceY = sc.nextInt();
        appleTree = sc.nextInt();
        orangeTree = sc.nextInt();
        apples  = sc.nextInt();
        oranges = sc.nextInt();

        int fruit, fallenApples = 0, fallenOranges = 0;
        for(int i = 0; i < apples; ++i) {
            fruit = sc.nextInt();
            if(fruit + appleTree >= houseDistanceX && fruit + appleTree <= houseDistanceY) {
                fallenApples++;
            }
        }
        for(int i = 0; i < oranges; ++i) {
            fruit = sc.nextInt();
            if(fruit + orangeTree >= houseDistanceX && fruit + orangeTree <= houseDistanceY) {
                fallenOranges++;
            }
        }
        System.out.println(fallenApples);
        System.out.println(fallenOranges);
    }

}

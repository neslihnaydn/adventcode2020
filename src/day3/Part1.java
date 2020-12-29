package day3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) throws FileNotFoundException {
        int counter = getCounter(3, 1);
        System.out.println("Result: " + counter);
    }

    static int getCounter(int slopeX, int slopeY) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("src/day3/input.txt");
        Scanner sc = new Scanner(fis);

        int x = 0;
        int counter = 0;
        String line = sc.nextLine();

        while (sc.hasNextLine()) {
            for (int i = 0; i < slopeY; i++) {
                line = sc.nextLine();
            }

            x = (x + slopeX) % line.length();


            if ('#' == line.charAt(x)) {
                counter++;
            }
        }

        sc.close();
        return counter;
    }
}

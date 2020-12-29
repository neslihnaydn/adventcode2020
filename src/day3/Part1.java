package day3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("src/day3/input.txt");
        Scanner sc = new Scanner(fis);

        int slopeX = 3;
        int slopeY = 1;
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
        System.out.println("Result: " + counter);
    }
}

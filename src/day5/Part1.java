package day5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) throws FileNotFoundException {
        int upperRowLimit = 127;
        int lowerRowLimit = 0;
        int upperColumnLimit = 7;
        int lowerColumnLimit = 0;
        int maxSeatId = 0;

        FileInputStream fis = new FileInputStream("src/day5/input.txt");
        Scanner sc = new Scanner(fis);

        while (sc.hasNextLine()) {
            char[] line = sc.nextLine().toCharArray();

            for (char c : line) {
                switch (c) {
                    case 'F':
                        upperRowLimit = (upperRowLimit + lowerRowLimit) >> 1;
                        break;
                    case 'B':
                        lowerRowLimit = ((upperRowLimit + lowerRowLimit) >> 1)  + 1;
                        break;
                    case 'R':
                        lowerColumnLimit = ((upperColumnLimit + lowerColumnLimit) >> 1) + 1;
                        break;
                    case 'L':
                        upperColumnLimit = (upperColumnLimit + lowerColumnLimit) >> 1;
                        break;
                }
            }

            int seatId = upperRowLimit * 8 + upperColumnLimit;
            if (maxSeatId < seatId) maxSeatId = seatId;
            upperRowLimit = 127;
            lowerRowLimit = 0;
            upperColumnLimit = 7;
            lowerColumnLimit = 0;
        }

        System.out.println(maxSeatId);
        sc.close();
    }
}

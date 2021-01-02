package day5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {

    public static void main(String[] args) throws FileNotFoundException {
        int upperRowLimit = 127;
        int lowerRowLimit = 0;
        int upperColumnLimit = 7;
        int lowerColumnLimit = 0;
        int[][] seats = new int[128][8];

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
                        lowerRowLimit = ((upperRowLimit + lowerRowLimit) >> 1) + 1;
                        break;
                    case 'R':
                        lowerColumnLimit = ((upperColumnLimit + lowerColumnLimit) >> 1) + 1;
                        break;
                    case 'L':
                        upperColumnLimit = (upperColumnLimit + lowerColumnLimit) >> 1;
                        break;
                }
            }

            seats[upperRowLimit][upperColumnLimit] = 1;

            upperRowLimit = 127;
            lowerRowLimit = 0;
            upperColumnLimit = 7;
            lowerColumnLimit = 0;
        }

        System.out.println(findSeat(upperRowLimit, upperColumnLimit, seats));
        sc.close();
    }

    private static int findSeat(int upperRowLimit, int upperColumnLimit, int[][] seats) {
        int yourSeat = 0;

        for (int i = 0; i <= upperRowLimit; i++) {
            int counterEmptySeatInRow = 0;
            for (int j = 0; j <= upperColumnLimit; j++) {
                if (0 == seats[i][j]) {
                    yourSeat = i * 8 + j;
                    counterEmptySeatInRow++;
                }
            }

            if (counterEmptySeatInRow == 1) {
                return yourSeat;
            }
        }

        return yourSeat;
    }
}

package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int expectedResult = 2020;

        try {
            List<String> allLines = Files.readAllLines(Paths.get("src/day1/input.txt"));
            int[] numbers = allLines.stream().mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] < expectedResult) {
                    for (int j = i + 1; j < numbers.length; j++) {
                        if (numbers[i] + numbers[j] != expectedResult) {
                            for (int k = j + 1; k < numbers.length; k++) {
                                if (numbers[i] + numbers[j] + numbers[k] == expectedResult) {
                                    System.out.println("Result: " + numbers[i] * numbers[j] * numbers[k]);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

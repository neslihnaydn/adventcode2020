package day4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) throws IOException {
        String regex = ":\\s*([a-zA-Z0-9#]+)\\s*";

        FileInputStream fis = new FileInputStream("src/day4/input.txt");
        Scanner sc = new Scanner(fis);

        List<String> requiredFields = getRequiredFields();
        int validityCounter = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            if ("".equals(line.trim())) {
                if (requiredFields.isEmpty()) {
                    validityCounter++;
                }

                requiredFields = getRequiredFields();
            } else {
                requiredFields.removeAll(Arrays.asList(line.split(regex)));
            }
        }

        if (requiredFields.isEmpty()) {
            validityCounter++;
        }

        System.out.println(validityCounter);
        sc.close();

    }

    private static List<String> getRequiredFields() {
        return new ArrayList<>(Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));
    }
}
package day4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Part2 {
    private static final String HAIR_COLOR_REGEX = "#[a-f0-9]+";
    private static final String PID_REGEX = "([0-9]+)";
    private static final String HGT_REGEX = "([0-9]+)(cm|in)";
    private static final List<String> eyeColors = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
    private static final List<String> requiredFields = Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("src/day4/input.txt");
        Scanner sc = new Scanner(fis);
        Map<String, String> fields = new HashMap<>();
        int validityCounter = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            if ("".equals(line.trim())) {
                if (isValid(fields)) {
                    validityCounter++;
                }

                fields = new HashMap<>();
            } else {
                for (String splitSpace : line.split("\\s")) {
                    String[] splitColon = splitSpace.split(":");
                    if (2 == splitColon.length)
                        fields.put(splitColon[0], splitColon[1]);
                }
            }
        }

        if (isValid(fields)) {
            validityCounter++;
        }

        System.out.println(validityCounter);
        sc.close();

    }

    private static boolean isValid(Map<String, String> fields) {
        boolean valid = true;

        try {
            for (String key : fields.keySet()) {
                switch (key) {
                    case "byr":
                        valid = Integer.valueOf(fields.get(key)) >= 1920 && Integer.valueOf(fields.get(key)) <= 2002;
                        break;
                    case "iyr":
                        valid = Integer.valueOf(fields.get(key)) >= 2010 && Integer.valueOf(fields.get(key)) <= 2020;
                        break;
                    case "eyr":
                        valid = Integer.valueOf(fields.get(key)) >= 2020 && Integer.valueOf(fields.get(key)) <= 2030;
                        break;
                    case "hgt":
                        if (fields.get(key).matches(HGT_REGEX)) {
                            String[] split = fields.get(key).split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
                            if ("cm".equals(split[1])) {
                                valid = Integer.valueOf(split[0]) >= 150 && Integer.valueOf(split[0]) <= 193;
                            } else {
                                valid = Integer.valueOf(split[0]) >= 59 && Integer.valueOf(split[0]) <= 76;
                            }
                        } else {
                            return false;
                        }
                        break;
                    case "hcl":
                        valid = (7 == fields.get(key).length()) && fields.get(key).matches(HAIR_COLOR_REGEX);
                        break;
                    case "ecl":
                        valid = eyeColors.contains(fields.get(key));
                        break;
                    case "pid":
                        valid = (9 == fields.get(key).length()) && fields.get(key).matches(PID_REGEX);
                        break;
                }

                if (!valid) {
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return fields.keySet().containsAll(requiredFields);
    }
}
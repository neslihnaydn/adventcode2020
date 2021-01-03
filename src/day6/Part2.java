package day6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Part2 {

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("src/day6/input.txt");
        Scanner sc = new Scanner(fis);
        HashMap<Character, Integer> answeredYes = new HashMap<>();
        int result = 0;
        int numOfPeople = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            if ("".equals(line.trim())) {
                result = getCommonAnswers(answeredYes, result, numOfPeople);

                answeredYes = new HashMap<>();
                numOfPeople = 0;
            } else {
                for (char aChar : line.toCharArray()) {
                    if (!answeredYes.containsKey(aChar)) {
                        answeredYes.put(aChar, 1);
                    } else {
                        answeredYes.replace(aChar, answeredYes.get(aChar) + 1);
                    }
                }

                numOfPeople++;
            }

        }

        System.out.println(getCommonAnswers(answeredYes, result, numOfPeople));
    }

    private static int getCommonAnswers(HashMap<Character, Integer> answeredYes, int result, int numOfPeople) {
        for (int numOfYes : answeredYes.values()) {
            if (numOfYes == numOfPeople) {
                result++;
            }
        }
        return result;
    }
}

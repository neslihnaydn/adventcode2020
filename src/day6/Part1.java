package day6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Part1 {

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("src/day6/input.txt");
        Scanner sc = new Scanner(fis);

        Set<Character> answeredYes = new HashSet<>();
        int counter = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            if ("".equals(line.trim())) {
                counter = counter + answeredYes.size();
                answeredYes = new HashSet<>();
            }

            for (char aChar : line.toCharArray()) {
                answeredYes.add(aChar);
            }

        }
        System.out.println(counter + answeredYes.size());
    }
}

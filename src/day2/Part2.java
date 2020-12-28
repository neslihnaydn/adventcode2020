package day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Part2 {

    public static void main(String[] args) throws IOException {

        File file = new File("src/day2/input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int validityCounter = 0;

        while ((st = br.readLine()) != null) {
            String delims = "[- :]+";
            String[] splitted = st.split(delims);
            int position1 = Integer.valueOf(splitted[0]) - 1;
            int position2 = Integer.valueOf(splitted[1]) - 1;
            char letter = splitted[2].toCharArray()[0];
            String sample = splitted[3];

            if (sample.charAt(position1) == letter || sample.charAt(position2) == letter) {
                if (!(sample.charAt(position1) == letter && sample.charAt(position2) == letter))
                    validityCounter++;
            }
        }

        System.out.println("Number of valid passwords: "+ validityCounter);
    }
}

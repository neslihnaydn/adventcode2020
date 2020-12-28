package day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Part1 {

    public static void main(String[] args) throws IOException {

        File file = new File("src/day2/input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int validityCounter = 0;

        while ((st = br.readLine()) != null) {
            boolean isValid = true;
            String delims = "[- :]+";
            String[] splitted = st.split(delims);
            int minOccurance = Integer.valueOf(splitted[0]);
            int maxOccurance = Integer.valueOf(splitted[1]);
            char letter = splitted[2].toCharArray()[0];
            String sample = splitted[3];

            int counter = 0;
            for (int i = 0; i < sample.length(); i++) {
                if (sample.charAt(i) == letter) {
                    counter++;
                }

                if (counter > maxOccurance) {
                    isValid = false;
                    break;
                }
            }

            if (counter >= minOccurance && isValid) {
                validityCounter++;
            }
        }

        System.out.println("Number of valid passwords: "+ validityCounter);
    }
}

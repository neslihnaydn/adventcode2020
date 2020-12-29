package day3;

import java.io.FileNotFoundException;

import static day3.Part1.getCounter;

public class Part2 {

    public static void main(String[] args) throws FileNotFoundException {
        int result = getCounter(1, 1)
                * getCounter(3, 1)
                * getCounter(5, 1)
                * getCounter(7, 1)
                * getCounter(1, 2);

        System.out.println(result);

    }
}

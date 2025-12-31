package Day3;

import java.nio.file.*;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;

public class Challenge1 {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("/Users/kialok/IdeaProjects/Day 1/src/Day3/input_day3.txt"));
            String[] arr = lines.toArray(new String[0]);
            int output = total_voltage(arr);
            System.out.println(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int total_voltage(String[] all_banks) {
        int acc = 0;
        for (String bank : all_banks) {
            acc += highest_voltage(bank);
        }
        return acc;
    }

    public static int highest_voltage(String bank) {
        int highest_first_num = 0;
        int highest_second_num = 0;
        int index = 0;
        for (int i = 0; i < bank.length() - 1; i++) {
            int c = Character.getNumericValue(bank.charAt(i));
            if (c > highest_first_num) {
                highest_first_num = c;
                index = i;
            }
        }
        for (int j = index + 1; j < bank.length(); j++) {
            int c = Character.getNumericValue(bank.charAt(j));
            if (c > highest_second_num) {
                highest_second_num = c;
            }
        }
        return highest_first_num * 10 + highest_second_num;
    }

}

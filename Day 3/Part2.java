package Day3;

import java.nio.file.*;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.lang.Math;

public class Challenge2 {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("/Users/kialok/IdeaProjects/Day 1/src/Day3/input_day3.txt"));
            String[] arr = lines.toArray(new String[0]);
            long output = total_voltage(arr);
            System.out.println(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long total_voltage(String[] all_banks) {
        long acc = 0;
        for (String bank : all_banks) {
            acc += highest_voltage(bank);
        }
        return acc;
    }

    public static long highest_voltage(String bank) {
        int n = bank.length();
        int keep = 12;
        char[] stack = new char[keep];
        int top = 0;

        for (int i = 0; i < n; i++) {
            char c = bank.charAt(i);
            while (top > 0 && stack[top - 1] < c && n - i + top > keep) {
                top--;
            }
            if (top < keep) {
                stack[top++] = c;
            }
        }
        long result = 0;
        for (int i = 0; i < keep; i++) {
            result = result * 10 + (stack[i] - '0');
        }
        return result;
    }

}

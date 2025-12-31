package Day2;

import java.nio.file.*;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;


public class Challenge2 {
    public static void main(String[] args) {
        try {
            String content = Files.readString(Path.of("/Users/kialok/IdeaProjects/Day 1/src/Day2/raw_input_day_2.txt")).trim();
            List<String> list = Arrays.asList(content.split(","));
            String[] arr = list.toArray(new String[0]);
            long result = invalid(arr);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long invalid(String[] input) {
        long acc = 0;
        for (String n : input) {
            long[] rangeArr = range(n);
            for (long i = rangeArr[0]; i <= rangeArr[1]; i++) {
                acc += invalid_checker(i);
            }
        }
        return acc;
    }

    public static long invalid_checker(long number) {
        String num = String.valueOf(number);
        for (int i = 1; i <= num.length() / 2; i++) {
            if (num.length() % i == 0) {
                String pattern = num.substring(0, i);
                boolean is_pattern = true;
                for (int j = i; j <= num.length() - i; j = j + i) {
                    if (!num.substring(j, j + i).equals(pattern)) {
                        is_pattern = false;
                        break;
                    }
                }
                if (is_pattern) {
                    return number;
                }
            }
        }
        return 0;
    }

    public static long[] range(String rawRange) {
        String[] parts = rawRange.split("-");
        long lower = Long.parseLong(parts[0]);
        long upper = Long.parseLong(parts[1]);
        long[] returnArr = {lower, upper};
        return returnArr;
    }
}

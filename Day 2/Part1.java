package Day2;
import java.nio.file.*;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;


public class Challenge1 {
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
        if (num.length() % 2 == 1) {
            return 0;
        } else {
            String substringone = num.substring(0, num.length() / 2);
            String substringtwo = num.substring(num.length() / 2, num.length());
            if (substringone.equals(substringtwo)) {
                return number;
            } else {
                return 0;
            }
        }
    }

    public static long[] range(String rawRange) {
        String[] parts = rawRange.split("-");
        long lower = Long.parseLong(parts[0]);
        long upper = Long.parseLong(parts[1]);
        long[] returnArr = {lower, upper};
        return returnArr;
    }
}



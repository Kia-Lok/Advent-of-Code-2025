package Day6;

import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class Challenge2 {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines( Paths.get("/Users/kialok/IdeaProjects/Day 1/src/Day6/input_day6.txt") );
            String[] arr = lines.toArray(new String[0]);
            List<String[]> split = new ArrayList<>();
            for (String entry : arr) {
                String[] result = entry.split(" ");
                split.add(result);
            }
            int acc = 0;
            for (int i = 0; i < split.get(0).length; i++) {
                acc += process(split, i);
            }
            System.out.println(acc);
        } catch (IOException e) {
            e.printStackTrace();
        }

    } public static int process(List<String[]> arr, int index) {
        int len = arr.size();
        String op = arr.get(len - 1)[index];
        int acc = Integer.parseInt(arr.get(0)[index]);
        for (int i = 1; i < len - 1; i++) {
            if (op.equals("+")) {
                acc += Integer.parseInt(arr.get(i)[index]);
            } else {
                acc *= Integer.parseInt(arr.get(i)[index]);
            }
        }
        return acc;
    }
}

package Day7;

import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class Challenge1 {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("/Users/kialok/IdeaProjects/Day 1/src/Day7/input_day7.txt"));
            String[] arr = lines.toArray(new String[0]);
            int start = 0;
            for (int i = 0; i < arr[0].length(); i++) {
                if (arr[0].charAt(i) == 'S') {
                    start = i;
                    break;
                }
            }
            long result = traversal(arr, 0, start);
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Map<String, Long> memo = new HashMap<>();

    public static long traversal(String[] arr, int i, int j) {
        if (j < 0 || j >= arr[i].length()) return 0;

        String key = i + "," + j;
        if (memo.containsKey(key)) return memo.get(key);

        if (i == arr.length - 1) return 1;

        char node = arr[i + 1].charAt(j);
        long result;

        if (node == '.') {
            result = traversal(arr, i + 1, j);
        } else {
            result =
                    traversal(arr, i + 1, j + 1)
                    + traversal(arr, i + 1, j - 1);
        }

        memo.put(key, result);
        return result;
    }
}

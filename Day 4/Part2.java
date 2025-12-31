package Day4;

import java.nio.file.*;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.lang.Math;
import java.lang.String;
import java.util.ArrayList;

public class Challenge2 {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(
                    Paths.get("/Users/kialok/IdeaProjects/Day 1/src/Day4/input_day4.txt")
            );
            List<List<Character>> grid = new ArrayList<>();
            int len = lines.get(0).length();
            List<Character> buffer_row = new ArrayList<>();
            for (int i = 0; i < len + 2; i++) {
                buffer_row.add('.');
            }
            grid.add(buffer_row);
            for (String line : lines) {
                List<Character> row = new ArrayList<>();
                row.add('.');
                for (char c : line.toCharArray()) {
                    row.add(c);
                }
                row.add('.');
                grid.add(row);
            }
            grid.add(buffer_row);

            int length = grid.size();
            int acc = 0;
            int result_from_loop = 1;
            while (result_from_loop > 0) {
                int storage = 0;
                for (int i = 1; i < length - 1; i++) {
                    for (int j = 1; j < length - 1; j++) {
                        if (grid.get(i).get(j) == '@') {
                             storage += checker(i, j, grid);
                        }
                    }
                }
                acc += storage;
                result_from_loop = storage;
            }
            System.out.println(acc);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int checker(int i, int j, List<List<Character>> grid) {
        int acc = -1;
        for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {
                if (grid.get(x).get(y) == '@') {
                    acc++;
                }
            }
        }
        if (acc < 4) {
            List<Character> row = grid.get(i);
            row.set(j, '.');
            grid.set(i, row);
            return 1;
        } else {
            return 0;
        }
    }
}

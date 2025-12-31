package Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day_1_Problem_2 {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("/Users/kialok/IdeaProjects/Day 1/src/input.txt"));
            String[] arr = lines.toArray(new String[0]);
            int output = rotate_password(arr);
            System.out.println(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int rotate_password(String[] input) {
        int counter = 0;
        int dial = 50;

        for (String n : input) {
            String dir = n.substring(0, 1);
            int steps = Integer.parseInt(n.substring(1));
            for (int i = 0; i < steps; i++) {
                if (dir.equals("R")) {
                    dial = (dial + 1) % 100;
                } else {
                    dial = (dial - 1 + 100) % 100;
                }
                if (dial == 0) counter++;
            }
        }

        return counter;
    }
}

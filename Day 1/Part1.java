package Day1;
import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class Day_1_Problem_1 {
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
            String direction = n.substring(0, 1);
            String inter = n.substring(1);
            int revolve = Integer.parseInt(inter) % 100;
            if (direction.equals("R")) {
                dial = (dial + revolve) % 100;
            } else { // "L"
                dial = (dial - revolve + 100) % 100;
            }
            if (dial == 0) {
                counter = counter + 1;
            }
        }
        return counter;
    }
}

import java.util.List;
import java.util.Arrays;
import java.lang.Math;
import java.lang.String;
import java.util.ArrayList;

public class Challenge1 {
    public static void main(String[] args) {
        try {
            int acc = 0;
            List<String> ranges = Files.readAllLines(
                    Paths.get("/Users/kialok/IdeaProjects/Day 1/src/Day5/range.txt")
            );
            String[] range_arr = ranges.toArray(new String[0]);
            List<String> items = Files.readAllLines(
                    Paths.get("/Users/kialok/IdeaProjects/Day 1/src/Day5/item.txt")
            );
            String[] item_arr = items.toArray(new String[0]);
            for (String item_str : item_arr) {
                long item_id = Long.parseLong(item_str);
                acc += item_checker(range_arr, item_id);
            }
            System.out.println(acc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int item_checker(String[] all_range, long id) {
        for (String range : all_range) {
            String[] rangeNum = range.split("-");
            if (id < Long.parseLong(rangeNum[0]) || id > Long.parseLong(rangeNum[1])) {
                continue;
            } else {
                return 1;
            }
        }
        return 0;
    }

}

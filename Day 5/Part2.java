package Day5;

import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class Challenge2 {

    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(
                    Paths.get("/Users/kialok/IdeaProjects/Day 1/src/Day5/range.txt")
            );
            List<long[]> ranges = new ArrayList<>();
            for (String line : lines) {
                String[] parts = line.split("-");
                long start = Long.parseLong(parts[0].trim());
                long end = Long.parseLong(parts[1].trim());
                ranges.add(new long[]{start, end});
            }

            ranges.sort(Comparator.comparingLong(a -> a[0]));

            List<long[]> merged = new ArrayList<>();
            for (long[] range : ranges) {
                if (merged.isEmpty()) {
                    merged.add(range);
                } else {
                    long[] last = merged.get(merged.size() - 1);
                    if (range[0] <= last[1] + 1) {
                        last[1] = Math.max(last[1], range[1]);
                    } else {
                        merged.add(range);
                    }
                }
            }
            long totalFresh = 0;
            for (long[] range : merged) {
                totalFresh += range[1] - range[0] + 1;
            }
            System.out.println(totalFresh);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package Day6;

import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class Challenge1 {

    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(
                    Paths.get("/Users/kialok/IdeaProjects/Day 1/src/Day6/input_day6.txt")
            );
            if (lines.isEmpty()) {
                System.out.println(0);
                return;
            }
            int rows = lines.size();
            int cols = 0;
            for (String line : lines) cols = Math.max(cols, line.length());
            char[][] grid = new char[rows][cols];
            for (int r = 0; r < rows; r++) {
                String line = String.format("%-" + cols + "s", lines.get(r));
                for (int c = 0; c < cols; c++) grid[r][c] = line.charAt(c);
            }

            List<int[]> problems = new ArrayList<>();
            boolean inProblem = false;
            int start = -1;
            for (int c = 0; c < cols; c++) {
                boolean blank = true;
                for (int r = 0; r < rows; r++) {
                    if (grid[r][c] != ' ') { blank = false; break; }
                }
                if (!blank && !inProblem) {
                    inProblem = true;
                    start = c;
                } else if (blank && inProblem) {
                    problems.add(new int[]{start, c - 1});
                    inProblem = false;
                }
            }
            if (inProblem) problems.add(new int[]{start, cols - 1});

            long grandTotal = 0;
            for (int p = problems.size() - 1; p >= 0; p--) {
                int[] range = problems.get(p);
                long problemValue = evaluateProblem(grid, rows, range[0], range[1]);
                grandTotal += problemValue;
            }

            System.out.println(grandTotal);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static long evaluateProblem(char[][] grid, int rows, int startCol, int endCol) {
        List<Long> numbers = new ArrayList<>();
        char op = ' ';
        for (int c = startCol; c <= endCol; c++) {
            if (grid[rows - 1][c] == '+' || grid[rows - 1][c] == '*') {
                op = grid[rows - 1][c];
                break;
            }
        }
        if (op == ' ') op = '+';
        boolean[] counted = new boolean[endCol - startCol + 1];
        for (int c = startCol; c <= endCol; c++) {
            if (counted[c - startCol]) continue;
            boolean hasDigit = false;
            for (int r = 0; r < rows - 1; r++) {
                if (Character.isDigit(grid[r][c])) { hasDigit = true; break; }
            }
            if (!hasDigit) continue;

            long number = 0;
            for (int r = 0; r < rows - 1; r++) {
                char ch = grid[r][c];
                if (Character.isDigit(ch)) {
                    number = number * 10 + (ch - '0');
                }
            }
            numbers.add(number);
            counted[c - startCol] = true;
        }

        if (numbers.isEmpty()) return 0;
        long result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (op == '+') result += numbers.get(i);
            else result *= numbers.get(i);
        }

        return result;
    }

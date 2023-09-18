import java.util.*;
import java.util.Map.Entry;

public class TimetableUtils {

    // Utility function to calculate the cost of subjects' order
    public static double subjectsOrderCost(Map<String, int[]> subjectsOrder) {
            }

    // Utility function to calculate empty space cost for groups.Calculates total empty space of all groups for week, maximum empty space in day and average empty space for whole
    //week per group.
    public static double emptySpaceGroupsCost(Map<Integer, List<Integer>> groupsEmptySpace) {
        double totalCost = 0;
        double maxEmptyPerDay = 0;

        for (List<Integer> emptySpace : groupsEmptySpace.values()) {
            Collections.sort(emptySpace);

            Map<Integer, Integer> emptyPerDay = new HashMap<>();
            for (int i = 1; i < emptySpace.size(); i++) {
                int a = emptySpace.get(i - 1);
                int b = emptySpace.get(i);
                int diff = b - a;

                if (a / 12 == b / 12 && diff > 1) {
                    int day = a / 12;
                    emptyPerDay.put(day, emptyPerDay.getOrDefault(day, 0) + diff - 1);
                    totalCost += diff - 1;
                }
            }

            for (int empty : emptyPerDay.values()) {
                if (empty > maxEmptyPerDay) {
                    maxEmptyPerDay = empty;
                }
            }
        }

        return totalCost;
    }

    // Utility function to calculate empty space cost for teachers
    public static double emptySpaceTeachersCost(Map<String, List<Integer>> teachersEmptySpace) {
        double totalCost = 0;
        double maxEmptyPerDay = 0;

        for (List<Integer> emptySpace : teachersEmptySpace.values()) {
            Collections.sort(emptySpace);

            Map<Integer, Integer> emptyPerDay = new HashMap<>();
            for (int i = 1; i < emptySpace.size(); i++) {
                int a = emptySpace.get(i - 1);
                int b = emptySpace.get(i);
                int diff = b - a;

                if (a / 12 == b / 12 && diff > 1) {
                    int day = a / 12;
                    emptyPerDay.put(day, emptyPerDay.getOrDefault(day, 0) + diff - 1);
                    totalCost += diff - 1;
                }
            }

            for (int empty : emptyPerDay.values()) {
                if (empty > maxEmptyPerDay) {
                    maxEmptyPerDay = empty;
                }
            }
        }

        return totalCost;
    }

    // Utility function to find free hour in the timetable
    public static String findFreeHour(int[][] matrix) {
        String[] days = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
        int[] hours = { 9, 10, 11, 12, 13, 14, 15, 16, 17};

        for (int i = 0; i < matrix.length; i++) {
            boolean empty = true;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != -1) {
                    empty = false;
                    break;
                }
            }
            if (empty) {
                int dayIndex = i / 12;
                int hourIndex = i % 12;
                return days[dayIndex] + ": " + hours[hourIndex];
            }
        }

        return "-1"; // No free hour found
    }
}

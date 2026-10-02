import java.util.*;

public class Day98 {

    static int[][] merge(int[][] intervals) {

        // Sort by starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {

            // No overlap
            if (result.isEmpty() ||
                result.get(result.size() - 1)[1] < interval[0]) {

                result.add(interval);
            } 
            else {
                // Merge overlapping intervals
                int[] previous = result.get(result.size() - 1);
                previous[1] = Math.max(previous[1], interval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of intervals
        int n = sc.nextInt();

        int[][] intervals = new int[n][2];

        // Input intervals
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        int[][] result = merge(intervals);

        // Print result
        for (int[] interval : result) {
            System.out.println(interval[0] + " " + interval[1]);
        }

        sc.close();
    }
}
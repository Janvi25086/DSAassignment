import java.util.*;

public class Day97 {

    public static int minMeetingRooms(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Min-heap stores end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {

            // Reuse room if meeting has ended
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }

            // Add current meeting's end time
            minHeap.add(intervals[i][1]);
        }

        return minHeap.size();
    }

    public static void main(String[] args) {

        int[][] intervals = {
                { 0, 30 },
                { 5, 10 },
                { 15, 20 }
        };

        int result = minMeetingRooms(intervals);

        System.out.println("Minimum rooms required: " + result);
    }
}
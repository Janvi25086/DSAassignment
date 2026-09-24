import java.util.*;

class Day90 {

    // Check if all boards can be painted by at most k painters
    // when each painter can paint at most maxTime units.
    static boolean canPaint(int[] boards, int k, long maxTime) {

        int painters = 1;
        long currentTime = 0;

        for (int board : boards) {

            if (currentTime + board > maxTime) {
                painters++;
                currentTime = 0;
            }

            currentTime += board;
        }

        return painters <= k;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] boards = new int[n];

        long left = 0;
        long right = 0;

        for (int i = 0; i < n; i++) {
            boards[i] = sc.nextInt();

            // One painter cannot paint less than the
            // largest single board.
            left = Math.max(left, boards[i]);

            // One painter could paint all boards.
            right += boards[i];
        }

        // More painters than boards is not possible
        // because each painter must get a contiguous group.
        if (k > n) {
            System.out.println(-1);
            return;
        }

        long answer = right;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            if (canPaint(boards, k, mid)) {

                // This maximum time is possible.
                // Try to reduce it.
                answer = mid;
                right = mid - 1;

            } else {

                // We need more time per painter.
                left = mid + 1;
            }
        }

        System.out.println(answer);

        sc.close();
    }
}
import java.util.*;

class Day88 {

    // Check if k cows can be placed
    // with at least 'distance' between them
    static boolean canPlace(int[] stalls, int k, int distance) {

        int cows = 1;
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {

            if (stalls[i] - lastPosition >= distance) {
                cows++;
                lastPosition = stalls[i];

                if (cows == k) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] stalls = new int[n];

        for (int i = 0; i < n; i++) {
            stalls[i] = sc.nextInt();
        }

        // Sort stall positions
        Arrays.sort(stalls);

        int left = 1;
        int right = stalls[n - 1] - stalls[0];
        int answer = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (canPlace(stalls, k, mid)) {
                // mid is possible, try a larger distance
                answer = mid;
                left = mid + 1;
            } else {
                // mid is not possible
                right = mid - 1;
            }
        }

        System.out.println(answer);

        sc.close();
    }
}
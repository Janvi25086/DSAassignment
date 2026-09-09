import java.util.*;

class Day75 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        // Prefix sum 0 exists before the array starts
        map.put(0, -1);

        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                // Same prefix sum means subarray sum is zero
                int length = i - map.get(sum);
                maxLength = Math.max(maxLength, length);
            } else {
                // Store only the first occurrence
                map.put(sum, i);
            }
        }

        System.out.println(maxLength);
    }
}
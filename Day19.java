import java.util.*;

class Day19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Sort the array
        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;

        int minSum = Integer.MAX_VALUE;
        int first = arr[0], second = arr[1];

        // Two-pointer approach
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                first = arr[left];
                second = arr[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        // Print the pair
        System.out.println(first + " " + second);

        sc.close();
    }
}
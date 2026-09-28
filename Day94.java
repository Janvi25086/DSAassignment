public class Day94 {

    public static void countingSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        // 1. Find maximum element
        int max = arr[0];

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        // 2. Create frequency array
        int[] count = new int[max + 1];

        // 3. Store frequencies
        for (int num : arr) {
            count[num]++;
        }

        // 4. Compute prefix sums
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // 5. Build output array
        int[] output = new int[arr.length];

        // Traverse from right to left to maintain stability
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            output[count[num] - 1] = num;
            count[num]--;
        }

        // Copy output back to original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};

        countingSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
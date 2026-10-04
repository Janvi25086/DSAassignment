import java.util.*;

public class Day100 {

    static int[] countSmaller(int[] nums) {
        int n = nums.length;

        int[] result = new int[n];
        int[] index = new int[n];
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        mergeSort(nums, index, temp, result, 0, n - 1);

        return result;
    }

    static void mergeSort(int[] nums, int[] index, int[] temp,
                          int[] result, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(nums, index, temp, result, left, mid);
        mergeSort(nums, index, temp, result, mid + 1, right);

        merge(nums, index, temp, result, left, mid, right);
    }

    static void merge(int[] nums, int[] index, int[] temp,
                      int[] result, int left, int mid, int right) {

        int i = left;
        int j = mid + 1;
        int k = left;
        int smaller = 0;

        while (i <= mid && j <= right) {

            if (nums[index[j]] < nums[index[i]]) {
                smaller++;
                temp[k++] = index[j++];
            } else {
                result[index[i]] += smaller;
                temp[k++] = index[i++];
            }
        }

        while (i <= mid) {
            result[index[i]] += smaller;
            temp[k++] = index[i++];
        }

        while (j <= right) {
            temp[k++] = index[j++];
        }

        for (int x = left; x <= right; x++) {
            index[x] = temp[x];
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] result = countSmaller(nums);

        for (int x : result) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}
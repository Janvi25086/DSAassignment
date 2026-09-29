import java.util.*;

class Day95 {

    static void bucketSort(double[] arr) {

        int n = arr.length;

        // Create buckets
        ArrayList<ArrayList<Double>> buckets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribute elements into buckets
        for (double num : arr) {
            int index = (int) (num * n);
            buckets.get(index).add(num);
        }

        // Sort each bucket
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets.get(i));
        }

        // Concatenate buckets
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (double num : buckets.get(i)) {
                arr[index++] = num;
            }
        }
    }

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    double[] arr = new double[n];

    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextDouble();
    }

    bucketSort(arr);

    for (double num : arr) {
        System.out.print(num + " ");
    }

    sc.close();
}
import java.util.Scanner;
import java.util.LinkedHashMap;

class Day16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        // Store frequencies while preserving insertion order
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        // Read array elements
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Print frequencies
        for (int key : map.keySet()) {
            System.out.print(key + ":" + map.get(key) + " ");
        }

        sc.close();
    }
}
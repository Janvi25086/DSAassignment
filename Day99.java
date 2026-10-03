import java.util.*;

public class Day99 {

    static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort by position in descending order
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        int fleets = 0;
        double lastTime = 0.0;

        for (int i = 0; i < n; i++) {
            int pos = cars[i][0];
            int spd = cars[i][1];

            // Time to reach target
            double time = (double) (target - pos) / spd;

            // Forms a new fleet
            if (time > lastTime) {
                fleets++;
                lastTime = time;
            }
        }

        return fleets;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();
        int n = sc.nextInt();

        int[] position = new int[n];
        int[] speed = new int[n];

        for (int i = 0; i < n; i++) {
            position[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            speed[i] = sc.nextInt();
        }

        System.out.println(carFleet(target, position, speed));

        sc.close();
    }
}
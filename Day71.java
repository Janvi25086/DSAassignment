import java.util.*;

public class Day71 {

    static int[] table;
    static int m;

    static void insert(int key) {
        int hash = key % m;

        for (int i = 0; i < m; i++) {
            int index = (hash + i * i) % m;

            if (table[index] == -1) {
                table[index] = key;
                return;
            }
        }
    }

    static boolean search(int key) {
        int hash = key % m;

        for (int i = 0; i < m; i++) {
            int index = (hash + i * i) % m;

            if (table[index] == key) {
                return true;
            }

            if (table[index] == -1) {
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int q = sc.nextInt();

        Day71.m = m;

        table = new int[m];
        Arrays.fill(table, -1);

        for (int i = 0; i < q; i++) {

            String operation = sc.next();
            int key = sc.nextInt();

            if (operation.equals("INSERT")) {
                insert(key);
            }
            else if (operation.equals("SEARCH")) {
                if (search(key)) {
                    System.out.println("FOUND");
                } else {
                    System.out.println("NOT FOUND");
                }
            }
        }

        sc.close();
    }
}
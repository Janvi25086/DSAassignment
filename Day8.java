import java.util.Scanner;

class Day8 {

    // Recursive function to calculate a^b
    static int power(int a, int b) {
        if (b == 0)
            return 1;

        return a * power(a, b - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(power(a, b));

        sc.close();
    }
}
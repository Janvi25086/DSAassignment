import java.util.*;

public class Day72 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        boolean[] seen = new boolean[26];

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (seen[ch - 'a']) {
                System.out.println(ch);
                return;
            }

            seen[ch - 'a'] = true;
        }

        System.out.println(-1);

        sc.close();
    }
}
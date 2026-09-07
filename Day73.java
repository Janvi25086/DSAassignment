import java.util.*;

class Day73 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Find first non-repeating character
        char result = '$';

        for (char ch : s.toCharArray()) {
            if (freq[ch - 'a'] == 1) {
                result = ch;
                break;
            }
        }

        System.out.println(result);
    }
}

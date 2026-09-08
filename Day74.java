import java.util.*;

class Day74 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<String, Integer> votes = new HashMap<>();

        // Count votes
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            votes.put(name, votes.getOrDefault(name, 0) + 1);
        }

        String winner = "";
        int maxVotes = 0;

        // Find winner
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            String name = entry.getKey();
            int count = entry.getValue();

            if (count > maxVotes ||
                (count == maxVotes && name.compareTo(winner) < 0)) {
                winner = name;
                maxVotes = count;
            }
        }

        System.out.println(winner + " " + maxVotes);
    }
}
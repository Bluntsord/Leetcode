package Interview.GoldMan;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Goldman {

    public static void main(String[] args) {
        int[] temp = new int[]{2,2,3,4,5};
        List<Integer> another = Arrays.stream(temp).boxed().collect(Collectors.toList());
        int answer = numPlayers(4, another);
        System.out.println(answer);
    }

    public static int numPlayers(int k, List<Integer> scores) {
        // Write your code here
        List<Integer> scoresSorted = scores.stream().sorted((x, y) -> y - x).collect(Collectors.toList());
        int rank = 1;
        int previous = Integer.MIN_VALUE;
        int answer = 0;
        for (int i = 0; i < scoresSorted.size(); i++) {

            int curr = scoresSorted.get(i);
            if (curr == previous) {
                answer += 1;
            } else if (rank > k) {
                return answer;
            } else {
                answer += 1;
                rank += 1;
            }
            previous = curr;
        }

        return answer;
    }
}

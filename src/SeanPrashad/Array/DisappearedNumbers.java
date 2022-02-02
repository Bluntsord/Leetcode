package SeanPrashad.Array;

import java.util.*;

public class DisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(x -> set.add(x));
        for (int i = 1; i < nums.length + 1; i++) {
            if (!set.contains(i)) {
                answer.add(i);
            }
        }

        return answer;
    }
}

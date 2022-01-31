package LeetCodePatterns.Array;

import java.util.Arrays;
import java.util.List;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        List<Integer> temp = Arrays.stream(nums).boxed().toList();
        for (int i = 0; i < nums.length; i++) {
            if (!temp.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}

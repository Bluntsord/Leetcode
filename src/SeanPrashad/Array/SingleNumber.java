package SeanPrashad.Array;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (map.containsKey(curr)) {
                map.remove(curr);
            } else {
                map.put(curr, 1);
            }
        }

        List<Integer> answer = map.keySet().stream().collect(Collectors.toList());
        return answer.get(0);
    }
}

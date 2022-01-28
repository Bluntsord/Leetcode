package Microsoft.Microsoft1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumberOfTimes {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int curr: nums) {
            if (!map.containsKey(curr)) {
                map.put(curr, 1);
            }

            map.replace(curr, map.get(curr));
        }

        map.forEach((key, value) -> {
            if (value > Math.floor(nums.length/3))
                answer.add(key);
        });

        return answer;
    }
}

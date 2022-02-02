package LeetCodePatterns;

import java.util.HashSet;

public class ContainsDup {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.contains(nums[i])) {
                map.add(nums[i]);
            } else {
                return true;
            }
        }
        return false;
    }
}

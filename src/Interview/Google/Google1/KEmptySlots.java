package Interview.Google.Google1;

import java.util.TreeSet;

public class KEmptySlots {

    public int kEmptySlots(int[] bulbs, int k) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        int day = 1;
        for (int bulb: bulbs) {
            treeSet.add(bulb);
            Integer low = treeSet.lower(bulb);
            Integer high = treeSet.higher(bulb);
            if (low != null && bulb - low - 1 == k) {
                return day;
            } else if (high != null && high - bulb - 1 == k) {
                return day;
            }
            day += 1;
        }

        return -1;
    }
}

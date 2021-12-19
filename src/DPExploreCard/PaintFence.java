package DPExploreCard;

import java.util.HashMap;

public class PaintFence {
    private HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    private int variations;

//    public static void main(String[] args) {
//        PaintFence paintFence = new PaintFence();
//        System.out.println(paintFence.numWays(7,2));
//    }

    public int numWays(int n, int k) {
        this.variations = k;
        return dp(n);
    }

    public int dp(int fencesPointer) {
        if (fencesPointer == 1) {
            return variations;
        } else if (fencesPointer == 2) {
            return variations * variations;
        } else if (memo.containsKey(fencesPointer)) {
            return memo.get(fencesPointer);
        }

        int diffColor = dp(fencesPointer - 1) * (variations - 1);
        int sameColor = dp(fencesPointer - 2) * (variations - 1);
        int wish = sameColor + diffColor;
        memo.put(fencesPointer, wish);
        return wish;
    }
}
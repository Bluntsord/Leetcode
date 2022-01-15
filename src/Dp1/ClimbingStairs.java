package Dp1;

import java.util.HashMap;

public class ClimbingStairs {


    HashMap<Integer, Integer> memo;

    public int climbStairs(int n) {
        this.memo = new HashMap<>();
        this.memo.put(0, 0);
        this.memo.put(1, 1);
        return dp(n);
    }

    public int dp(int number) {
        if (number < 0) {
            return 0;
        } else if (memo.containsKey(number)) {
            return this.memo.get(number);
        }

        int firstWish = dp(number - 1);
        int secondWish = dp(number - 2);
        int currentWish = firstWish + secondWish;

        this.memo.remove(number - 2);
        this.memo.put(number, currentWish);

        return currentWish;
    }
}

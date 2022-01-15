package Dp1;

import java.util.HashMap;

public class MinCostClimbingStairs {

    int[] cost;
    HashMap<Integer, Integer> memo;

    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        int[] tempArr = new int[]{10, 15, 20};
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(tempArr));
    }

    public int minCostClimbingStairs(int[] costs) {
        this.cost = new int[costs.length + 2];
        for (int i = 0; i < costs.length; i++) {
            this.cost[i + 1] = costs[i];
        }

        this.memo = new HashMap<>();
        this.memo.put(0, 0);
        return dp(this.cost.length - 1);
    }

    public int dp(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return Math.max(this.cost[0], this.cost[1]);
        } else if (this.memo.containsKey(n)) {
            return this.memo.get(n);
        }

        int firstWish = this.cost[n - 1] + dp(n - 1);
        int secondWish = this.cost[n - 2] + dp(n - 2);
        int current = Math.min(firstWish, secondWish);

        this.memo.put(n, current);
        return current;
    }
}

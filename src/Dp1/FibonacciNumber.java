package Dp1;

import java.util.HashMap;

public class FibonacciNumber {

    HashMap<Integer, Integer> memo;
    public int fib(int n) {
        this.memo = new HashMap<>();
        this.memo.put(0, 0);
        this.memo.put(1, 1);
        this.memo.put(2, 1);
        return dp(n);
    }


    public int dp(int n) {
        if (this.memo.containsKey(n)) {
            return this.memo.get(n);
        }

        int firstWish = dp(n - 1);
        int secondWish = dp(n - 2);
        int thirdWish = dp(n - 3);
        int currentWish = firstWish + secondWish + thirdWish;

        this.memo.remove(n - 3);
        this.memo.put(n, currentWish);

        return currentWish;
    }
}

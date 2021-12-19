package DPExploreCard;

import java.util.HashMap;

public class CoinChange2 {
    HashMap<String, Integer> memo;
    int[] coins;

    public static void main(String[] args) {
        CoinChange2 change2 = new CoinChange2();
        int[] tempArr = new int[]{1, 2, 5, 10};
        System.out.println(change2.change(10, tempArr));
    }

    public int change(int amount, int[] coins) {
        this.coins = coins;
        this.memo = new HashMap<>();
        return dp(amount, 0);
    }

    public int dp(int amountLeft, int coinPointer) {
        if (amountLeft == 0) {
            return 1;
        } else if (amountLeft < 0 || coinPointer >= coins.length) {
            return 0;
        }

        String key = Integer.toString(amountLeft) + "|" + Integer.toString(coinPointer);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int currentCoin = coins[coinPointer];
        int numberOfCoins = 0;
        int wish = 0;
        while (currentCoin * numberOfCoins <= amountLeft) {
            wish += dp(amountLeft - currentCoin * numberOfCoins, coinPointer + 1);
            numberOfCoins += 1;
        }
        memo.put(key, wish);
        return wish;
    }

}

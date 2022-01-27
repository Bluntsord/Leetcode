package DP4;

public class BestTimeToBuySellStock4 {


    int[] prices;
    int[][][] memo;

    public static void main(String[] args) {
        int[] prices = new int[]{3, 2, 6, 5, 0, 3};
        BestTimeToBuySellStock4 bestTimeToBuySellStock4 = new BestTimeToBuySellStock4();
        int answer = bestTimeToBuySellStock4.maxProfit(2, prices);
        System.out.println(answer);
    }

    public int maxProfit(int k, int[] prices) {
        this.prices = prices;
        this.memo = new int[prices.length][k + 1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < k + 1; j++) {
                for (int w = 0; w < 2; w++) {
                    memo[i][j][w] = -1;
                }
            }
        }

        return dp(0, k, 0);
    }

    public int dp(int currentDay, int transactionsLeft, int isSelling) {
        if (currentDay >= prices.length || transactionsLeft <= 0) {
            return 0;
        } else if (memo[currentDay][transactionsLeft][isSelling] != -1) {
            return memo[currentDay][transactionsLeft][isSelling];
        }

        int currentPrice = prices[currentDay];
        int doNothing = dp(currentDay + 1, transactionsLeft, isSelling);
        int doTransaction = isSelling == 0
                ? -currentPrice + dp(currentDay + 1, transactionsLeft, isSelling ^ 1)
                : currentPrice + dp(currentDay + 1, transactionsLeft - 1, isSelling ^ 1);
        int wish = Math.max(doNothing, doTransaction);
        this.memo[currentDay][transactionsLeft][isSelling] = wish;

        return wish;
    }
}

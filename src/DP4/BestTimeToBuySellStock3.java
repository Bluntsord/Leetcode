package DP4;

public class BestTimeToBuySellStock3 {

    int[] prices;
    int[][][]memo;
    int answer;

    public static void main(String[] args) {
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        int[] prices2 = new int[]{1,2,3,4,5};
        BestTimeToBuySellStock3 bestTimeToBuySellStock3 = new BestTimeToBuySellStock3();
        int answer = bestTimeToBuySellStock3.maxProfit(prices2);
        System.out.println(answer);
    }

    public int maxProfit(int[] prices) {
        this.prices = prices;
        this.memo = new int[prices.length][3][2];
        this.answer = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 2; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }

        return dp(0, 2, 0);
    }

    public int dp(int currentDay, int transactionsLeft, int isSelling) {
        if (currentDay >= prices.length || transactionsLeft <= 0) {
            return 0;
        } else if (memo[currentDay][transactionsLeft][isSelling] != -1) {
            return memo[currentDay][transactionsLeft][isSelling];
        }

        int currentPrice = prices[currentDay];
        int doNothing = dp(currentDay + 1, transactionsLeft, isSelling);
        int performTransaction = isSelling == 0
                ? -currentPrice + dp(currentDay + 1, transactionsLeft, isSelling ^ 1)
                : currentPrice + dp(currentDay + 1, transactionsLeft - 1, isSelling ^ 1);
        int wish = Math.max(doNothing, performTransaction);
        memo[currentDay][transactionsLeft][isSelling] = wish;

        return wish;
    }
}

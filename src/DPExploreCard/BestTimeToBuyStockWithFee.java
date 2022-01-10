package DPExploreCard;

public class BestTimeToBuyStockWithFee {

    int[][] memo;
    int[] prices;
    int fee;

    public static void main(String[] args) {
        BestTimeToBuyStockWithFee bestTimeToBuyStockWithFee = new BestTimeToBuyStockWithFee();
        int[] tempArr = new int[]{1,3,2,8,4,9 };
        System.out.println(bestTimeToBuyStockWithFee.maxProfit(tempArr, 2));
    }

    public int maxProfit(int[] prices, int fee) {
        this.prices = prices;
        this.memo = new int[prices.length][2];
        this.fee = fee;

        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < 2; j++) {
                memo[i][j] = -1;
            }
        }

        return dp(0, 0);
    }

    public int dp(int currentDay, int isSelling) {
        if (currentDay >= this.prices.length) {
            return 0;
        } else if (memo[currentDay][isSelling] != -1) {
            return memo[currentDay][isSelling];
        }

        int currentPrice = prices[currentDay];
        int wish;

        if (isSelling == 1) {
            int sell = currentPrice + dp(currentDay + 1, 0);
            int noSell = dp(currentDay + 1, 1);
            wish = Math.max(sell, noSell);
            wish = wish < 0 ? 0: wish;
        } else {
            int buy = -fee - currentPrice + dp(currentDay + 1, 1);
            int noBuy = dp(currentDay + 1, 0);
            wish = Math.max(buy, noBuy);
        }

        this.memo[currentDay][isSelling] = wish;
        return wish;
    }
}

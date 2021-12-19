package DPExploreCard;

public class BestTimeToBuyStock {

    private int min;
    private int max;

    public static void main(String[] args) {
        int[] tempArr = new int[]{2,4,1};
        BestTimeToBuyStock bestTimeToBuyStock = new BestTimeToBuyStock();
        System.out.println(bestTimeToBuyStock.maxProfit(tempArr));
    }

    public int maxProfit(int[] nums) {
        // Init the values first
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            if (currentValue < min) {
                min = currentValue;
                max = Integer.MIN_VALUE;
            }
            max = Math.max(max, currentValue);
            int currentProfit = max - min;
            System.out.println(maxProfit);
            System.out.println(currentProfit);
            System.out.println("========================");
            maxProfit = Math.max(currentProfit, maxProfit);
        }

        this.max = max;
        this.min = min;
        System.out.println("Min is: " + min);
        System.out.println("Max is: " + max);
        return maxProfit;
    }
}

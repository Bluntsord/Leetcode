package DPExploreCard;

public class MaximumCircularSubArray {
    int[] nums;
    int maxSoFar;
    int[] memo;

    public static void main(String[] args) {
        MaximumCircularSubArray maximumCircularSubArray = new MaximumCircularSubArray();
        int[] arr = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        int[] temp = new int[]{1,-3, 2};
        System.out.println(maximumCircularSubArray.kadanesAlgo(temp));
    }

    public int kadanesAlgo(int[] nums) {
        this.nums = nums;
        this.maxSoFar = nums[0];
        this.memo = new int[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return dp(1, maxSoFar, 0);
    }

    public int dp(int pointer, int currentMax, int endPointer) {
        int nextPointer = process(pointer, nums.length);
        int nextEndPointer = process(endPointer, nums.length);
        if (pointer == endPointer && memo[pointer] != -1) {
            return memo[pointer];
        } else if (currentMax < 0) {
            return dp(pointer, 0, endPointer);
        }

        int currentNumber = nums[pointer];
        maxSoFar = Math.max(maxSoFar, currentNumber + currentMax);
        int takeCurrent = dp(nextPointer, currentNumber + currentMax, endPointer);
        int resetCurrent = dp(nextPointer, currentNumber + currentMax, nextEndPointer);
        int currentWish = Math.max(takeCurrent, resetCurrent);
        memo[pointer] = currentWish;
        return currentWish;
    }

    private static int process(int number, int len) {
        return (number + 1) % len;
    }
}

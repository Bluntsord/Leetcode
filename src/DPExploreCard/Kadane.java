package DPExploreCard;

public class Kadane {

    int[] nums;

    public static void main(String[] args) {
        Kadane kadane = new Kadane();
        int[] arr = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        int[] temp = new int[]{-2, -1};
        System.out.println(kadane.kadanesAlgo(temp));
    }

    public int kadanesAlgo(int[] nums) {
        this.nums = nums;
        if (nums.length == 1) {
            return nums[0];
        }
        return dp(0, nums[0], 0);
    }

    public int dp(int pointer, int maxSoFar, int currentMax) {
        if (pointer >= nums.length) {
            return maxSoFar;
        } if (currentMax < 0) {
            return dp(pointer, maxSoFar, 0);
        }

        int currentNumber = nums[pointer];
        maxSoFar = Math.max(maxSoFar, currentNumber + currentMax);
        int takeCurrent = dp(pointer + 1, maxSoFar, currentNumber + currentMax);
        return takeCurrent;
    }
}


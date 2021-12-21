package Algo1;

import java.util.Arrays;

public class TwoSum {
    int[] nums;
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] tempArr = new int[]{2, 7, 11, 16};
        System.out.println(Arrays.toString(twoSum.twoSum(tempArr, 13)));
    }

    public int[] twoSum(int[] numbers, int target) {
        this.nums = numbers;
        int firstPointer = 0;
        int secondPointer = nums.length - 1;
        while (firstPointer < secondPointer) {
            int low = nums[firstPointer];
            int high = nums[secondPointer];
            int sum = low + high;
            if (sum < target) {
                firstPointer ++;
            } else if (sum > target) {
                secondPointer --;
            } else {
                return new int[]{firstPointer + 1, secondPointer + 1};
            }
        }
        return new int[]{firstPointer, secondPointer};
    }
}

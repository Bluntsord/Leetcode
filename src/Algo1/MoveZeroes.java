package Algo1;

import java.util.Arrays;

public class MoveZeroes {

    int[] nums;

    public static void main(String[] args) {
        int[] tempArr = new int[] {1,2,0,3,0,3,2,1};
        System.out.println(Arrays.toString(tempArr));
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(tempArr);
        System.out.println(Arrays.toString(tempArr));
    }

    public void moveZeroes(int[] nums) {
        this.nums = nums;
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            if (currentNumber != 0) {
                swap(i, pointer);
                pointer ++;
            }
        }
    }

    public void swap(int firstIndex, int secondIndex) {
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }
}

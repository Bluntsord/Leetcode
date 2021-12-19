package Recusion2;


import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] firstArr = new int[] {2,4,6,8};
        int[] secondArr = new int[] {1,3,5,7};
        int[] lastArr = new int[] {7,23,5,2};
        System.out.println(Arrays.toString(mergeSort.sortArray(lastArr)));
    }

    public int[] merge(int[] firstArr, int[] secondArr) {
        int firstPointer, secondPointer, finalPointer;
        firstPointer = secondPointer = finalPointer = 0;
        int[] finalArr = new int[firstArr.length + secondArr.length];

        for (int i = 0; i < finalArr.length; i++) {
            int firstCurrent = firstPointer < firstArr.length? firstArr[firstPointer]: Integer.MAX_VALUE;
            int secondCurrent = secondPointer < secondArr.length? secondArr[secondPointer]: Integer.MAX_VALUE;

            if (firstCurrent < secondCurrent) {
                finalArr[i] = firstCurrent;
                firstPointer++;
            } else {
                finalArr[i] = secondCurrent;
                secondPointer++;
            }
        }
        return finalArr;
    }

    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }

        int mid = nums.length/2;
        int[] firstArray = sortArray(Arrays.copyOfRange(nums, 0, mid));
        int[] secondArray = sortArray(Arrays.copyOfRange(nums, mid, nums.length));
        return merge(firstArray, secondArray);
    }


}

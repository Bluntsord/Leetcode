package Algo1;

public class BinarySearch {
    int[] nums;
    private int target;

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] tempArr = new int[] {1,3,5,6};
        System.out.println(binarySearch.searchInsert(tempArr, 5));
    }

    public int searchInsert(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return helper(0, nums.length - 1);
    }

    public int helper(int low, int high) {
        int mid = low + (high - low)/2;
        if (high == low && high == nums.length - 1) {
            if (nums.length == 1) {
                return target > nums[0]? 1:0;
            }
            return high + 1;
        } else if (low == high) {
            return low;
        }

        int currentNumber = nums[mid];
        int nextNumber = nums[mid + 1];
        if (target > currentNumber && target < nextNumber) {
            return mid + 1;
        } else if (target > currentNumber) {
            return helper(mid + 1, high);
        } else {
            return helper(low, mid);
        }
    }
}

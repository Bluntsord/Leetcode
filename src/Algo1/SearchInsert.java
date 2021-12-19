package Algo1;

public class SearchInsert {
    int[] nums;
    int target;

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        int[] tempArr = new int[] { 1,3,5,6};
        System.out.println(searchInsert.searchInsert(tempArr, 7));
    }

    public int searchInsert(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return binarySearch(0, nums.length - 1);
    }

    public int binarySearch(int low, int high) {
        int mid = low + (high - low)/2;
        int currentNumber = nums[mid];
        if (nums.length == 1) {
            return target > currentNumber? 1: 0;
        } else if (low == high && currentNumber != target) {
            if (low == nums.length - 1) {
                return low + 1;
            }
            return low;
        } else if (low == high) {
            return low;
        } else if (target > currentNumber) {
            return binarySearch(mid + 1, high);
        } else {
            return binarySearch(low, mid);
        }
    }
}

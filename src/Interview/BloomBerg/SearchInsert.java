package Interview.BloomBerg;

public class SearchInsert {

    int[] nums;
    int target;

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        int[] tempArr = new int[]{1,3,5,7};
        int annswer = searchInsert.searchInsert(tempArr, 4);
        System.out.println(annswer);
    }

    public int searchInsert(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return bs(0, nums.length - 1);
    }

    public int bs(int low, int high) {
        int mid = low + (high - low)/2;
        int current = nums[mid];
        if (low == high) {
            return current < target
                    ? low + 1
                    : low;
        } else if (low < high) {
            return current < target
                    ? bs(mid + 1, high)
                    : bs(low, mid);
        } else {
            return -1;
        }
    }
}

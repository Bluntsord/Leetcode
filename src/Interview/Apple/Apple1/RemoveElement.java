package Interview.Apple.Apple1;

public class RemoveElement {


    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int[] nums2 = new int[]{0,1,2,2,3,0,4,2};
        RemoveElement removeElement = new RemoveElement();
//        removeElement.swap(0, 1, nums);
//        System.out.println(Arrays.toString(nums));
        int answer = removeElement.removeElement(nums2, 2);
        System.out.println(answer);
    }

    public int removeElement(int[] nums, int val) {
        int backPointer = nums.length - 1;
        return backPointer;
    }

    public void swap(int first, int second, int[] nums) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}

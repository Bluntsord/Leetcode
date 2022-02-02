package LeetCodePatterns;

public class FindDup {

    public static void main(String[] args) {
        int[] temp = new int[]{1,2,3,4,1};
        FindDup findDup = new FindDup();
        System.out.println(findDup.findDuplicate(temp));
    }

    public int findDuplicate(int[] nums) {
        int max = nums.length - 1;
        int n = nums.length;
        int ideal = (max * (2 + (max - 1)))/2;

        int acc = 0;
        for (int i = 0; i < nums.length; i++) {
            acc += nums[i];
        }

        return acc - ideal;
    }
}

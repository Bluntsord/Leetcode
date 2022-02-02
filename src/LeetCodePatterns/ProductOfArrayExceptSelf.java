package LeetCodePatterns;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] temp = new int[]{1,2,3,4};
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int[] answer = productOfArrayExceptSelf.productExceptSelf(temp);
        System.out.println(Arrays.toString(answer));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] leftToRightProduct = new int[nums.length];
        int[] rightToLeftProduct = new int[nums.length];

        int leftAcc = 1;
        int rightAcc = 1;
        for (int  i = 0; i < nums.length; i++) {
            int backwards = nums.length - i - 1;
            leftAcc *= nums[i];
            rightAcc *= nums[backwards];

            leftToRightProduct[i] = leftAcc;
            rightToLeftProduct[backwards] = rightAcc;
        }

        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int left = i == 0? 1: leftToRightProduct[i - 1];
            int right = i == nums.length - 1? 1: rightToLeftProduct[i + 1];
            answer[i] = left * right;
        }

        return answer;
    }
}

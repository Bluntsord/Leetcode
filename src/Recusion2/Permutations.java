package Recusion2;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    int[] nums;
    List<List<Integer>> answer;
    ArrayList<Integer> stack;

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] tempArr = new int[] {1 ,2, 3};
        permutations.permute(tempArr);
        System.out.println(permutations.answer);
    }

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.answer = new ArrayList<>();
        this.stack = new ArrayList<>();
        backTracking(stack);
        return answer;
    }

    public void backTracking(ArrayList<Integer> stack) {
        if (stack.size() == nums.length) {
            answer.add(new ArrayList<>(stack));
        } else {
            for (int curr: nums) {
                if (!stack.contains(curr)) {
                    stack.add(curr);
                    backTracking(stack);
                    stack.remove(stack.size() - 1);
                }
            }
        }
    }
}

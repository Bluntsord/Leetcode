package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CombiSum {

    List<List<Integer>> answer;
    HashMap<Integer, List<List<Integer>>> memo;
    ArrayList<Integer> frontier;
    int[] candidates;

    public static void main(String[] args) {
        CombiSum combiSum = new CombiSum();
        int[] tempArr = new int[]{2,3,5};
        combiSum.combinationSum(tempArr, 8);
        System.out.println(combiSum.answer);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.answer = new ArrayList<>();
        this.memo = new HashMap<>();
        int[] temp = Arrays.stream(candidates).filter(x -> x <= target).toArray();
        this.candidates = temp;
        this.frontier = new ArrayList<>();

        backTracking(target);
        return answer;
    }

    public void backTracking(int target) {
        if (target == 0) {
            ArrayList<Integer> temp = new ArrayList<>(frontier);
            answer.add(temp);
        } else if (target > 0) {
            for (int candidate: candidates) {
                if (target - candidate >= 0) {
                    int lastAdded = frontier.size() > 0 ? frontier.get(frontier.size() - 1): 0;
                    if (candidate >= lastAdded) {
                        frontier.add(candidate);
                        backTracking(target - candidate);
                        frontier.remove(Integer.valueOf(candidate));
                    }
                }
            }
        }
    }


}

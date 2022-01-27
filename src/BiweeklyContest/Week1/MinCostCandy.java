package BiweeklyContest.Week1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinCostCandy {


    public static void main(String[] args) {
        int[] cost = new int[]{1,2,3};
        MinCostCandy minCostCandy = new MinCostCandy();
        int answer = minCostCandy.minimumCost(cost);
        System.out.println(answer);
    }

    public int minimumCost(int[] cost) {
        List<Integer> arr = Arrays.stream(cost).sorted().boxed().collect(Collectors.toList());
        int acc = 0;

        if (arr.size() <= 2) {
            int answer = 0;
            for (int i = 0; i < arr.size(); i++) {
                answer += arr.get(i);
            }
            return answer;
        }

        int last = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        int next = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);


        acc = acc + last + next;
        if (arr.size() > 2) {
            while (arr.size() > 2) {
                int end = arr.get(arr.size() - 2);
                int after = arr.get(arr.size() - 3);
                acc += end;
                acc += after;
                for (int i = 0; i < 3; i++) {
                    arr.remove(arr.size() - 1);
                }
            }

            for (int i = 0; i < arr.size(); i++) {
                acc += arr.get(i);
            }
        }

        return acc;
    }
}

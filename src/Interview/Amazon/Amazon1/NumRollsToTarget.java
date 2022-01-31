package Interview.Amazon.Amazon1;

public class NumRollsToTarget {

    Integer[][] memo;
    int[] information;

    public static void main(String[] args) {
        NumRollsToTarget numRollsToTarget = new NumRollsToTarget();
        int answer = numRollsToTarget.numRollsToTarget(30, 30, 500);
        System.out.println(answer);
    }

    public int numRollsToTarget(int n, int k, int target) {
        memo = new Integer[n + 1][target + 1];
        information = new int[]{n, k, target};
        return dp(0, target);
    }

    public int dp(int currDie, int targetLeft) {
        if (targetLeft < 0 || currDie > information[0]) {
            return 0;
        } else if (targetLeft == 0 && currDie == information[0]) {
            return 1;
        } else if (memo[currDie][targetLeft] != null) {
            return memo[currDie][targetLeft];
        }

        int modulo = (int) (Math.pow(10, 9)) + 7;
        int maxRoll = information[1];
        int curr = 0;
        for (int i = 1; i < maxRoll + 1; i++) {
            curr += dp(currDie + 1, targetLeft - i);
            curr = curr % modulo;
        }

        memo[currDie][targetLeft] = curr;
        return curr;
    }
}

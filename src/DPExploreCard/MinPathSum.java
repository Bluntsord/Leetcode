package DPExploreCard;

public class MinPathSum {
    int[][] grid;
    int[][] memo;

    public static void main(String[] args) {
        int[][] tempArr = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
        MinPathSum minPathSum = new MinPathSum();
        System.out.println(minPathSum.minPathSum(tempArr));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        this.grid = grid;
        this.memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return dp(m - 1, n - 1);
    }

    public int dp(int row, int col) {
        if (row == 0 && col == 0) {
            return grid[0][0];
        } else if (memo[row][col] != -1) {
            return memo[row][col];
        }

        int current = grid[row][col];
        int firstWish = row == 0? Integer.MAX_VALUE: dp(row - 1, col);
        int secondWish = col == 0? Integer.MAX_VALUE: dp(row, col - 1);
        int currentWish = Math.min(secondWish, firstWish) + current;
        memo[row][col] = currentWish;
        return currentWish;
    }
}


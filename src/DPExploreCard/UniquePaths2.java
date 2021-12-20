package DPExploreCard;

public class UniquePaths2 {
    int[][] memo;
    int[][] obstacleGrid;

    public static void main(String[] args) {
        UniquePaths2 uniquePaths = new UniquePaths2();
        int[][] grid = new int[][] {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePaths.uniquePaths(grid));
    }

    public int uniquePaths(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        this.memo = new int[m][n];
        this.obstacleGrid = obstacleGrid;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return dp(m - 1, n - 1);
    }

    public int dp(int row, int col) {
        if (row == 0 && col == 0) {
            return 1;
        } if (row < 0 || col < 0) {
            return 0;
        } else if (memo[row][col] != -1) {
            return memo[row][col];
        }


        int firstWish = dp(row - 1, col);
        int secondWish = dp(row, col - 1);
        int currentWish = obstacleGrid[row][col] == 1? 0: firstWish + secondWish;
        memo[row][col] = currentWish;
        return currentWish;
    }

}

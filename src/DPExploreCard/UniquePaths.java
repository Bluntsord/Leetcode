package DPExploreCard;

public class UniquePaths {
    int[][] grid;

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3,7));
    }

    public int uniquePaths(int m, int n) {
        this.grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = -1;
            }
        }
        return dp(m - 1, n - 1);
    }

    public int dp(int row, int col) {
        if (row == 0 || col == 0) {
            return 1;
        } else if (grid[row][col] != -1) {
            return grid[row][col];
        }

        int firstWish = dp(row - 1, col);
        int secondWish = dp(row, col - 1);
        int currentWish = firstWish + secondWish;
        grid[row][col] = currentWish;
        return currentWish;
    }


}

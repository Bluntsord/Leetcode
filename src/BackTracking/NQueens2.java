package BackTracking;

import java.util.HashSet;

public class NQueens2 {

    String[][] board;
    int boardSize;
    int answer;

    public static void main(String[] args) {
        NQueens2 nQueens2 = new NQueens2();
        nQueens2.totalQueens(8);
        System.out.println(nQueens2.answer);
    }

    public int totalQueens(int n) {
        this.board = new String[n][n];
        this.boardSize = n;

        for (int i = 0; i < n; i++ ){
            for (int j = 0; j < n; j++ ){
                board[i][j] = ".";
            }
        }

        backTracking(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return answer;
    }

    public void backTracking(int row, HashSet<Integer> col, HashSet<Integer> diag, HashSet<Integer> antiDiag) {
        if (row == boardSize) {
            answer += 1;
        } else {
            for (int cols = 0; cols < boardSize; cols++) {
                int currentDiag = row + cols;
                int currentAntiDiag = row - cols;

                if (col.contains(cols) || diag.contains(currentDiag) || antiDiag.contains(currentAntiDiag)) {
                    continue;
                }

                col.add(cols);
                diag.add(currentDiag);
                antiDiag.add(currentAntiDiag);

                backTracking(row + 1, col, diag, antiDiag);

                col.remove(cols);
                diag.remove(currentDiag);
                antiDiag.remove(currentAntiDiag);
            }
        }
    }


    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

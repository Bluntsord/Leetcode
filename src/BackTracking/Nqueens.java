package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Nqueens {

    int boardSize;
    List<List<String>> answer;
    List<String> frontier;
    String[][] state;

    public static void main(String[] args) {
        Nqueens nqueens = new Nqueens();
        String[][] state = new String[10][10];
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[0].length; j++) {
                state[i][j] = ".";
            }
        }

        System.out.println(nqueens.solveNQueens(10));
    }

    public List<List<String>> solveNQueens(int n) {
        answer = new ArrayList<>();
        frontier = new ArrayList<>();
        this.boardSize = n;
        state = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                state[i][j] = ".";
            }
        }

        backTracking(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return answer;
    }

    public void backTracking(int row, HashSet<Integer> col, HashSet<Integer> diag, HashSet<Integer> antiDiag) {
        if (row == boardSize) {
            answer.add(createBoard(state));
        } else {

            for (int cols = 0; cols < boardSize; cols++) {
                int currentDiag = row - cols;
                int currentAntiDiag = row + cols;

                if (col.contains(cols) || diag.contains(currentDiag) || antiDiag.contains(currentAntiDiag)) {
                    continue;
                } else {
                    col.add(cols);
                    diag.add(currentDiag);
                    antiDiag.add(currentAntiDiag);
                    state[row][cols] = "Q";

                    backTracking(row + 1, col, diag, antiDiag);

                    col.remove(cols);
                    diag.remove(currentDiag);
                    antiDiag.remove(currentAntiDiag);
                    state[row][cols] = ".";
                }
            }
        }
    }


    public String generateString(int position, int size) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i == position) {
                stringBuilder.append("Q");
            } else {
                stringBuilder.append(".");
            }
        }
        return stringBuilder.toString();
    }

    public List<String> createBoard(String[][] state) {
        int row = state.length;
        int col = state[0].length;
        List<String> board = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col; j++) {
                sb.append(state[i][j]);
            }
            board.add(sb.toString());
        }

        return board;
    }
}

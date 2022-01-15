package graphs.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class RottingOranges {

    int[][] grid;
    int[][] answerGrid;
    Queue<int[]> queue;
    int answer;
    int totalSize;
    int orangesLeft;

    public static void main(String[] args) {
        int[][] anotherGrid = new int[][]{{2,1,1},{0,1,1} ,{0,1,1}};
        RottingOranges rottingOranges = new RottingOranges();
        int answer = rottingOranges.orangesRotting(anotherGrid);
        System.out.println(answer);
    }

    public int orangesRotting(int[][] grid) {
        this.grid = grid;
        int rowLen = this.grid.length;
        int colLen = this.grid[0].length;
        this.answerGrid = new int[rowLen][colLen];
        this.answer = 0;
        this.queue = new LinkedList<>();
        this.totalSize = rowLen * colLen;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                answerGrid[i][j] = -1;
                if (grid[i][j] == 1) {
                    orangesLeft += 1;
                } else if (grid[i][j] == 2) {
                    this.queue.add(new int[]{i, j});
                    this.answerGrid[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currAns = this.answerGrid[curr[0]][curr[1]];

            List<int[]> neighbours = getNeighbours(curr).stream().
                    filter(x -> isValidPosition(x)).
                    filter(x -> isOrange(x)).
                    filter(x -> isNotVisited(x)).collect(Collectors.toList());

            for (int[] neighbour: neighbours) {
                queue.add(neighbour);
                orangesLeft -= 1;
                this.answerGrid[neighbour[0]][neighbour[1]] = currAns + 1;
                this.answer = Math.max(currAns + 1, answer);
            }
        }

        if (orangesLeft != 0) {
            return -1;
        } else {
            return answer;
        }
    }




    public List<int[]> getNeighbours(int[] currentPos) {
        List<int[]> directions = new ArrayList<>();
        directions.add(new int[]{0, 1});
        directions.add(new int[]{0, -1});
        directions.add(new int[]{1, 0});
        directions.add(new int[]{-1, 0});

        return directions.stream().map(x -> new int[]{x[0] + currentPos[0], x[1] + currentPos[1]})
                .filter(x -> isValidPosition(x)).filter(x -> isOrange(x)).
                collect(Collectors.toList());
    }

    public boolean isValidPosition(int[] coord) {
        int rowLen = this.grid.length;
        int colLen = this.grid[0].length;

        if (coord[0] < 0 || coord[1] < 0 || coord[0] >= rowLen || coord[1] >= colLen) {
            return false;
        }
        return true;
    }

    public boolean isNotVisited(int[] coord) {
        return this.answerGrid[coord[0]][coord[1]] == -1;
    }

    public boolean isOrange(int [] coord) {
        return this.grid[coord[0]][coord[1]] == 1;
    }

}

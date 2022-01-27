package graphs.Djikstra;

import java.util.*;
import java.util.stream.Collectors;

public class PathWithMinEffort {

    int[][] grid;

    public static void main(String[] args) {
        int[][] tempGrid = new int[][]{{1,2,2},{3,8,2},{5,3,5}};
        PathWithMinEffort pathWithMinEffort = new PathWithMinEffort();
        int answer = pathWithMinEffort.minimumEffortPath(tempGrid);
        System.out.println(answer);
    }

    public int minimumEffortPath(int[][] heights) {
        int rowLen = heights.length - 1;
        int colLen = heights[0].length - 1;
        this.grid = heights;
        PriorityQueue<int[]> frontier = new PriorityQueue<>((x, y) -> x[0] - y[0]);

        HashMap<int[], Integer> dist = new HashMap<>();
        HashSet<String> visited = new HashSet<>();

        //int[0]: height int[1] row int[2] col

        //Init values;
        int[] start = new int[]{0, 0, 0};
        frontier.add(start);
        visited.add("0/0");
        int prevHeight = 0;
        int answer = 0;

        while (!frontier.isEmpty()) {
            int[] curr = frontier.poll();
            String key = String.valueOf(curr[1]) + "/" + String.valueOf(curr[2]);
            visited.add(key);
            int currHeightDiff = curr[0];
            answer = Math.max(currHeightDiff, answer);
            if (curr[1] == rowLen && curr[2] == colLen) {
                break;
            }

            List<int[]> neighbours = getNeighbours(curr[1], curr[2]);
            for (int[] neighbour: neighbours) {
                String neighbourKey = String.valueOf(neighbour[0]) + "/" + String.valueOf(neighbour[1]);
                if (!visited.contains(neighbourKey)) {
                    int neighbourHeight = this.grid[neighbour[0]][neighbour[1]];
                    int currentHeight = this.grid[curr[1]][curr[2]];
                    int absoluteHeightDiff = neighbourHeight - currentHeight < 0
                            ? currentHeight - neighbourHeight
                            : neighbourHeight - currentHeight;
                    int[] neighbourWithInfo = new int[]{absoluteHeightDiff, neighbour[0], neighbour[1]};
                    frontier.add(neighbourWithInfo);
//                    visited.add(key);
                }
            }
        }

        return answer;
    }

    public List<int[]> getNeighbours(int currPosRow, int currPosCol) {
        List<int[]> directions = new ArrayList<>();
        directions.add(new int[]{0, 1});
        directions.add(new int[]{0, -1});
        directions.add(new int[]{1, 0});
        directions.add(new int[]{-1, 0});

        return directions.stream().map(x -> new int[]{x[0] + currPosRow, x[1] + currPosCol})
                .filter(x -> isInGrid(x)).collect(Collectors.toList());
    }

    public boolean isInGrid(int[] currPos) {
        int row = currPos[0];
        int col = currPos[1];

        if (row < 0 || col < 0 || row >= this.grid.length || col >= this.grid[0].length) {
            return false;
        }

        return true;
    }
}


package graphs.BFS;

import java.util.*;
import java.util.stream.Collectors;

public class ShortestPathMatrix {

    int[][] grid;
    int[][] answerGrid;
    Queue<Vector> frontier;
    HashSet<Vector> visited;

    public static void main(String[] args) {
        int[][] tempGrid = new int[][]{{0,1}, {0,0}};
        int[][] anotherGrid = new int[][]{{0,0,0},{1,1,0},{1,1,0}};
        ShortestPathMatrix shortestPathMatrix = new ShortestPathMatrix();
        System.out.println(shortestPathMatrix.shortestPathBinaryMatrix(anotherGrid));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        this.frontier = new LinkedList<>();
        this.visited = new HashSet<>();
        this.grid = grid;

        int numberOfRows = grid.length;
        int numberOfCols = grid[0].length;
        this.answerGrid = new int[numberOfRows][numberOfCols];

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfCols; j++) {
                answerGrid[i][j] = -1;
            }
        }

        Vector start = new Vector(0,0);
        bfs(start);
        if (this.grid[0][0] == 1) {
            return -1;
        }
        return answerGrid[numberOfRows - 1][numberOfCols - 1];
    }

    public void bfs(Vector start) {
        //Init all the required variables
        int curr = 1;
        answerGrid[0][0] = curr;
        frontier.add(start);
        visited.add(start);

        while (!frontier.isEmpty()) {
            Vector currPos = frontier.poll();
            curr = answerGrid[currPos.x][currPos.y];
            List<Vector> neighbours = getPossibleNeighbours(currPos);

            for (Vector neighbour : neighbours) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    answerGrid[neighbour.x][neighbour.y] = curr + 1;
                    frontier.add(neighbour);
                }
            }
        }
    }

    private static class Vector {
        int x;
        int y;

        Vector(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Vector addVector(Vector otherVector) {
            return new Vector(this.x + otherVector.x, this.y + otherVector.y);
        }

        public String toString() {
            return String.format("{x: %d, y: %d}", this.x, this.y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vector vector = (Vector) o;
            return x == vector.x && y == vector.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public List<Vector> getPossibleNeighbours(Vector currentPosition) {
        List<Vector> directions = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                Vector direction = new Vector(i, j);
                directions.add(direction);
            }
        }

        return directions.stream().map(x -> currentPosition.addVector(x)).
                filter(x -> checkValidVector(x)).collect(Collectors.toList());
    }

    public boolean checkValidVector(int[] vector) {
        if (vector[0] < 0 || vector[1] < 0 || vector[0] >= this.grid.length || vector[1] >= this.grid.length) {
            return false;
        } else if (this.grid[vector[0]][vector[1]] == 1) {
            return false;
        }

        return true;
    }

    public boolean checkValidVector(Vector vector) {
        int[] temp = new int[]{vector.x, vector.y};
        return checkValidVector(temp);
    }


}

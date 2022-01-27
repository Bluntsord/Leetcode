package graphs.BFS;

import java.util.*;
import java.util.stream.Collectors;

public class ShortestPathFindFood {

    char[][] grid;
    int[][] answerGrid;
    HashSet<Vector> visited;
    Vector start;
    List<Vector> foodCells;
    int answer;
    Queue<Vector> queue;

    public static void main(String[] args) {
        char[][] tempGrid = new char[][]{{'X', 'X', 'X', 'X', 'X', 'X'}, {'X', '*', 'O', 'O', 'O', 'X'}, {'X', 'O', 'O', '#', 'O', 'X'}, {'X', 'X', 'X', 'X', 'X', 'X'}};
        char[][] anotherGrid =
                new char[][]{
                        {'#','#'},
                        {'O','O'},
                        {'X','X'},
                        {'O','O'},
                        {'O','#'},
                        {'O','O'},
                        {'O','X'},
                        {'O','O'},
                        {'X','O'},
                        {'O','*'}};

        ShortestPathFindFood shortestPathFindFood = new ShortestPathFindFood();
        int answer = shortestPathFindFood.getFood(anotherGrid);
        System.out.println(answer);

    }

    public int getFood(char[][] grid) {
        this.grid = grid;
        this.visited = new HashSet<>();
        this.queue = new LinkedList<>();
        this.foodCells = new ArrayList<>();
        this.answer = Integer.MAX_VALUE;

        int rowLen = grid.length;
        int colLen = grid[0].length;
        this.answerGrid = new int[rowLen][colLen];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                answerGrid[i][j] = -1;
                if (this.grid[i][j] == '*') {
                    System.out.println(i);
                    System.out.println(j);
                    start = new Vector(i, j);
                    System.out.println(start);
                } else if (this.grid[i][j] == '#') {
                    foodCells.add(new Vector(i, j));
                }
            }
        }

        bfs(start);
        if (rowLen == 1 && colLen == 1) {
            return 0;
        } else if (foodCells.isEmpty()) {
            return -1;
        }

        for (Vector vector: foodCells) {
            int curr = this.answerGrid[vector.x][vector.y];
            if (curr != - 1) {
                answer = Math.min(answer, curr);
            }
        }

        return answer;
    }

    private void bfs(Vector start) {
        int curr = 0;
        queue.add(start);
        visited.add(start);
        this.answerGrid[start.x][start.y] = curr;

        while (!queue.isEmpty()) {
            Vector currVector = queue.poll();
            curr = this.answerGrid[currVector.x][currVector.y];
            List<Vector> neighbours = validNextSteps(currVector);

            for (Vector neighbour : neighbours) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                    this.answerGrid[neighbour.x][neighbour.y] = curr + 1;
                }
            }
        }
    }

    public List<Vector> validNextSteps(Vector currPos) {
        List<Vector> directions = new ArrayList<>();
        directions.add(new Vector(0, 1));
        directions.add(new Vector(1, 0));
        directions.add(new Vector(0, -1));
        directions.add(new Vector(-1, 0));

        return directions.stream().map(x -> currPos.addVector(x)).
                filter(x -> validPos(x)).collect(Collectors.toList());
    }

    public boolean validPos(Vector currPos) {
        int rowLen = this.grid.length;
        int colLen = this.grid[0].length;
        if (currPos.x < 0 || currPos.y < 0 || currPos.x >= rowLen || currPos.y >= colLen) {
            return false;
        } else if (grid[currPos.x][currPos.y] == 'X') {
            return false;
        }

        return true;
    }


    public static class Vector {
        int x;
        int y;

        Vector(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Vector addVector(Vector otherVector) {
            return new Vector(this.x + otherVector.x, this.y + otherVector.y);
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

        public String toString() {
            return String.format("{x: %d, y: %d", this.x, this.y);
        }
    }

}
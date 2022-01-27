package graphs.BFS;

import java.util.*;
import java.util.stream.Collectors;

public class NumberOfIslandsBFS {

    char[][] grid;
    public static void main(String[] args) {
        char[][] tempGrid = new char[][] {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        NumberOfIslandsBFS numberOfIslandsBFS = new NumberOfIslandsBFS();
        System.out.println(numberOfIslandsBFS.numIslands(tempGrid));
    }

    public int numIslands(char[][] grid) {
        Queue<Vector> queue = new LinkedList<>();
        ArrayList<Vector> landLeft = new ArrayList<>();
        this.grid = grid;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int answer = 0;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == '1') {
                    Vector coord = new Vector(i, j);
                    landLeft.add(coord);
                }
            }
        }

        while (!landLeft.isEmpty()) {
            answer += 1;
            Vector first = landLeft.get(0);
            queue.add(first);
            landLeft.remove(first);

            while (!queue.isEmpty()) {
                Vector curr = queue.poll();
                List<Vector> neighbours = getLandNeighbours(curr);
                for (Vector neighbour: neighbours) {
                    if (landLeft.contains(neighbour)) {
                        landLeft.remove(neighbour);
                        queue.add(neighbour);
                    }
                }
            }
        }

        return answer;
    }

    public List<Vector> getLandNeighbours(Vector currPos) {
        List<Vector> answer = new ArrayList<>();
        answer.add(new Vector(0, 1));
        answer.add(new Vector(0, -1));
        answer.add(new Vector(1, 0));
        answer.add(new Vector(-1, 0));

        return answer.stream().map(x -> new Vector(x.x + currPos.x, x.y + currPos.y)).
                filter(x -> isLand(x)).collect(Collectors.toList());
    }

    public boolean isLand(Vector pos) {
        int rowLen = pos.x;
        int colLen = pos.y;
        if (rowLen < 0 || colLen < 0 || rowLen >= grid.length || colLen >= grid[0].length) {
            return false;
        } else if (this.grid[rowLen][colLen] == '0') {
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

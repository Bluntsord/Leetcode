package BFS;

import java.util.*;

public class KnightsMoves {

    HashSet<Pair> travelled;
    Pair finalPos;

    public static void main(String[] args) {
        KnightsMoves knightsMoves = new KnightsMoves();
        System.out.println(knightsMoves.minKnightMoves(0, 1));
    }

    public int minKnightMoves(int x, int y) {
        travelled = new HashSet<>();

        finalPos = new Pair(x, y);
        Pair startingPos = new Pair(0, 0);
        Stack<Pair> frontier = new Stack<>();
        frontier.add(startingPos);

        return bfs(frontier, 0);
    }

    public int bfs(Stack<Pair> currentFrontier, int counter) {

        Stack<Pair> nextFrontier = new Stack<>();
        if (!currentFrontier.contains(finalPos)) {
            for (Pair currentPos: currentFrontier) {
                Pair firstPair = new Pair(currentPos.x + 2, currentPos.y + 1);
                Pair secondPair = new Pair(currentPos.x + 1, currentPos.y + 2);
                Pair thirdPair = new Pair(currentPos.x - 2, currentPos.y - 1);
                Pair forthPair = new Pair(currentPos.x - 1, currentPos.y - 2);
                Pair fifthPair = new Pair(currentPos.x + 2, currentPos.y - 1);
                Pair sixthPair = new Pair(currentPos.x - 1, currentPos.y + 2);
                Pair sevenPair = new Pair(currentPos.x - 2, currentPos.y + 1);
                Pair eighthPair = new Pair(currentPos.x + 1, currentPos.y - 2);

                Pair[] temp = new Pair[]{firstPair, secondPair, thirdPair, forthPair,
                        fifthPair, sixthPair, sevenPair, eighthPair};

                Arrays.stream(temp).filter(x -> x.x > 0).filter(x -> x.y > 0).
                        filter(x -> !travelled.contains(x)).forEach(x -> nextFrontier.add(x));

                currentFrontier.stream().forEach(x -> travelled.add(x));
            }

            return bfs(nextFrontier, counter + 1);
        }

        return counter;
    }

    private class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

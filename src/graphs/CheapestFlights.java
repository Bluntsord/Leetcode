package graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class CheapestFlights {

    public static void main(String[] args) {
        CheapestFlights cheapestFlights = new CheapestFlights();
        int[][] grid = new int[][]{{1,2,3}, {2,3,5}, {2,4,5}, {0, 1 ,10}, {5,10, 15}};
        cheapestFlights.findCheapestPrice(0, grid, 0,0,0);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] copy = Arrays.stream(flights).map(x -> x.clone()).toArray(int[][]::new);
        HashMap<Integer, PriorityQueue<int[]>> adjList = new HashMap<>();

        Arrays.stream(copy).forEach(x -> {
            if (adjList.containsKey(x[0])) {
                PriorityQueue<int[]> pq = adjList.get(x[0]);
                pq.add(x);
                adjList.replace(x[0], pq);
            } else {
                PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
                pq.add(x);
                adjList.put(x[0], pq);
            }
        });


        int flightCost = 0;
        HashMap<Integer, Integer> visited = new HashMap<>();
        PriorityQueue<Node> frontier = new PriorityQueue<>((x, y) -> x.pathCostSoFar - y.pathCostSoFar);
        frontier.add(new Node(src, 0));
        visited.put(src, 0);

        while (!frontier.isEmpty()) {
            Node curr = frontier.poll();
            visited.put(curr.val, curr.pathCostSoFar);

            PriorityQueue<int[]> neighbours = adjList.get(curr.val);
            while (!neighbours.isEmpty()) {
                int[] nextEdge = neighbours.poll();
                if (!visited.containsKey(nextEdge[1]) || visited.get(nextEdge[1]) > curr.pathCostSoFar + nextEdge[2]) {
                    Node nextNode = new Node(nextEdge[1], curr.pathCostSoFar + nextEdge[2]);
                    frontier.add(nextNode);
                }
            }
        }

        return visited.get(dst);

    }

    class Node {
        int val;
        int pathCostSoFar;

        public Node(int n, int i) {
            this.val = n;
            this.pathCostSoFar = i;
        }
    }
}

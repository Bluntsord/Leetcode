package graphs.Djikstra;

import java.util.*;

public class NetworkDelay {

    HashMap<Integer, HashSet<int[]>> adjList;
    HashMap<Integer, Integer> dist;

    public static void main(String[] args) {
        NetworkDelay networkDelay = new NetworkDelay();
        int[][] edges = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        int answer = networkDelay.networkDelayTime(edges, 4, 2);
        System.out.println(answer);
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        this.adjList = new HashMap<>();
        //Create adj list;
        for (int[] edge: times) {
            int curr = edge[0];
            int[] edgeInfo = new int[]{edge[1], edge[2]};
            if (!adjList.containsKey(curr)) {
                HashSet<int[]> neighbours = new HashSet<>();
                neighbours.add(edgeInfo);
                adjList.put(curr, neighbours);
            } else {
                HashSet<int[]> neighbours = adjList.get(curr);
                neighbours.add(edgeInfo);
                adjList.replace(curr, neighbours);
            }
        }

        PriorityQueue<int[]> frontier = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        frontier.offer(new int[]{k, 0});
//        HashMap<Integer, Integer> dist = new HashMap<>();
//        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
//                (info1, info2) -> info1[0] - info2[0]);
//        heap.offer(new int[]{0, k});

        HashMap<Integer, Integer> dist = new HashMap();

//        while (!frontier.isEmpty()) {
//            int[] info = frontier.poll();
//            int d = info[1], node = info[0];
//            if (!dist.containsKey(node)) {
//                dist.put(node, d);
//                if (adjList.containsKey(node))
//                    for (int[] edge : adjList.get(node)) {
//                        int nei = edge[0], d2 = edge[1];
//                        if (!dist.containsKey(nei))
//                            frontier.offer(new int[]{nei, d + d2});
//                    }
//            }
//        }
        while (!frontier.isEmpty()) {
            int[] currWeightedEdge = frontier.poll();
            int nextNode = currWeightedEdge[0];
            int distanceToCurr = currWeightedEdge[1];


            if (!dist.containsKey(nextNode)) {
                dist.put(nextNode, distanceToCurr);

                // Look at the adjList to see if there are neighbours.
                // If there is, add all to the priority queue
                if (adjList.containsKey(nextNode)) {
                    List<int[]> neighbours = new ArrayList<>(this.adjList.get(nextNode));
                    for (int[] neighbour : neighbours) {
                        if (!dist.containsKey(neighbour[0])) {
//                            dist.put(neighbour[0], neighbour[1]);
                            frontier.offer(new int[]{neighbour[0], distanceToCurr + neighbour[1]});
                        }
                    }
                }
            }
        }

        if (dist.size() != n) {
            return -1;
        }
        int ans = 0;
        for (int cand: dist.values()) {
            ans = Math.max(ans, cand);
        }

        return ans;

    }
}

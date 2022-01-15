package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathSourceBFS {

    int[][] graph;
    List<List<Integer>> answer;
    Queue<List<Integer>> frontier;
    int target;
    
    public static void main(String[] args) {
        int[][] tempArr = new int[][] {{1,2},{3},{3}, {}};
        int[][] tempArr2 = new int[][] {{4,3,1},{3,2,4},{3},{4},{}};
        AllPathSourceBFS allPathSourceBFS = new AllPathSourceBFS();
        allPathSourceBFS.allPathsSourceTarget(tempArr2);
        System.out.println(allPathSourceBFS.answer);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.answer = new ArrayList<>();
        this.graph = graph;
        this.frontier = new LinkedList<>();
        this.target = graph.length - 1;

        if (graph.length == 0 || graph == null) {
            return answer;
        }

        bfs(0);
        return answer;
    }

    public void bfs(int root) {
        List<Integer> path = new ArrayList<>();
        path.add(root);
        frontier.add(path);

        while (!frontier.isEmpty()) {
            List<Integer> currPath = frontier.poll();
            int curr = currPath.get(currPath.size() - 1);
            int[] neighbours = this.graph[curr];

            for (int neighbour: neighbours) {
                List<Integer> altPath = new ArrayList<>(currPath);
                altPath.add(neighbour);
                if (neighbour == this.target) {
                    this.answer.add(altPath);
                } else {
                    frontier.add(altPath);
                }
            }
        }
    }
}

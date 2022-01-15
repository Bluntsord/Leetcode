package graphs;

import java.util.*;

public class AllPathsSource {

    int[][] graph;
    Stack<Integer> stack;
    List<List<Integer>> answer;
    HashSet<Integer> visited;
    int target;

    public static void main(String[] args) {
        int[][] tempArr = new int[][] {{1,2},{3},{3}, {}};
        int[][] tempArr2 = new int[][] {{4,3,1},{3,2,4},{3},{4},{}};
        AllPathsSource allPathsSource = new AllPathsSource();
        allPathsSource.allPathsSourceTarget(tempArr2);
        System.out.println(allPathsSource.answer);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.stack = new Stack<>();
        this.graph = graph;
        this.answer = new ArrayList<>();
        this.visited = new HashSet<>();
        this.target = graph.length - 1;

        dfs(0);
        return answer;
    }

    public void dfs(int node) {
        if (node == target) {
            List<Integer> someAnswer = new ArrayList<>(stack);
            someAnswer.add(0, 0);
            answer.add(someAnswer);
            return;
        }

        visited.add(node);
        int[] neighbours = this.graph[node];

        for (int neighbour: neighbours) {
            if (!visited.contains(neighbour)) {
                stack.add(neighbour);
                dfs(neighbour);
                stack.pop();
            }
        }

        visited.remove(node);
    }

}

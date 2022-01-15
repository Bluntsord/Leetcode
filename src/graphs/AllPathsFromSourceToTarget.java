package graphs;

import java.util.*;

public class AllPathsFromSourceToTarget {

    List<List<Integer>> answer;
    HashMap<Integer, HashSet<Integer>> graph;
    Stack<Integer> stack;
    int target;

    public static void main(String[] args) {
        int[][] temp = new int[][] {{1,2},{3},{3},{}};
        int[][] temp2 = new int[][] {{4,3,1},{3,2,4},{3},{4},{}};
        AllPathsFromSourceToTarget allPathsFromSourceToTarget = new AllPathsFromSourceToTarget();
        allPathsFromSourceToTarget.allPathsSourceTarget(temp2);
        System.out.println(allPathsFromSourceToTarget.answer);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = new HashMap<>();
        this.stack = new Stack<>();
        this.answer = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            int[] neighbours = graph[i];
            HashSet<Integer> setNeighbours = new HashSet<>();
            Arrays.stream(neighbours).forEach(x -> setNeighbours.add(x));
            this.graph.put(i, setNeighbours);
        }

        this.target = graph.length - 1;
        dfs(0);
        return answer;
    }

    public void dfs(int start) {
        if (start == target) {
            stack.add(target);
            List<Integer> temp = new ArrayList<>(stack);
            answer.add(temp);
        } else {
            for (int neighbours: graph.get(start)) {
                if (!stack.contains(start)) {
                    stack.add(start);
                }
                dfs(neighbours);
                stack.pop();
            }
        }
    }
}

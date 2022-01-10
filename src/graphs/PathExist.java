package graphs;


import java.util.HashMap;
import java.util.HashSet;

public class PathExist {

    int totalNodes;
    int[][] edges;
    HashMap<Integer, HashSet<Integer>> adjList;
    HashSet<Integer> visited;
    int target;
    boolean answer;

    public static void main(String[] args) {
        int[][] tempArr = {{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}};
        PathExist pathExist = new PathExist();
        System.out.println(pathExist.validPath(9, tempArr, 7, 5));
    }

    public boolean validPath(int n, int[][] edges, int start, int end) {
        this.totalNodes = n;
        this.edges = edges;
        this.target = end;
        this.answer = false;
        this.adjList = new HashMap<>();
        this.visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            HashSet<Integer> temp = new HashSet<>();
            adjList.put(i, temp);
        }

        for (int i = 0; i < edges.length; i++) {
            int[] currentEdge = edges[i];
            int currentNode = currentEdge[0];
            int nextNode = currentEdge[1];

            HashSet<Integer> connectedNodes = adjList.get(currentNode);
            connectedNodes.add(nextNode);
            this.adjList.put(currentNode, connectedNodes);

            HashSet<Integer> otherConnectedNodes = adjList.get(nextNode);
            otherConnectedNodes.add(currentNode);
            this.adjList.put(nextNode, otherConnectedNodes);
        }

        dfs(start);
        return answer;
    }

    private void dfs(int start) {
        if (start == target) {
            answer = true;
        }

        visited.add(start);

        for (int node: adjList.get(start).stream().mapToInt(x -> x).toArray()) {
            if (!visited.contains(node)) {
                dfs(node);
            }
        }
    }
}

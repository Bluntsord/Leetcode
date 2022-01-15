package graphs.BFS;

import java.util.*;

public class PathExistBFS {

    private ArrayList<Integer> queue;
    private HashMap<Integer, HashSet<Integer>> map;
    private int vertices;
    private int end;
    boolean answer = false;
    private HashSet<Integer> visited;

    public static void main(String[] args) {
        int[][] tempArr = new int[][] {{0,1},{1,2},{2,0}};
        int[][] tempArr2 = new int[][] {{0,1},{0,2},{3,5},{5,4},{4,3}};
        PathExistBFS pathExist = new PathExistBFS();
//        pathExist.validPath(3, tempArr,0 , 2);
        pathExist.validPath(6, tempArr2,0 , 5);
        System.out.println(pathExist.answer);

    }

    public boolean validPath(int n, int[][] edges, int start, int end) {
        this.vertices = n;
        this.queue = new ArrayList<>();
        this.end = end;
        this.map = new HashMap<>();
        this.visited = new HashSet<>();

        //Build adj list
        for (int i = 0; i < edges.length; i++) {
            int[] currentEdge = edges[i];
            int src = currentEdge[0];
            int dest = currentEdge[1];

            HashSet<Integer> srcNeighbours = this.map.containsKey(src)
                    ? this.map.get(src)
                    : new HashSet<>();

            srcNeighbours.add(dest);
            this.map.put(src, srcNeighbours);

            HashSet<Integer> destNeighbours = this.map.containsKey(dest)
                    ? this.map.get(dest)
                    : new HashSet<>();
            destNeighbours.add(src);
            this.map.put(dest, destNeighbours);

        }

        bfs(start);
        return answer;
    }


    public void bfs(int node) {
        if (node == end) {
            answer = true;
            return;
        }

        visited.add(node);

        HashSet<Integer> neighbours = this.map.get(node);
        for (int neighbour: neighbours) {
            if (!visited.contains(neighbour)) {
                queue.add(neighbour);
                bfs(neighbour);
                queue.remove(0);
            }
        }

        return;
    }
}

package Interview.BloomBerg;

import java.util.HashSet;

public class NCities {

    int[][] adjMatrix;
    HashSet<Integer> visited;

    public static void main(String[] args) {
        int[][] tempMatrix = new int[][]{{1,1, 0}, {1,1,0}, {0,0,1}};
        int[][] tempMatrix2 = new int[][]{{1,1, 1}, {1,1,1}, {1,1,1}};
        int[][] tempMatrix3 = new int[][]{{1,0 , 0}, {0,1,0}, {0,0,1}};
        NCities nCities = new NCities();
        System.out.println(nCities.findCircleNum(tempMatrix3));
    }

    public int findCircleNum(int[][] isConnected) {
        this.adjMatrix = isConnected;
        this.visited = new HashSet<>();
        int acc = 0;
        for (int i = 0; i < adjMatrix.length; i++) {
            acc += dfs(i);
        }

        return acc;
    }

    //Return 1 if the currentNode has not been visited and 0 if it has
    public int dfs(int currentNode) {
        if (visited.contains(currentNode)) {
            return 0;
        }

        this.visited.add(currentNode);

        for (int i = 0; i < adjMatrix.length; i++) {
            int connectedNode = adjMatrix[currentNode][i];
            if (connectedNode == 1) {
                dfs(i);
            }
        }

        return 1;
    }
}

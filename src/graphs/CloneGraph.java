package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

//    public static void main(String[] args) {
//        int[][] tempArr = new int[][]{{2,4},{1,3},{2,4},{1,3}};
//        HashMap<Integer, Node> nodes = new HashMap<>();
//
//        for (int i = 1; i <= tempArr.length; i++) {
//            Node current = new Node(i);
//            nodes.put(i, current);
//        }
//
//        for (int i = 1; i <= tempArr.length; i++) {
//            Node current = nodes.get(i);
//            for (int neighbours: tempArr[i - 1]) {
//                Node temp = nodes.get(neighbours);
//                current.neighbors.add(temp);
//            }
//        }
//
//        CloneGraph cloneGraph = new CloneGraph();
//        Node newGraph = cloneGraph.cloneGraph(nodes.get(0));
//
//    }

    public HashMap<Integer, Node> visited;
    public Node cloneGraph(Node node) {
        this.visited = new HashMap<>();
        return dfs(node);
    }

    public Node dfs(Node node) {
        Node clonedCurrentNode = cloneCurrent(node);
        if (node.neighbors.isEmpty()) {
            return clonedCurrentNode;
        } else if (visited.containsKey(node.val)) {
            return visited.get(node.val);
        }

        visited.put(node.val, clonedCurrentNode);

        for (Node neighbours: node.neighbors) {
            Node clonedNextNode = dfs(neighbours);
            clonedCurrentNode.neighbors.add(clonedNextNode);
        }

        return clonedCurrentNode;
    }

    public Node cloneCurrent(Node node) {
        return new Node(node.val);
    }


    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

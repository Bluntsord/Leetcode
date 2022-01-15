package graphs.BFS;

import java.util.*;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> frontier = new LinkedList<>();
        frontier.add(root);
        List<List<Integer>> answer = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();

        if (root == null) {
            return new ArrayList<>();
        }

        while (!frontier.isEmpty()) {
            int size = frontier.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node curr = frontier.poll();
                for (Node neighbour : curr.children) {
                    if (!visited.contains(neighbour.val)) {
                        frontier.add(neighbour);
                        visited.add(neighbour.val);
                        level.add(neighbour.val);
                    }
                }
            }
            answer.add(level);
        }

        return answer;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

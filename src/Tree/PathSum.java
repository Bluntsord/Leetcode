package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSum {

    Stack<Integer> stack;
    int targetSum;
    int acc = 0;
    List<List<Integer>> answer;

    public List<List<Integer>> hasPathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        this.stack = new Stack<>();
        this.answer = new ArrayList<>();
        dfs(root);
        return answer;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        } else if (node.left == null && node.right == null) {
            if (acc + node.val == targetSum) {
                stack.add(node.val);
                answer.add(new ArrayList<>(stack));
                stack.pop();
            }
        }

        acc += node.val;
        stack.add(node.val);

        dfs(node.left);
        dfs(node.right);

        acc -= node.val;
        stack.pop();
    }
}

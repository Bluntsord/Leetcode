package Tree;

import java.util.ArrayList;
import java.util.List;


public class InOrderTraversal {

    List<Integer> answer;

    public List<Integer> inorderTraversal(TreeNode root) {
        this.answer = new ArrayList<>();
        dfs(root);
        return answer;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        answer.add(root.val);
        dfs(root.right);
    }



}

package Recusion2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Combine {

    HashMap<Integer, Integer> frontier;
    List<List<Integer>> output;
    int n;
    int k;

    public static void main(String[] args) {
        Combine combine = new Combine();
        System.out.println(combine.combine(4,2));
    }

    public List<List<Integer>> combine(int n, int k) {
        frontier = new HashMap<>();
        output = new ArrayList<>();
        this.n = n;
        this.k = k;
        backTracking(frontier, 1);
        return output;
    }

    private void backTracking(HashMap<Integer, Integer> frontier, int current) {
        if (frontier.size() == k) {
            addFrontier(frontier);
        } else {
            for (int i = current; i < n + 1; i++) {
                placeCandidate(i);
                backTracking(frontier, i + 1);
                removeCandidate(i);
            }
        }
    }

    private void placeCandidate(int candidate) {
        frontier.put(candidate, candidate);
    }

    private void removeCandidate(int candidate) {
        frontier.remove(candidate);
    }

    private void addFrontier(HashMap<Integer, Integer> frontier) {
        List<Integer> currList = new ArrayList<>();
        for (Integer currInt: frontier.keySet()) {
            currList.add(currInt);
        }

        output.add(currList);
    }

}

package DP4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumEvents2 {

    int[][] events;
    HashMap<Integer, List<int[]>> adjList;
    HashMap<String, Integer> memo;
    int numberOfDays;
    List<Integer> daysAvailable;

    public static void main(String[] args) {
        int[][] tempArr = new int[][] {{1,2,4},{3,4,3},{2,3,10}};
        int[][] tempArr2 = new int[][] {{1,1,1},{2,2,2},{3,3,3}};
        MaximumEvents2 maximumEvents2 = new MaximumEvents2();
        int answer = maximumEvents2.maxValue(tempArr, 3);
        System.out.println(answer);
    }

    public int maxValue(int[][] events, int k) {
        this.events = events;
        this.adjList = new HashMap<>();
        int maxDays = Integer.MIN_VALUE;
        this.memo = new HashMap<>();
        this.daysAvailable = new ArrayList<>();

        for (int[] edges: events) {
            int current = edges[0];
            if (!adjList.containsKey(current)) {
                List<int[]> temp = new ArrayList<>();
                temp.add(edges);
                adjList.put(current, temp);

            } else {
                List<int[]> temp = this.adjList.get(current);
                temp.add(edges);
                adjList.replace(current, temp);
            }

            maxDays = Math.max(maxDays, current);
            maxDays = Math.max(maxDays, edges[1]);
            if (!daysAvailable.contains(current)) {
                daysAvailable.add(current);
            }
        }

        this.numberOfDays = maxDays;
        this.daysAvailable = this.daysAvailable.stream().sorted().collect(Collectors.toList());
        return dp(1, k);
    }


    public int dp(int currentDay, int eventsLeft) {
        String key = String.valueOf(currentDay) + "|" + String.valueOf(eventsLeft);
        if (currentDay > numberOfDays || eventsLeft <= 0) {
            return 0;
        } else if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int doSmth = Integer.MIN_VALUE;
        List<int[]> outwardEdges = this.adjList.get(currentDay);
        if (outwardEdges != null) {
            for (int[] edge : outwardEdges) {
                int value = edge[2];
                int next = dp(edge[1] + 1, eventsLeft - 1);
                doSmth = Math.max(value + next, doSmth);
            }
        }

        int nextDay = currentDay + 1;
        if (currentDay < this.numberOfDays - 1) {
            nextDay = this.daysAvailable.get(currentDay + 1);
        }
        int doNth = dp(nextDay, eventsLeft);
        int wish = Math.max(doSmth, doNth);

        this.memo.put(key, wish);
        return wish;
    }
}

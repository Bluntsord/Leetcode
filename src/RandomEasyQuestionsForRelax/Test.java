package RandomEasyQuestionsForRelax;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        int[] tempArr = new int[]{1,2,10};
        List<Integer> tempList = new ArrayList<>();
        Comparator<Integer> comparator = new IntegerComparator();
        PriorityQueue<Integer> pq = new PriorityQueue<>(5, new IntegerComparator());
        pq.add(1);
        System.out.println(pq);
        System.out.println("===============");
        pq.add(2);
        System.out.println(pq.peek());
        pq.poll();
        System.out.println("===============");
        pq.add(3);
        System.out.println(pq.peek());
        pq.poll();
        System.out.println("===============");
        pq.add(4);
        System.out.println(pq.peek());
        pq.poll();
        System.out.println("===============");
        pq.add(5);
        System.out.println(pq.peek());
        pq.poll();
        System.out.println("===============");

    }

    static class IntegerComparator implements java.util.Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            System.out.println("===============");
            System.out.println("o1 is: " + o1);
            System.out.println("o2 is :" + o2);
            return o1 < o2
                    ? 1
                    : -1;
        }
    }
}

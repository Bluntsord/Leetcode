package Interview.GoldMan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class HackerCards{


    public static void main(String[] args) {
        int[] collection = new int[]{1,3,4};
        List<Integer> collectionList = Arrays.stream(collection).boxed().collect(Collectors.toList());
        List<Integer> answer = hackerCards(collectionList, 7);
        System.out.println(answer);
    }

    public static List<Integer> hackerCards(List<Integer> collection, int d) {
        // Write your code here
        int currCard = 1;
        HashSet<Integer> temp = new HashSet<>(collection);
        List<Integer> answer = new ArrayList<>();
        while (d >= 0) {
            if (!temp.contains(currCard)) {
                answer.add(currCard);
                d -= currCard;
            }
            currCard += 1;
            if (currCard > d) {
                break;
            }
        }
        return answer;
    }
}

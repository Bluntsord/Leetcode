package graphs.BFS;

import java.util.Arrays;
import java.util.List;

public class Temp {

    public static void main(String[] args) {
        int[] temp = new int[]{1,2,3};
        int[] another = new int[]{1,5,6};
        List<Integer> anotherList = Arrays.stream(another).boxed().toList();
        int[] answer = Arrays.stream(temp).filter(x -> !anotherList.contains(x)).toArray();
        System.out.println(Arrays.toString(answer));
    }


}

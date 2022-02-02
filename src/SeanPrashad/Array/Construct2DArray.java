package SeanPrashad.Array;

import java.util.Arrays;

public class Construct2DArray {

    public static void main(String[] args) {
        Construct2DArray construct2DArray = new Construct2DArray();
        int[] temp = new int[]{1,2,3};
        int[][] answer = construct2DArray.construct2DArray(temp, 1, 3);
        for (int[] arr: answer) {
            System.out.println(Arrays.toString(arr));
        }

    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] answer = new int[m][n];

        // Guard clause
        if (original.length != m * n) {
            return answer;
        }

        for (int i = 0; i < original.length; i++) {
            int currRow = (int) Math.floor(i/n);
            int currCol = i % n;
            answer[currRow][currCol] = original[i];
        }

        return answer;
    }
}

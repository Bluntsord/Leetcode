package Algo1;

import java.util.Arrays;

public class ReverseString3 {
    char[] s;
    public static void main(String[] args) {
        ReverseString3 reverseString3 = new ReverseString3();
        System.out.println(reverseString3.reverseWords("temp is not the best"));
    }

    public String reverseWords(String s) {
        String[] temp = s.split(" ");
        StringBuilder acc = new StringBuilder();
        Arrays.stream(temp).map(x -> reverseString(x)).forEach(x -> acc.append(x + " "));
        acc.deleteCharAt(acc.length() - 1);
        return acc.toString();
    }

    public String reverseString(String word) {
        reverseString(word.toCharArray());
        return String.valueOf(s);
    }

    public void reverseString(char[] s) {
        this.s = s;
        int firstPointer = 0;
        int secondPointer = s.length - 1;

        while (firstPointer < secondPointer) {
            swap(firstPointer, secondPointer);
            firstPointer += 1;
            secondPointer -= 1;
        }
    }


    public void swap(int firstIndex, int secondIndex) {
        char temp = s[firstIndex];
        s[firstIndex] = s[secondIndex];
        s[secondIndex] = temp;
    }

}
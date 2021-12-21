package Algo1;

import java.util.Arrays;

public class ReverseString {
    char[] s;

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        char[] tempArr = new char[]{'c', 'a', 'r'};
        reverseString.reverseString(tempArr);
        System.out.println(Arrays.toString(tempArr));
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

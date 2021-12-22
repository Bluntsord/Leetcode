package Algo1;

import java.util.HashSet;

public class SubStringNoRepeat {

    HashSet<Character> set;

    public static void main(String[] args) {
        SubStringNoRepeat subStringNoRepeat = new SubStringNoRepeat();
        int temp = subStringNoRepeat.lengthOfLongestSubstring("aab");
        System.out.println(temp);
    }

    public int lengthOfLongestSubstring(String s) {
        this.set = new HashSet<>();
        if (s.length() == 0) {
            return 0;
        }

        int currentBest = 0;
        int answer = 0;

        for (int i = 0; i < s.length(); i++ ){
            char currChar = s.charAt(i);
            if (!set.contains(currChar)) {
                set.add(currChar);
                currentBest += 1;
            } else {
                set.clear();
                set.add(currChar);
                currentBest = 1;
            }

            answer = Math.max(currentBest, answer);
        }

        return answer;
    }

}

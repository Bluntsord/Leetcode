package DPExploreCard;

import java.util.HashMap;

public class DecodeWays {
    HashMap<Integer, Integer> hashMap;
    int[] memo;
    String word;
    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        String temp = "1111";
        System.out.println(decodeWays.decodeWays(temp));
    }

    public int decodeWays(String word) {
        hashMap = new HashMap<>();
        memo = new int[word.length() + 1];

        for (int i = 1; i < 27; i++) {
            hashMap.put(i, i);
        }

        for (int i = 0; i < word.length() + 1; i++) {
            memo[i] = -1;
        }
        this.word = word;
        return dp(0);
    }

    private int dp(int pointer) {
        if (pointer == word.length()) {
            return 1;
        } else if (pointer > word.length()) {
            return 0;
        } else if (memo[pointer] != - 1) {
            return memo[pointer];
        } else if (word.charAt(pointer) == '0') {
            return 0;
        }

        int firstWish = 0;
        if (pointer + 1 < word.length()) {
            int doubleDigit = Integer.parseInt(word.substring(pointer, pointer + 2));
            if (hashMap.containsKey(doubleDigit)) {
                firstWish = dp(pointer + 2);
            }
        }
        int secondWish = dp(pointer + 1);
        int currentWish = firstWish + secondWish;
        memo[pointer] = currentWish;
        return currentWish;
    }
}

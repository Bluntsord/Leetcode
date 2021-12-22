package RandomEasyQuestionsForRelax;

import java.util.HashMap;

public class RomanNumerals {
    HashMap<Character, Integer> map;

    public static void main(String[] args) {
        RomanNumerals romanNumerals = new RomanNumerals();
        int temp = romanNumerals.romanToInt("MCM");
        System.out.println(temp);
    }


    public int romanToInt(String s) {
        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int acc = 0;
        for (int i = 0; i < s.length(); i++) {
            int currVal = map.get(s.charAt(i));
            if (checkSpecial(i, s)) {
                acc -= currVal;
            } else {
                acc += currVal;
            }
        }

        return acc;
    }

    public boolean checkSpecial(int index, String s) {
        if (index == s.length() - 1) {
            return false;
        }
        boolean special = map.get(s.charAt(index)) < map.get(s.charAt(index + 1));
        return special;
    }
}

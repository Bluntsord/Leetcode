package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class LetterCombiOfPhoneNumber {

    HashMap<Integer, List<Character>> map;
    String digits;
    List<String> answer;
    HashMap<Integer, List<String>> memo;
    Stack<Character> stack;

    public static void main(String[] args) {
        LetterCombiOfPhoneNumber letterCombiOfPhoneNumber = new LetterCombiOfPhoneNumber();
        letterCombiOfPhoneNumber.letterCombinations("32");
        System.out.println(letterCombiOfPhoneNumber.map);
        System.out.println(letterCombiOfPhoneNumber.letterCombinations("222"));
    }

    public List<String> letterCombinations(String digits) {
        int key = 2;
        int acc;
        int temp = 0;
        int currentChar = 97;
        this.map = new HashMap<>();
        this.digits = digits;
        this.answer = new ArrayList<>();
        this.stack = new Stack<>();
        this.memo = new HashMap<>();

        for (int i = key; i < 10; i++) {
            acc = i == 7 || i == 9 ? 4: 3;
            List<Character> tempList = new ArrayList<>();
            temp = 0;
            while (temp != acc) {
                char currentCharChanged = (char) currentChar;
                tempList.add(currentCharChanged);
                currentChar ++;
                temp ++;
            }
            map.put(i, tempList);
        }


        backTracking(stack, 0);
        return answer;
    }

    //DP WAY
    public List<String> dp(int pointer) {
        if (pointer == digits.length()) {
            return answer;
        } else if (memo.containsKey(pointer)) {
            return memo.get(pointer);
        }

        int currentKey = Integer.parseInt(Character.toString(digits.charAt(pointer)));
        List<Character> currentSet = map.get(currentKey);
        List<String> firstWish = dp(pointer + 1);
        List<String> wish = new ArrayList<>();
        for (String currString: firstWish) {
            for (Character currentChar: currentSet) {
                String newString = currentChar + currString;
                wish.add(newString);
            }
        }

        memo.put(pointer, wish);
        return wish;
    }


    //Backtracking way
    public void backTracking(Stack<Character> stack, int pointer) {
        if (stack.size() == digits.length()) {
            StringBuilder temp = new StringBuilder();
            stack.stream().forEach(x ->temp.append(x));
            answer.add(temp.toString());
        } else {
            Character currChar = digits.charAt(pointer);
            int key = Integer.parseInt(Character.toString(digits.charAt(pointer)));
            List<Character> currSet = map.get(key);
            for (Character tempChar: currSet) {
                stack.push(tempChar);
                backTracking(stack, pointer + 1);
                stack.pop();
            }
        }
    }
}

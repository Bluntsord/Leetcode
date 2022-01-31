package Interview.Amazon.Amazon1;

import java.util.ArrayList;
import java.util.List;

public class CountCharacters {

    public static void main(String[] args) {
        String[] temp = new String[]{"hello", "world", "leetcode"};
        CountCharacters countCharacters = new CountCharacters();
        int answer = countCharacters.countCharacters(temp, "welldonehoneyr");
        System.out.println(answer);
    }

    List<Character> set;

    public int countCharacters(String[] words, String chars) {
        set = new ArrayList<>();
        for (int i = 0; i < chars.length(); i++) {
            set.add(chars.charAt(i));
        }

        int answer = 0;
        for (String word: words) {
            List<Character> temp = new ArrayList<>(set);
            int numberChar = 0;
            for (int j = 0; j < word.length(); j++) {
                char currChar = word.charAt(j);
                if (!temp.contains(currChar)) {
                    numberChar = 0;
                    break;
                }

                numberChar += 1;
                temp.remove(Character.valueOf(currChar));
            }
            answer += numberChar;
        }

        return answer;
    }

}

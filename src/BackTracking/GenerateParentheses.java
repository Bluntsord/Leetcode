package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    List<String> answer;
    String[][] memo;
    String openBracket = "(";
    String closeBracket = ")";

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        generateParentheses.generateParenthesis(10);
        System.out.println(generateParentheses.answer);
    }

    public List<String> generateParenthesis(int n) {
        answer = new ArrayList<>();
        memo = new String[n + 1][n + 1];
        dp(n, n, "");
        return answer;
    }

    public void dp(int numberOpen, int numberClose, String word) {
        if (numberClose == 0 && numberOpen == 0) {
            answer.add(word);
        } else if (numberOpen == 0) {
            String current = word;
            for (int i = 0; i < numberClose; i++) {
                current += closeBracket;
            }
            answer.add(current);
        } else if (numberClose == 0) {
            String current = word;
            for (int i = 0; i < numberClose; i++) {
                current += openBracket;
            }
            answer.add(current);
        } else if (numberClose == numberOpen) {
            dp(numberOpen - 1, numberClose, word + openBracket);
        } else {
            dp(numberOpen - 1, numberClose, word + openBracket);
            dp(numberOpen, numberClose - 1, word + closeBracket);
        }
    }

    
}

package Interview;

public class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();
        String temp = "011100";
        int answer = solution.solution(temp);
        System.out.println(answer);
    }

    public int solution(String S) {
        int counter = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '0') {
                counter += 1;
            } else {
                break;
            }
        }
        System.out.println(counter);
        String subString = S.substring(counter, S.length());
        System.out.println(subString);

        int answer = 0;
        for (int i = 1; i < subString.length(); i++) {
            if (subString.charAt(i) == '0') {
                answer += 1;
            } else {
                answer += 2;
            }
        }


        return answer + 1;
    }
}

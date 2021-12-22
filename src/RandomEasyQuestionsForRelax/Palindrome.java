package RandomEasyQuestionsForRelax;

public class Palindrome {

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(1231));
    }

    public boolean isPalindrome(int x) {
        String temp = String.valueOf(x);
        int firstPointer = 0;
        int lastPointer = temp.length() - 1;
        boolean answer = true;

        while (firstPointer < lastPointer) {
            char firstChar = temp.charAt(firstPointer);
            char lastChar = temp.charAt(lastPointer);
            answer = answer && (firstChar == lastChar);
            firstPointer ++;
            lastPointer --;
        }

        return answer;
    }
}

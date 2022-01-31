package Interview.Microsoft.Microsoft1;

public class RotateString {

    public static void main(String[] args) {
        String temp = "abcde";
        RotateString rotateString = new RotateString();
        boolean answer = rotateString.rotateString(temp, "cdeab");
        System.out.println(answer);
    }

    public boolean rotateString(String s, String goal) {
        String temp = new String(s);
        System.out.println(temp);
        for (int i = 0; i < s.length(); i++) {
            if (temp.equals(goal)) {
                return true;
            }

            temp = temp.substring(1, temp.length()) + temp.charAt(0);
            System.out.println(temp);
        }

        return false;
    }
}

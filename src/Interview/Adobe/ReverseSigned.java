package Interview.Adobe;

public class ReverseSigned {


    public static void main(String[] args) {
        ReverseSigned reverseSigned = new ReverseSigned();
        System.out.println(-Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        int temp = reverseSigned.reverse(-2147483648);
        System.out.println(temp);
    }


    public int reverse(int x) {
        boolean isNegative = x < 0;
        int number = x < 0
                ? -x
                : x;
        double doubleNumber = number == Integer.MIN_VALUE
                ? Integer.MAX_VALUE + 1
                : number;
        String doubleString = String.valueOf(doubleNumber);
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < doubleString.length(); i++) {
            sb.insert(0, doubleString.charAt(i));
        }

        double reversedDouble = Double.parseDouble(sb.toString());
        System.out.println(reversedDouble);
        if (reversedDouble > Integer.MAX_VALUE || reversedDouble < Integer.MIN_VALUE) {
            return 0;
        }

        reversedDouble = isNegative
                ? -reversedDouble
                : reversedDouble;

        return (int) reversedDouble;
    }
}

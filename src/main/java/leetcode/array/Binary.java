package leetcode.array;

public class Binary {

    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        int carry = 0;

        while (lenA >= 0 || lenB >= 0) {
            int sum = carry;
            if (lenA >= 0) {
                sum += (a.charAt(lenA) - '0');
                lenA--;
            }
                if (lenB >= 0) {
                sum += (b.charAt(lenB) - '0');
                lenB--;
            }
            builder.append(sum%2);
            carry = sum/2;
        }
        if (carry != 0) {
            builder.append(1);
        }
        return builder.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(new Binary().addBinary("1", "111"));
    }
}

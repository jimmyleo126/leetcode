package leetcode.array;

import java.util.*;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] si = new int[digits.length + 1];
        si[0] = 1;
        return si;
    }

    public static void main(String[] args) {
        new PlusOne().plusOne(new int[]{9,8,7,6,5,4,3,2,1,0});
    }
}

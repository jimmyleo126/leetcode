package leetcode.array;

public class Reverse {

    public void reverseString(char[] s) {
        int j = s.length - 1;
        int i = 0;
        while (i < j) {
            swap(s, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        char[] te = new char[]{'h','e','l','l','o'};
        new Reverse().reverseString(te);
        System.out.println(1);
    }
}

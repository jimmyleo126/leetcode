package leetcode.array;

public class ReverseWords2 {

    public String reverseWords(String s) {
        String[] arrs = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String arr : arrs) {
            char[] temp = arr.toCharArray();
            reverseString(temp);
            res.append(temp).append(" ");
        }
        return res.toString().trim();
    }

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
        new ReverseWords2().reverseWords("Let's take LeetCode contest");
    }
}

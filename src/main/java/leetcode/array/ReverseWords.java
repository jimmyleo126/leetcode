package leetcode.array;

public class ReverseWords {

    public String reverseWords(String s) {

        String[] arrs = s.trim().split(" ");
        int left = 0;
        int right = arrs.length - 1;
        while (left < right) {
            String temp = arrs[left];
            arrs[left] = arrs[right];
            arrs[right] = temp;
            left++;
            right--;
        }
        StringBuilder temp = new StringBuilder();
        for (String arr : arrs) {
            if (arr.isEmpty()) {
                continue;
            }
            temp.append(" ").append(arr);
        }
        return temp.toString().trim();
    }

    public static void main(String[] args) {
        new ReverseWords().reverseWords("the    sky is blue");
    }
}

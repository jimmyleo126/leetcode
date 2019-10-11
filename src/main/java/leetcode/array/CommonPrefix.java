package leetcode.array;

public class CommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int min = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < min){
                min = str.length();
            }
        }
        if (min == Integer.MAX_VALUE) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        boolean flag = true;
        for (int i = 0; i < min; i++) {
            char temp = strs[0].charAt(i);
            for (String str : strs) {
                if (temp != str.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                return strs[0].substring(0, i);
            }
        }
        if (flag) {
            return  strs[0].substring(0, min);
        } else {
            return  "";
        }
    }

    public static void main(String[] args) {
        System.out.println(new CommonPrefix().longestCommonPrefix(new String[]{"a", "a"}));
    }
}

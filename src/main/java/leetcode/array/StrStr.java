package leetcode.array;

public class StrStr {
    public int strStr(String haystack, String needle) {
        char[] haysstackChar = haystack.toCharArray();
        char[] neddleChar = needle.toCharArray();
        if (neddleChar.length == 0) {
            return 0;
        }
        char first = neddleChar[0];
        int max = haysstackChar.length - neddleChar.length;

        for (int i = 0; i <= max; i++) {
            /* look for first character */
            if (haysstackChar[i] != first) {
                while (++i <= max && haysstackChar[i] != first){}
            }
            /* Found first Character, now look at rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + neddleChar.length - 1;
                for (int k = 1; j < end && haysstackChar[j] == neddleChar[k]; j++, k++){}
                if (j == end) {
                    /* Found whole string */
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new StrStr().strStr("", "");
    }
}

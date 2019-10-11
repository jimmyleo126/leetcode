package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class YangHui {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        for (int i = 1; i < numRows; i++) {
            List<Integer> subline = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                int n = 0;
                n += (j > 0) ? res.get(i - 1).get(j - 1) : 0;
                n += (j < i) ? res.get(i - 1).get(j) : 0;
                subline.add(n);
            }
            res.add(subline);
        }
        return res;
    }

    public static void main(String[] args) {
        new YangHui().generate(5);
    }
}

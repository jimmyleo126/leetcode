package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Roate {

    public void rotate(int[] nums, int k) {

        while (k > 0) {
            int t = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                nums[i + 1] = nums[i];
            }
            nums[0] = t;
            k--;
        }
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        if (rowIndex == 0) {
            return null;
        }
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        for (int i = 1; i < rowIndex; i++) {
            List<Integer> subline = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                int n = 0;
                n += (j > 0) ? res.get(i - 1).get(j - 1) : 0;
                n += (j < i) ? res.get(i - 1).get(j) : 0;
                subline.add(n);
            }
            res.add(subline);
        }
        return res.get(rowIndex - 1);
    }

    private void swap(int[] nums, int i, int index) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }

    public static void main(String[] args) {
        new Roate().rotate(new int[] {1,2,3,4,5,6,7}, 3);
        new Roate().getRow(3);
    }
}

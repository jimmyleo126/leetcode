package leetcode.array;

import java.util.Arrays;

public class PairSum {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            sum = sum + nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        new PairSum().arrayPairSum(new int[]{1,4,3,2});
    }
}

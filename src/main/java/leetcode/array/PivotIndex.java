package leetcode.array;

public class PivotIndex {

    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0, rightsum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                leftsum = 0;
                rightsum = sum - nums[i];
            } else {
                leftsum += nums[i - 1];
                rightsum -= nums[i];
            }
            if (rightsum == leftsum) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new PivotIndex().pivotIndex(new int[]{1, 2, 3}));
    }
}

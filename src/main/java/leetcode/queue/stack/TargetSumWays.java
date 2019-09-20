package leetcode.queue.stack;

public class TargetSumWays {

    int res = 0;

    public void DFS(int[] nums, int S, int start) {
        if (start >= nums.length) {
            if (S == 0) {
                ++res;
            }
            return;
        }
        DFS(nums, S - nums[start], start + 1);
        DFS(nums, S + nums[start], start + 1);
    }

    public int findTargetSumWays(int[] nums, int S) {
        DFS(nums, S, 0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new TargetSumWays().findTargetSumWays(new int[]{1, 1, 1}, 1));
    }
}

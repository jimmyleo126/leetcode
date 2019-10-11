package leetcode.array;

public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 0;
        int sumAll = 0;
        int numsLength = nums.length;
        int minLength = numsLength + 1;

        while (left < numsLength) {
            if (right < numsLength && sumAll < s) {
                sumAll += nums[right];
                right++;
            } else {
                sumAll -= nums[left];
                left++;
            }
            if (sumAll >= s) {
                minLength = Math.min(minLength, right - left);
            }
        }
        if (minLength == numsLength + 1) {
            return 0;
        }
        return minLength;
    }

    public static void main(String[] args) {
        new MinSubArrayLen().minSubArrayLen(7, new int[] {2,3,1,2,4,3});
    }
}

package leetcode.array;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCounts = 0;
        for (int i = 0; i < nums.length; i++) {
            int counts = 0;
            while (i < nums.length && nums[i] == 1) {
                counts++;
                i++;
            }
            if (counts > maxCounts) {
                maxCounts = counts;
            }
        }
        return maxCounts;
    }

    public static void main(String[] args) {
        new MaxConsecutiveOnes().findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1});
    }
}

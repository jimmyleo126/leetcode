package leetcode.array;

public class Duplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int tmp = nums[0];
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (tmp != nums[i]) {
                nums[j] = nums[i];
                tmp = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        new Duplicates().removeDuplicates(new int[] {});
    }
}

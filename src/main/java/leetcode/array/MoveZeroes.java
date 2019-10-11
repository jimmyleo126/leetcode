package leetcode.array;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
        System.out.println(1);
    }

    private void swap(int[] s, int i, int j) {
        int temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        new MoveZeroes().moveZeroes(new int[] {0,1,0,3,12});
    }
}

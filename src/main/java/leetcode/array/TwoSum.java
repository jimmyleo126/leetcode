package leetcode.array;

public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int j = numbers.length - 1;
        int i = 0;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[] {i + 1, j + 1};
            }
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        for (int i : new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9)) {
            System.out.println(i);
        }
    }
}

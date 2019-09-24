package leetcode.array;

public class DominantIndex {

    public int dominantIndex(int[] nums) {
        int max = 0, submax = 0, index = 0, maxindex = 0;
        for (int num : nums) {

            if (num > max) {
                submax = max;
                max = num;
                maxindex = index;
            } else if ((max > num) && (num > submax)) {
                submax = num;
            }
            index++;
        }
        if (submax * 2 <= max) {
            return maxindex;
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(new DominantIndex().dominantIndex(new int[]{0,0,0,1}));
    }
}

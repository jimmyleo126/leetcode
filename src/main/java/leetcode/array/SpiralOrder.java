package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        int height = matrix.length;
        int width = 0;
        if (height > 0) {
            width = matrix[0].length;
        }
        List<Integer> res = new ArrayList<>();
        int up = 0, down = height - 1, left = 0, right = width - 1;
        while (true) {
            // 从左往右
            for (int j = left; j <= right; j++) {
                res.add(matrix[up][j]);
            }
            // 上面大于下面
            if (++up > down) {
                break;
            }
            // 从右上往右下
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            // 右边小于左边
            if (--right < left) {
                break;
            }
            // 从右下往左下
            for (int j = right; j >= left; j--) {
                res.add(matrix[down][j]);
            }
            // 下边小于上边
            if (--down < up) {
                break;
            }
            // 从左下往左上
            for (int i = down; i >= up; i--) {
                res.add(matrix[i][left]);
            }
            // 从左边超过了右边
            if (++left > right) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SpiralOrder().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}

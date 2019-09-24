package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class DiagonalOrder {

    public int[] findDiagonalOrder(int[][] matrix) {
        List<Integer> integers = new ArrayList<>();
        int Xa = matrix.length;
        int Ya = 0;
        if (Xa > 0) {
            Ya = matrix[0].length;
        }
        int i = 0, j = 0;
        for (int l = 0; l < Xa * Ya; l++) {
            integers.add(matrix[i][j]);
            if ((i + j) % 2 == 0) {
                if (j == Ya - 1) {
                    i++;
                } else if (i == 0) {
                    j++;
                } else {
                    i--;
                    j++;
                }
            } else {
                if (i == Xa - 1) {
                    j++;
                } else if (j == 0) {
                    i++;
                } else {
                    i++;
                    j--;
                }
            }
        }
        int[] res = new int[integers.size()];
        for (int k = 0; k < integers.size(); k++) {
            res[k] = integers.get(k);
        }
        return res;
    }

    public static void main(String[] args) {
        new DiagonalOrder().findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}

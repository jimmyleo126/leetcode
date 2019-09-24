package leetcode.queue;

import sun.security.krb5.internal.rcache.DflCache;

import java.util.Arrays;

public class FloodFill {

    private int Xa;
    private int Ya;

    private int oldColor;
    private int newColor;


    public void DFS(int[][] image, int x, int y) {
        if (x < 0 || x >= Xa || y < 0 || y >= Ya) {
            return;
        }
        if (image[x][y] != oldColor) {
            return;
        }
        image[x][y] = newColor;
        DFS(image, x, y - 1);
        DFS(image, x + 1, y);
        DFS(image, x, y + 1);
        DFS(image, x - 1, y);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Xa = image.length;
        if (Xa > 0 ) {
            Ya = image[0].length;
        }
        this.newColor = newColor;
        oldColor = image[sr][sc];
        if (newColor != oldColor) {
            DFS(image, sr, sc);
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] aaa = {{0,0,0}, {0,1,1}};
        for (int[] ints : aaa) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println("");
        }
        new FloodFill().floodFill(aaa, 1, 1, 1);
    }
}

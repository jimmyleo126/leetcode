package leetcode.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Matrix {

    /**
     * @author Administrator
     */
    private class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

       /* @Override
        public boolean equals(Object obj) {
            Point point = (Point) obj;
            return this.x == point.x && this.y == point.y;
        }*/
    }

    private int Xa;
    private int Ya;

    private List<Point> usedPoints = new ArrayList<>();

    public void BFS(int[][] matrix, int[][] result, int i, int j) {
        usedPoints.clear();
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        int counts = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Point cur = queue.peek();
                if (matrix[cur.x][cur.y] == 0) {
                    result[i][j] = counts;
                    return;
                }
                List<Point> neighbors = roudsMatrix(cur.x, cur.y);
                for (Point neighbor : neighbors) {
                    queue.add(neighbor);
                    usedPoints.add(neighbor);
                }
                queue.poll();
            }
            counts++;
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        Xa = matrix.length;
        if (Xa > 0) {
            Ya = matrix[0].length;
        }
        int[][] result = new int[Xa][Ya];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    BFS(matrix, result, i, j);
                } else {
                    result[i][j] = 0;
                }
            }
        }
        return result;
    }

    public List<Point> roudsMatrix(int x, int y) {
        List<Point> points = new ArrayList<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        for (int i = 0; i < 4; i++) {
            if ((x + dx[i]) < 0 || (x + dx[i]) >= Xa || y + dy[i] < 0 || y + dy[i] >= Ya) {
                continue;
            }
            if (usedPoints.contains(new Point(x + dx[i], y + dy[i]))) {
                continue;
            }
            points.add(new Point(x + dx[i], y + dy[i]));
        }
        return points;
    }

    public static void main(String[] args) {
        int[][] aaa = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        new Matrix().updateMatrix(aaa);
    }
}

package leetcode.queue;

import java.util.*;

public class IsLandsQueue {

    private  int Xa, Ya;

    private Point currentPoint;

    private Queue<Point> points = new LinkedList<Point>();

    private class Point {
        public int x;
        public int y;

        public char value;

        public Point() {
        }

        public Point(int x, int y, char value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            Point p = (Point) obj;
            return p.x == this.x && p.y == this.y;
        }
    }



    public int numIslands(char[][]  grid) {
        Xa = grid.length;
        if (Xa > 0) {
            Ya = grid[0].length;
        } else {
            Ya = 0;
        }
        int counts = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    points.add(new Point(i, j, grid[i][j]));
                    while (!points.isEmpty()) {
                        currentPoint = points.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = currentPoint.x + dx[k];
                            int y = currentPoint.y + dy[k];
                            if (x < 0 || x >= Xa || y < 0 || y >= Ya) {
                                continue;
                            }
                            if (grid[x][y] == '1') {
                                grid[x][y] = '0';
                                points.add(new Point(x, y, grid[x][y]));
                            }
                        }
                    }
                    counts++;
                }

            }
        }

        return counts;
    }



    public static void main(String[] args) {
        IsLandsQueue solution = new IsLandsQueue();
        char[][] m ={

        };
        System.out.println();
        System.out.println(solution.numIslands(m));
    }
}

package leetcode.queue.stack;

public class IsLands {

    private int Xa;
    private int Ya;

    private void DFS(int x, int y, char[][] grid){
        if (x < 0 || x >= Xa || y < 0 || y >= Ya || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        DFS(x, y - 1, grid);
        DFS(x + 1, y, grid);
        DFS(x, y + 1, grid);
        DFS(x - 1, y, grid);

    }

    public int numIslands(char[][]  grid) {
        Xa = grid.length;

        if (Xa > 0) {
            Ya = grid[0].length;
        } else {
            Ya = 0;
        }
        int counts = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    counts++;
                    DFS(i, j, grid);
                }
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        IsLands solution = new IsLands();
        char[][] m ={
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '1'},
                {'0', '0', '1', '0', '0'},
        };
        System.out.println();
        System.out.println(solution.numIslands(m));
    }
}

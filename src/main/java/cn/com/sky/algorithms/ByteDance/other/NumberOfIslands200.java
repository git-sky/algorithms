package cn.com.sky.algorithms.ByteDance.other;

/**
 * LeetCode 200. 岛屿数量【Medium】（阿里/字节高频）
 * 
 * 给你一个由 '1'（陆地）和 '0'（水）组成的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 
 * 算法原理（DFS）：
 * 1. 遍历每个格子，如果是陆地('1')，则发现一个岛屿
 * 2. 使用DFS将该岛屿所有相连的陆地标记为已访问
 * 3. 统计岛屿数量
 * 
 * 时间复杂度：O(m*n)
 * 空间复杂度：O(m*n)
 */
public class NumberOfIslands200 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0';
        
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        NumberOfIslands200 solution = new NumberOfIslands200();
        
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        System.out.println("岛屿数量: " + solution.numIslands(grid));
    }
}
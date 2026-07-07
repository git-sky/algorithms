package cn.com.sky.algorithms.ByteDance.other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 200. 岛屿数量【Medium】（阿里/字节高频）
 * 
 * 给你一个由 '1'（陆地）和 '0'（水）组成的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 
 * 算法原理（DFS/BFS）：
 * 
 * DFS 解法：
 * 1. 遍历每个格子，如果是陆地('1')，则发现一个岛屿
 * 2. 使用DFS将该岛屿所有相连的陆地标记为已访问（改为'0'）
 * 3. 统计岛屿数量
 * 
 * BFS 解法：
 * 1. 遍历每个格子，如果是陆地('1')，则发现一个岛屿
 * 2. 使用队列进行BFS，将该岛屿所有相连的陆地标记为已访问
 * 3. 统计岛屿数量
 * 
 * 时间复杂度：O(m*n)，每个格子访问一次
 * 空间复杂度：O(m*n)，最坏情况全是陆地，递归栈或队列大小为m*n
 */
public class NumberOfIslands200 {

    public static void main(String[] args) {
        NumberOfIslands200 solution = new NumberOfIslands200();
        
        // 测试用例1：正常情况
        char[][] grid1 = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        System.out.println("测试用例1(DFS): " + solution.numIslandsDFS(grid1)); // 1
        
        // 测试用例2：多个岛屿
        char[][] grid2 = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        System.out.println("测试用例2(DFS): " + solution.numIslandsDFS(grid2)); // 3
        
        // 测试用例3：空网格
        char[][] grid3 = {};
        System.out.println("测试用例3(DFS): " + solution.numIslandsDFS(grid3)); // 0
        
        // 测试用例4：单格陆地
        char[][] grid4 = {{'1'}};
        System.out.println("测试用例4(DFS): " + solution.numIslandsDFS(grid4)); // 1
        
        // 测试用例5：单格水
        char[][] grid5 = {{'0'}};
        System.out.println("测试用例5(DFS): " + solution.numIslandsDFS(grid5)); // 0
        
        // 测试用例6：对角线岛屿（不连通）
        char[][] grid6 = {
            {'1','0','1'},
            {'0','1','0'},
            {'1','0','1'}
        };
        System.out.println("测试用例6(DFS): " + solution.numIslandsDFS(grid6)); // 5
        
        // BFS测试
        char[][] grid7 = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        System.out.println("测试用例7(BFS): " + solution.numIslandsBFS(grid7)); // 3
    }

    /**
     * DFS 解法
     */
    public int numIslandsDFS(char[][] grid) {
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
    
    /**
     * DFS 辅助函数
     */
    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        
        // 边界检查
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }
        
        // 标记为已访问
        grid[i][j] = '0';
        
        // 四个方向搜索
        dfs(grid, i - 1, j); // 上
        dfs(grid, i + 1, j); // 下
        dfs(grid, i, j - 1); // 左
        dfs(grid, i, j + 1); // 右
    }

    /**
     * BFS 解法
     */
    public int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        // 四个方向
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    
                    // BFS
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    grid[i][j] = '0'; // 标记为已访问
                    
                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int x = curr[0];
                        int y = curr[1];
                        
                        for (int[] dir : directions) {
                            int nx = x + dir[0];
                            int ny = y + dir[1];
                            
                            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1') {
                                queue.offer(new int[]{nx, ny});
                                grid[nx][ny] = '0'; // 标记为已访问
                            }
                        }
                    }
                }
            }
        }
        
        return count;
    }
}
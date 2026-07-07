package cn.com.sky.algorithms.ByteDance.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 图的环检测（有向图）【Medium】（字节跳动高频）
 * 
 * 检测有向图中是否存在环。
 * 
 * 算法原理（DFS+状态标记）：
 * 使用三种状态标记节点：
 *   0 - 未访问
 *   1 - 正在访问（在当前递归栈中）
 *   2 - 已访问
 * 
 * 时间复杂度：O(V + E)
 * 空间复杂度：O(V)
 */
public class GraphCycleDetection {

    public static void main(String[] args) {
        GraphCycleDetection solution = new GraphCycleDetection();
        
        // 测试用例1：有环
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println("测试用例1(有环): " + solution.hasCycle(3, edges1)); // true
        
        // 测试用例2：无环
        int[][] edges2 = {{0, 1}, {1, 2}, {0, 2}};
        System.out.println("测试用例2(无环): " + solution.hasCycle(3, edges2)); // false
        
        // 测试用例3：单节点自环
        int[][] edges3 = {{0, 0}};
        System.out.println("测试用例3(自环): " + solution.hasCycle(1, edges3)); // true
        
        // 测试用例4：空图
        int[][] edges4 = {};
        System.out.println("测试用例4(空图): " + solution.hasCycle(3, edges4)); // false
        
        // 测试用例5：树结构（无环）
        int[][] edges5 = {{0, 1}, {0, 2}, {1, 3}, {1, 4}};
        System.out.println("测试用例5(树结构): " + solution.hasCycle(5, edges5)); // false
    }

    public boolean hasCycle(int numCourses, int[][] prerequisites) {
        // 构建邻接表
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : prerequisites) {
            adj.get(edge[0]).add(edge[1]);
        }
        
        // 状态数组：0-未访问，1-正在访问，2-已访问
        int[] status = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (status[i] == 0) {
                if (dfs(i, adj, status)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    private boolean dfs(int node, List<List<Integer>> adj, int[] status) {
        // 标记为正在访问
        status[node] = 1;
        
        for (int neighbor : adj.get(node)) {
            if (status[neighbor] == 1) {
                // 发现回边，存在环
                return true;
            }
            if (status[neighbor] == 0 && dfs(neighbor, adj, status)) {
                return true;
            }
        }
        
        // 标记为已访问
        status[node] = 2;
        return false;
    }
}
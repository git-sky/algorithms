package cn.com.sky.algorithms.ByteDance.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 图的环检测（有向图）【Medium】（字节跳动高频）
 * 
 * 检测有向图中是否存在环。
 * 
 * 算法原理（DFS+状态标记）：
 * 
 * 使用三种状态标记节点的访问状态：
 *   0 - 未访问：节点还没有被访问过
 *   1 - 正在访问：节点正在当前递归栈中（正在处理其后代）
 *   2 - 已访问：节点及其所有后代都已处理完毕
 * 
 * DFS遍历过程：
 * 1. 对于每个未访问的节点，开始DFS
 * 2. 将节点标记为"正在访问"（状态1）
 * 3. 递归访问所有邻居节点
 * 4. 如果发现邻居节点状态为1（正在访问），说明存在回边，即存在环
 * 5. 如果邻居节点状态为0（未访问），继续递归
 * 6. 递归返回后，将节点标记为"已访问"（状态2）
 * 
 * 时间复杂度：O(V + E)
 * 空间复杂度：O(V)
 */
public class GraphCycleDetection {

    public static void main(String[] args) {
        GraphCycleDetection solution = new GraphCycleDetection();
        
        // 测试用例1：有环（三角形）
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println("测试用例1(三角形环): " + solution.hasCycle(3, edges1)); // true
        
        // 测试用例2：无环（DAG）
        int[][] edges2 = {{0, 1}, {1, 2}, {0, 2}};
        System.out.println("测试用例2(无环DAG): " + solution.hasCycle(3, edges2)); // false
        
        // 测试用例3：单节点自环
        int[][] edges3 = {{0, 0}};
        System.out.println("测试用例3(单节点自环): " + solution.hasCycle(1, edges3)); // true
        
        // 测试用例4：空图
        int[][] edges4 = {};
        System.out.println("测试用例4(空图): " + solution.hasCycle(3, edges4)); // false
        
        // 测试用例5：树结构（无环）
        int[][] edges5 = {{0, 1}, {0, 2}, {1, 3}, {1, 4}};
        System.out.println("测试用例5(树结构): " + solution.hasCycle(5, edges5)); // false
        
        // 测试用例6：复杂有环图
        int[][] edges6 = {{0, 1}, {1, 2}, {2, 3}, {3, 1}, {4, 0}};
        System.out.println("测试用例6(复杂环): " + solution.hasCycle(5, edges6)); // true
        
        // 测试用例7：多个不连通分量，其中一个有环
        int[][] edges7 = {{0, 1}, {1, 0}, {2, 3}};
        System.out.println("测试用例7(部分有环): " + solution.hasCycle(4, edges7)); // true
        
        // 测试用例8：多个不连通分量，都无环
        int[][] edges8 = {{0, 1}, {2, 3}};
        System.out.println("测试用例8(都无环): " + solution.hasCycle(4, edges8)); // false
        
        // 测试用例9：链式结构（无环）
        int[][] edges9 = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println("测试用例9(链式结构): " + solution.hasCycle(4, edges9)); // false
    }

    /**
     * 检测有向图是否存在环
     * 
     * @param numCourses    节点数量
     * @param prerequisites 边的列表，每个边为 [from, to]
     * @return 是否存在环
     */
    public boolean hasCycle(int numCourses, int[][] prerequisites) {
        // 构建邻接表
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        // 填充邻接表
        for (int[] edge : prerequisites) {
            int from = edge[0];
            int to = edge[1];
            adj.get(from).add(to);
        }
        
        // 状态数组：0-未访问，1-正在访问，2-已访问
        int[] status = new int[numCourses];
        
        // 遍历所有节点
        for (int i = 0; i < numCourses; i++) {
            if (status[i] == 0) {
                // 如果DFS发现环，返回true
                if (dfs(i, adj, status)) {
                    return true;
                }
            }
        }
        
        // 所有节点处理完毕，无环
        return false;
    }

    /**
     * DFS辅助函数
     * 
     * @param node   当前节点
     * @param adj    邻接表
     * @param status 状态数组
     * @return 是否发现环
     */
    private boolean dfs(int node, List<List<Integer>> adj, int[] status) {
        // 将节点标记为"正在访问"
        status[node] = 1;
        
        // 遍历所有邻居节点
        for (int neighbor : adj.get(node)) {
            if (status[neighbor] == 1) {
                // 发现回边，存在环
                return true;
            }
            // 如果邻居节点未访问，继续DFS
            if (status[neighbor] == 0 && dfs(neighbor, adj, status)) {
                return true;
            }
        }
        
        // 将节点标记为"已访问"
        status[node] = 2;
        return false;
    }
}
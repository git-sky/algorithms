package cn.com.sky.algorithms.ByteDance.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 207. 课程表【Medium】（字节/腾讯高频）
 * 
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 * 
 * 算法原理（拓扑排序-Kahn算法）：
 * 1. 构建邻接表表示课程依赖关系
 * 2. 计算每个节点的入度（前驱课程数量）
 * 3. 将入度为0的节点入队（这些课程可以直接学习）
 * 4. 依次出队，减少其邻居节点的入度
 * 5. 如果邻居节点入度变为0，说明其所有前驱都已完成，入队
 * 6. 如果最终处理的节点数等于课程数，说明无环，可以完成所有课程
 * 
 * 时间复杂度：O(V + E)
 * 空间复杂度：O(V + E)
 */
public class CourseSchedule207 {

    public static void main(String[] args) {
        CourseSchedule207 solution = new CourseSchedule207();
        
        // 测试用例1：正常情况，无环
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println("测试用例1(无环): " + solution.canFinish(numCourses1, prerequisites1)); // true
        
        // 测试用例2：有环
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("测试用例2(有环): " + solution.canFinish(numCourses2, prerequisites2)); // false
        
        // 测试用例3：多课程无环
        int numCourses3 = 4;
        int[][] prerequisites3 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println("测试用例3(多课程无环): " + solution.canFinish(numCourses3, prerequisites3)); // true
        
        // 测试用例4：空前提条件
        int numCourses4 = 3;
        int[][] prerequisites4 = {};
        System.out.println("测试用例4(空前提): " + solution.canFinish(numCourses4, prerequisites4)); // true
        
        // 测试用例5：单课程
        int numCourses5 = 1;
        int[][] prerequisites5 = {};
        System.out.println("测试用例5(单课程): " + solution.canFinish(numCourses5, prerequisites5)); // true
        
        // 测试用例6：复杂环
        int numCourses6 = 4;
        int[][] prerequisites6 = {{0, 1}, {1, 2}, {2, 3}, {3, 1}};
        System.out.println("测试用例6(复杂环): " + solution.canFinish(numCourses6, prerequisites6)); // false
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建邻接表
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        // 入度数组
        int[] inDegree = new int[numCourses];
        
        // 填充邻接表和入度数组
        for (int[] pre : prerequisites) {
            int course = pre[0];       // 当前课程
            int prerequisite = pre[1]; // 先修课程
            adj.get(prerequisite).add(course); // 先修课程 -> 当前课程
            inDegree[course]++;       // 当前课程入度+1
        }
        
        // 将入度为0的节点入队
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // 记录已完成的课程数
        int count = 0;
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            
            // 减少邻居节点的入度
            for (int neighbor : adj.get(course)) {
                inDegree[neighbor]--;
                // 如果入度变为0，入队
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // 如果完成的课程数等于总课程数，说明无环
        return count == numCourses;
    }
}
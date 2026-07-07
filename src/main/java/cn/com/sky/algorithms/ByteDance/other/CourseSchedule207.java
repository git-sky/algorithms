package cn.com.sky.algorithms.ByteDance.other;

import java.util.*;

/**
 * LeetCode 207. 课程表【Medium】（字节/腾讯高频）
 * 
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 * 
 * 算法原理（拓扑排序）：
 * 1. 构建邻接表和入度数组
 * 2. 将入度为0的节点入队
 * 3. 依次出队，减少邻居入度，入度为0则入队
 * 4. 如果最终处理的节点数等于课程数，说明无环
 * 
 * 时间复杂度：O(V+E)
 * 空间复杂度：O(V+E)
 */
public class CourseSchedule207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            adj.get(prerequisite).add(course);
            inDegree[course]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            
            for (int neighbor : adj.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return count == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedule207 solution = new CourseSchedule207();
        
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println("能否完成课程: " + solution.canFinish(numCourses, prerequisites));
    }
}
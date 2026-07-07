package cn.com.sky.algorithms.ByteDance.top10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 56. 合并区间【Medium】（字节跳动高频）
 * 
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间。
 * 
 * 算法原理：
 * 1. 按区间起始位置排序
 * 2. 遍历排序后的区间，维护当前合并区间
 * 3. 如果当前区间与合并区间重叠，合并它们
 * 4. 如果不重叠，将合并区间加入结果，更新合并区间为当前区间
 * 
 * 时间复杂度：O(n log n)（主要是排序）
 * 空间复杂度：O(n)
 */
public class MergeIntervals56 {

    public static void main(String[] args) {
        MergeIntervals56 solution = new MergeIntervals56();
        
        // 测试用例1：正常情况
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("测试用例1: " + Arrays.deepToString(solution.merge(intervals1))); // [[1,6],[8,10],[15,18]]
        
        // 测试用例2：重叠区间
        int[][] intervals2 = {{1, 4}, {4, 5}};
        System.out.println("测试用例2: " + Arrays.deepToString(solution.merge(intervals2))); // [[1,5]]
        
        // 测试用例3：空数组
        int[][] intervals3 = {};
        System.out.println("测试用例3: " + Arrays.deepToString(solution.merge(intervals3))); // []
        
        // 测试用例4：单区间
        int[][] intervals4 = {{1, 2}};
        System.out.println("测试用例4: " + Arrays.deepToString(solution.merge(intervals4))); // [[1,2]]
        
        // 测试用例5：完全包含
        int[][] intervals5 = {{1, 10}, {2, 3}, {5, 7}, {11, 12}};
        System.out.println("测试用例5: " + Arrays.deepToString(solution.merge(intervals5))); // [[1,10],[11,12]]
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }
        
        // 按起始位置排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                // 重叠，合并区间
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // 不重叠，加入结果
                result.add(current);
                current = intervals[i];
            }
        }
        
        // 加入最后一个区间
        result.add(current);
        
        return result.toArray(new int[result.size()][]);
    }
}
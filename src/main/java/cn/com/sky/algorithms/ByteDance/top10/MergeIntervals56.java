package cn.com.sky.algorithms.ByteDance.top10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 56. 合并区间【Medium】（字节跳动高频）
 * <p>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间。
 * <p>
 * 算法原理：
 * 1. 按区间起始位置排序
 * 2. 遍历排序后的区间，维护当前合并区间
 * 3. 如果当前区间与合并区间重叠，合并它们
 * 4. 如果不重叠，将合并区间加入结果，更新合并区间为当前区间
 * <p>
 * 时间复杂度：O(n log n)（主要是排序）
 * 空间复杂度：O(n)
 */
public class MergeIntervals56 {

    /**
     * 示例：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        // ① 空数组直接返回
        if (intervals.length == 0) return new int[0][];

        // ② 关键：按左端点升序排序
        // 这样后面的区间左端点一定 ≥ 前面的区间左端点
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // ③ 结果列表
        List<int[]> res = new ArrayList<>();

        // ④ 直接把第一个区间放进去（作为初始合并区间）
        res.add(intervals[0]);

        // ⑤ 从第二个区间开始遍历
        for (int i = 1; i < intervals.length; i++) {
            // 取出结果列表的最后一个区间（即当前正在合并的区间）
            int[] last = res.get(res.size() - 1);
            // 取出当前遍历到的区间
            int[] curr = intervals[i];

            // ⑥ 判断是否重叠
            // curr 的左端点 <= last 的右端点 → 有重叠
            if (curr[0] <= last[1]) {
                // 合并：更新 last 的右端点为两者的最大值
                last[1] = Math.max(last[1], curr[1]);
            } else {
                // 不重叠：直接把当前区间加入结果
                res.add(curr);
            }
        }

        // ⑦ 转换为二维数组返回
        // new int[0][] 是 Java 8+ 的写法，toArray 会自动创建合适大小的数组
        return res.toArray(new int[0][]);
    }


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
}
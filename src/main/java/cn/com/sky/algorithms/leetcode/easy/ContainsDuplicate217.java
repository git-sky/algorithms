package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * <pre>
 * LeetCode 217. 存在重复元素【Easy】
 *
 * 题目描述：给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * 示例：
 * 输入：[1,2,3,1]
 * 输出：true（数字1出现了两次）
 *
 * 输入：[1,2,3,4]
 * 输出：false（所有元素都不同）
 *
 * 算法原理：
 *
 * 方法一：排序后比较相邻元素 ⭐（推荐）
 * - 先对数组排序
 * - 排序后相同的元素会相邻
 * - 只需比较相邻元素是否相等即可
 *
 * 时间复杂度分析：
 * - 排序：O(n log n)
 * - 遍历比较：O(n)
 * - 总计：O(n log n)
 *
 * 空间复杂度：O(1) 或 O(log n)（取决于排序算法的空间）
 *
 * 方法二：HashSet（更直观）
 * - 使用Set存储已遍历的元素
 * - 对于每个元素，检查是否已在Set中
 * - 如果在，返回true；否则加入Set
 *
 * 时间复杂度：平均 O(n)，最坏 O(n^2)（哈希冲突严重时）
 * 空间复杂度：O(n)，需要额外的Set空间
 *
 * 方法对比：
 * - 排序法：时间稍慢但空间最优，且不需要额外空间
 * - HashSet法：时间更快（平均）但需要额外空间
 * - 根据实际场景选择：如果内存充足优先用HashSet；如果要求空间最优用排序法
 * </pre>
 */
public class ContainsDuplicate217 {

    @Test
    public void solution() {
        ContainsDuplicate217 solution = new ContainsDuplicate217();

        // 测试用例1：存在重复元素
        System.out.println("测试用例1: " + solution.containsDuplicate(new int[]{1, 2, 3, 1}));     // true

        // 测试用例2：无重复元素
        System.out.println("测试用例2: " + solution.containsDuplicate(new int[]{1, 2, 3, 4}));    // false

        // 测试用例3：空数组
        System.out.println("测试用例3: " + solution.containsDuplicate(new int[]{}));              // false

        // 测试用例4：单元素
        System.out.println("测试用例4: " + solution.containsDuplicate(new int[]{1}));             // false

        // 测试用例5：多个相同元素
        System.out.println("测试用例5: " + solution.containsDuplicate(new int[]{1, 1, 1, 1}));   // true

        // 测试用例6：负数和正数混合
        System.out.println("测试用例6: " + solution.containsDuplicate(new int[]{-1, 0, 1, -1})); // true

        // 测试用例7：使用HashSet方法验证
        System.out.println("测试用例7(HashSet): " + solution.containsDuplicateHashSet(new int[]{1, 2, 3, 1})); // true
    }

    /**
     * 方法一：排序法（当前使用的方法）⭐
     * 时间复杂度 O(n log n)，空间复杂度 O(1)
     *
     * @param nums 整数数组
     * @return 如果存在重复元素返回true，否则返回false
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }

        // 对数组进行排序
        Arrays.sort(nums);

        // 比较相邻元素
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1]) {
                return true;  // 发现重复元素
            }
        }

        return false;  // 没有发现重复元素
    }

    /**
     * 方法二：HashSet法（更快的平均时间复杂度）
     * 时间复杂度 平均 O(n)，空间复杂度 O(n)
     *
     * @param nums 整数数组
     * @return 如果存在重复元素返回true，否则返回false
     */
    public boolean containsDuplicateHashSet(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);

        for (int x : nums) {
            // 如果元素已在集合中，说明是重复的
            if (set.contains(x)) {
                return true;
            }
            // 否则添加到集合中
            set.add(x);
        }

        return false;  // 没有发现重复元素
    }
}
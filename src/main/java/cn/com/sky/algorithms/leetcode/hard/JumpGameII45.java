package cn.com.sky.algorithms.hard;

import org.junit.Test;

/**
 * <pre>
 * LeetCode 45. 跳跃游戏 II【Hard】（字节跳动高频）
 *
 * 题目描述：给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例：
 * 输入：[2,3,1,1,4]
 * 输出：2（从索引0跳1步到索引1，然后跳3步到最后一个位置）
 *
 * 注意：
 * - 假设你总是可以到达数组的最后一个位置。
 *
 * 算法原理（贪心算法 / BFS思想）：
 * 核心思想：将问题看作是层次遍历（BFS），每一层代表一次跳跃
 *
 * 关键变量说明：
 * - step_count: 当前已执行的跳跃次数
 * - last_jump_max: 上一次跳跃能到达的最远位置（当前层的边界）
 * - current_jump_max: 当前能到达的最远位置（下一层的边界）
 *
 * 算法流程：
 * 1. 遍历数组，不断更新当前能到达的最远位置 current_jump_max
 * 2. 当遍历到上一次跳跃的边界 last_jump_max 时，必须进行一次跳跃
 *    - 跳跃次数加1
 *    - 更新 last_jump_max 为 current_jump_max（进入下一层）
 * 3. 遍历结束即可得到最少跳跃次数
 *
 * 为什么这是最优的？
 * - 在每一层中，我们选择能到达的最远位置作为下一层的边界
 * - 这保证了用最少的跳跃次数覆盖最大的范围
 * - 类似于BFS，第一次到达终点时一定是最短路径
 *
 * 时间复杂度：O(n)，只需一次遍历
 * 空间复杂度：O(1)，只使用了常数额外空间
 *
 * 示例演示（[2,3,1,1,4]）：
 * i=0: current_jump_max=max(0,0+2)=2, i==last_jump_max(0) → step=1, last_jump_max=2
 * i=1: current_jump_max=max(2,1+3)=4
 * i=2: current_jump_max=max(4,2+1)=4, i==last_jump_max(2) → step=2, last_jump_max=4
 * 结束，返回step=2 ✓
 * </pre>
 */
public class JumpGameII45 {

    @Test
    public void solution() {
        JumpGameII45 solution = new JumpGameII45();

        // 测试用例1：正常情况
        System.out.println("测试用例1: " + solution.jump(new int[]{2, 3, 1, 1, 4}));     // 2

        // 测试用例2：单元素
        System.out.println("测试用例2: " + solution.jump(new int[]{0}));                // 0

        // 测试用例3：两元素
        System.out.println("测试用例3: " + solution.jump(new int[]{1, 2}));             // 1

        // 测试用例4：每次只能跳一步
        System.out.println("测试用例4: " + solution.jump(new int[]{1, 1, 1, 1}));       // 3

        // 测试用例5：可以一次跳到终点
        System.out.println("测试用例5: " + solution.jump(new int[]{4, 1, 1, 3, 1, 1, 1})); // 1

        // 测试用例6：较长数组
        System.out.println("测试用例6: " + solution.jump(new int[]{2, 3, 0, 1, 4}));   // 2

        // 测试用例7：最优路径不是每次都跳最大步数
        System.out.println("测试用例7: " + solution.jump(new int[]{1, 2, 3}));         // 2
    }

    /**
     * 贪心算法 - 最优解法
     * 使用BFS思想，每层代表一次跳跃，记录每层能到达的最远位置
     *
     * @param nums 跳跃数组
     * @return 到达终点的最小跳跃次数
     */
    public int jump(int[] A) {
        int step_count = 0;           // 当前跳跃次数
        int last_jump_max = 0;        // 上一次跳跃能到达的最远位置
        int current_jump_max = 0;     // 当前能到达的最远位置

        // 遍历数组（不需要访问最后一个元素，因为已经到达时不需要再跳）
        for (int i = 0; i < A.length - 1; i++) {
            // 更新当前能到达的最远位置
            current_jump_max = Math.max(current_jump_max, i + A[i]);

            // 如果到达了上一次跳跃的边界，必须再跳一次
            if (i == last_jump_max) {
                step_count++;
                last_jump_max = current_jump_max;

                // 优化：如果已经能到达或超过终点，可以提前返回
                if (last_jump_max >= A.length - 1) {
                    break;
                }
            }
        }

        return step_count;
    }

    /**
     * 备选方案：显式BFS实现（代码更直观但稍长）
     * 时间复杂度 O(n)，空间复杂度 O(1)
     */
    /*
    public int jump(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;

        int level = 0;           // 当前层数（跳跃次数）
        int currentMax = 0;      // 当前层的右边界
        int i = 0;               // 当前遍历位置
        int nextMax = 0;         // 下一层的右边界

        // BFS层次遍历
        while (currentMax - i + 1 > 0) {  // 当前层还有节点
            level++;
            // 遍历当前层的所有节点
            for (; i <= currentMax; i++) {
                // 更新下一层能到达的最远位置
                nextMax = Math.max(nextMax, nums[i] + i);
                // 如果已经能到达终点
                if (nextMax >= n - 1) return level;
            }
            // 进入下一层
            currentMax = nextMax;
        }
        return 0;
    }
    */
}
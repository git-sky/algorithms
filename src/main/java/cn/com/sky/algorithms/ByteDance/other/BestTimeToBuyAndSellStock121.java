package cn.com.sky.algorithms.ByteDance.other;

/**
 * LeetCode 121. 买卖股票的最佳时机【Easy】（腾讯/美团高频）
 * 
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择某一天买入这只股票，并选择在未来的某一个不同的日子卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 * 
 * 算法原理：
 * 遍历数组，维护两个变量：
 * 1. minPrice：当前位置之前的最小价格
 * 2. maxProfit：当前最大利润
 * 每天计算当前价格 - minPrice，更新maxProfit
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class BestTimeToBuyAndSellStock121 {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock121 solution = new BestTimeToBuyAndSellStock121();
        
        // 测试用例1：正常情况
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("测试用例1: " + solution.maxProfit(prices1)); // 5
        
        // 测试用例2：价格递减
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("测试用例2: " + solution.maxProfit(prices2)); // 0
        
        // 测试用例3：价格递增
        int[] prices3 = {1, 2, 3, 4, 5};
        System.out.println("测试用例3: " + solution.maxProfit(prices3)); // 4
        
        // 测试用例4：空数组
        int[] prices4 = {};
        System.out.println("测试用例4: " + solution.maxProfit(prices4)); // 0
        
        // 测试用例5：单元素
        int[] prices5 = {5};
        System.out.println("测试用例5: " + solution.maxProfit(prices5)); // 0
        
        // 测试用例6：两天
        int[] prices6 = {2, 1};
        System.out.println("测试用例6: " + solution.maxProfit(prices6)); // 0
        
        // 测试用例7：两天盈利
        int[] prices7 = {1, 2};
        System.out.println("测试用例7: " + solution.maxProfit(prices7)); // 1
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        int minPrice = prices[0];
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        
        return maxProfit;
    }
}
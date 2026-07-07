package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * 122. Best Time to Buy and Sell Stock II【Easy】
 * 
 * 题目：给定一个数组，其中第i个元素是某只股票在第i天的价格。
 * 设计一个算法来计算最大利润。可以完成任意次数的交易（买入一次卖出一次算一次交易），
 * 但不能同时进行多笔交易（必须先卖出再买入）。
 * 
 * 算法原理：
 * 贪心算法 - 只要后一天价格比前一天高，就进行一次买卖
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * </pre>
 */
public class BestTimeToBuyAndSellStockII122 {

    public static void main(String[] args) {
        // 测试用例1：基本情况
        System.out.println("=== 测试用例1：基本情况 ===");
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("最大利润: " + maxProfit(prices1));

        // 测试用例2：连续上涨
        System.out.println("\n=== 测试用例2：连续上涨 ===");
        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("最大利润: " + maxProfit(prices2));

        // 测试用例3：连续下跌
        System.out.println("\n=== 测试用例3：连续下跌 ===");
        int[] prices3 = {5, 4, 3, 2, 1};
        System.out.println("最大利润: " + maxProfit(prices3));

        // 测试用例4：波动市场
        System.out.println("\n=== 测试用例4：波动市场 ===");
        int[] prices4 = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println("最大利润: " + maxProfit(prices4));

        // 测试用例5：空数组或单元素
        System.out.println("\n=== 测试用例5：边界情况 ===");
        int[] prices5 = {};
        int[] prices6 = {1};
        System.out.println("空数组利润: " + maxProfit(prices5));
        System.out.println("单元素利润: " + maxProfit(prices6));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            // 如果后一天价格比前一天高，就进行交易
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
package cn.com.sky.algorithms.ByteDance.other;

/**
 * 给定组合最大数
 *
 * 题目描述：
 * 给定一个数 n（如 23121）和一组数字 A（如 {2,4,9}），
 * 求由 A 中元素组成的、小于 n 的最大数（如小于 23121 的最大数为 22999）。
 *
 * 算法思路：贪心 + 回溯
 *
 * 从最高位开始逐位构造，每一步有两种策略：
 * 1. 放一个等于 n 该位的数字 → 前缀仍等于 n 的前缀，继续受约束
 * 2. 放一个小于 n 该位的最大数字 → 已确定小于 n，剩余位全填 A 中最大值
 *
 * 优先尝试策略1（更接近 n），若后续无解则回溯尝试策略2。
 * 若同位数无法构造出合法数，则降位：用 A 中最大值填满 (len-1) 位。utuutuituitf'f'd'g
 * 空间复杂度：O(m)
 */
public class MaxCombinedNumber {

    public static void main(String[] args) {
        MaxCombinedNumber solution = new MaxCombinedNumber();

        System.out.println("测试用例1: n=23121, A={2,4,9}");
        System.out.println("结果: " + solution.findMaxLessThanN("23121", new int[]{2, 4, 9}));
        System.out.println("预期: 22999\n");

        System.out.println("测试用例2: n=292, A={2,9}");
        System.out.println("结果: " + solution.findMaxLessThanN("292", new int[]{2, 9}));
        System.out.println("预期: 229\n");

        System.out.println("测试用例3: n=222, A={2,9}");
        System.out.println("结果: " + solution.findMaxLessThanN("222", new int[]{2, 9}));
        System.out.println("预期: 99\n");

        System.out.println("测试用例4: n=200, A={2,9}");
        System.out.println("结果: " + solution.findMaxLessThanN("200", new int[]{2, 9}));
        System.out.println("预期: 99\n");

        System.out.println("测试用例5: n=2929, A={2,9}");
        System.out.println("结果: " + solution.findMaxLessThanN("2929", new int[]{2, 9}));
        System.out.println("预期: 2922\n");

        System.out.println("测试用例6: n=9999, A={4,9}");
        System.out.println("结果: " + solution.findMaxLessThanN("9999", new int[]{4, 9}));
        System.out.println("预期: 9994\n");

        System.out.println("测试用例7: n=1000, A={1,9}");
        System.out.println("结果: " + solution.findMaxLessThanN("1000", new int[]{1, 9}));
        System.out.println("预期: 999\n");

        System.out.println("测试用例8: n=4444, A={1,4}");
        System.out.println("结果: " + solution.findMaxLessThanN("4444", new int[]{1, 4}));
        System.out.println("预期: 4441\n");

        System.out.println("测试用例9: n=1111, A={1,4}");
        System.out.println("结果: " + solution.findMaxLessThanN("1111", new int[]{1, 4}));
        System.out.println("预期: 444\n");

        System.out.println("测试用例10: n=1234, A={5,6,7}");
        System.out.println("结果: " + solution.findMaxLessThanN("1234", new int[]{5, 6, 7}));
        System.out.println("预期: 777\n");
    }

    public String findMaxLessThanN(String n, int[] A) {
        int[] sortedA = A.clone();
        java.util.Arrays.sort(sortedA);
        int maxA = sortedA[sortedA.length - 1];

        char[] result = new char[n.length()];
        if (solve(n.toCharArray(), sortedA, 0, result, false)) {
            return new String(result);
        }

        if (n.length() > 1) {
            char[] fewer = new char[n.length() - 1];
            java.util.Arrays.fill(fewer, (char) ('0' + maxA));
            return new String(fewer);
        }

        return "-1";
    }

    private boolean solve(char[] n, int[] A, int pos, char[] result, boolean alreadyLess) {
        if (pos == n.length) {
            return alreadyLess;
        }

        if (alreadyLess) {
            int maxA = A[A.length - 1];
            for (int i = pos; i < n.length; i++) {
                result[i] = (char) ('0' + maxA);
            }
            return true;
        }

        int nDigit = n[pos] - '0';

        int equalDigit = -1;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == nDigit) {
                equalDigit = A[i];
                break;
            }
        }

        int lessDigit = -1;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] < nDigit) {
                lessDigit = A[i];
                break;
            }
        }

        if (equalDigit != -1) {
            result[pos] = (char) ('0' + equalDigit);
            if (solve(n, A, pos + 1, result, false)) {
                return true;
            }
        }

        if (lessDigit != -1) {
            result[pos] = (char) ('0' + lessDigit);
            int maxA = A[A.length - 1];
            for (int i = pos + 1; i < n.length; i++) {
                result[i] = (char) ('0' + maxA);
            }
            return true;
        }

        return false;
    }
}
package cn.com.sky.mytest;

import java.util.Arrays;

/**
 * <pre>
 * 最大组合数问题
 * <p>
 * 【题目】给定一个数字字符串 n 和一个可用数字数组 A，用 A 中的数字（可重复使用）
 * 拼出一个严格小于 n 的最大整数。
 * <p>
 * 【算法原理】贪心 + 回溯 + 二分查找
 * <p>
 * 核心思想：从高位到低位逐位构造结果，每一步都做最优选择：
 * <p>
 * 阶段一：贪心前缀匹配
 * - 从最高位开始，尽量选与 n 对应位"相等"的数字（保持前缀一致）
 * - 如果某一位只能选"小于"对应位的数字，则后续所有位都填 A 中的最大值
 * （因为已经保证了整体 < n，后面越大越好），直接返回
 * - 如果某一位连 ≤ 对应位的数字都找不到，说明前缀匹配失败，进入回溯
 * <p>
 * 阶段二：回溯降位
 * - 从当前位置向前回退，找到第一个可以"降级"的位置
 * - 将该位替换为比当前值更小的最大可选数字
 * - 后续位全部填 A 中的最大值
 * - 如果一直回退到第0位都无法降级，说明同位数不可能 < n，进入阶段三
 * <p>
 * 阶段三：少一位兜底
 * - 如果 n 只有一位且无法满足条件，返回空串
 * - 否则返回长度为 len-1、全部由 A 中最大数字组成的数
 * <p>
 * 【辅助函数】两个二分查找函数在已排序的数组 A 中快速定位目标数字：
 * - findLessOrEqual:   找 ≤ target 的最大元素索引（右边界）
 * - findStrictlyLess:  找 < target 的最大元素索引（严格右边界）
 * <p>
 * 【时间复杂度】O(L × log M)，其中 L = n.length()，M = A.length
 * 【空间复杂度】O(L)
 *
 * 阶段一：贪心前缀匹配
 *     │
 *     ├─ 某位选了 < 对应位 → 填最大值 → 返回结果 ✅
 *     │
 *     └─ 跳出循环（找不到 或 全相等）
 *          │
 *          ↓
 *     阶段二：回溯降位
 *          │
 *          ├─ 找到可降级位 → 降级+填最大值 → 返回结果 ✅
 *          │
 *          └─ 回溯到头仍失败
 *               │
 *               ↓
 *          阶段三：少一位兜底 → 返回更短长度的数
 *
 * </pre>
 *
 */
public class MaxCombinationNumber {

    public static void main(String[] args) {
        String n = "23121";
        int[] A = {2, 4, 9};
        String result = findMaxNumberLessThanN(n, A);
        System.out.println(result);

        n = "20";
        A = new int[]{1, 3, 5, 7};
        result = findMaxNumberLessThanN(n, A);
        System.out.println(result);

        n = "999";
        A = new int[]{2, 4, 9};
        result = findMaxNumberLessThanN(n, A);
        System.out.println(result);

        n = "19";
        A = new int[]{3};
        result = findMaxNumberLessThanN(n, A);
        System.out.println(result);

        n = "2";
        A = new int[]{1};
        result = findMaxNumberLessThanN(n, A);
        System.out.println(result);

        n = "2";
        A = new int[]{3};
        result = findMaxNumberLessThanN(n, A);
        System.out.println(result);


        n = "88";
        A = new int[]{8};
        result = findMaxNumberLessThanN(n, A);
        System.out.println(result);

        System.out.println("===== 边界测试 =====");

        // 边界1: A中包含0
        n = "100";
        A = new int[]{0, 1};
        result = findMaxNumberLessThanN(n, A);
        System.out.println("n=100, A=[0,1] -> " + result + " (期望无前导零)");

        // 边界2: n=1, A=[0]
        n = "1";
        A = new int[]{0};
        result = findMaxNumberLessThanN(n, A);
        System.out.println("n=1, A=[0] -> " + result + " (期望0或空)");

        // 边界3: 阶段一中间break的情况
        n = "31";
        A = new int[]{2, 5};
        result = findMaxNumberLessThanN(n, A);
        System.out.println("n=31, A=[2,5] -> " + result + " (期望25)");

        // 边界4: 需要回溯多位的情况
        n = "444";
        A = new int[]{4};
        result = findMaxNumberLessThanN(n, A);
        System.out.println("n=444, A=[4] -> " + result + " (期望44)");

        // 边界5: 阶段三的极限情况
        n = "10";
        A = new int[]{9};
        result = findMaxNumberLessThanN(n, A);
        System.out.println("n=10, A=[9] -> " + result + " (期望9)");

        // 边界6: A的最小值大于n的首位
        n = "25";
        A = new int[]{6, 8};
        result = findMaxNumberLessThanN(n, A);
        System.out.println("n=25, A=[6,8] -> " + result + " (期望8)");
    }

    /**
     * 用数组 A 中的数字拼出严格小于 n 的最大数
     *
     * @param n 目标数字字符串
     * @param A 可用数字数组（元素可重复使用）
     * @return 拼出的最大数（字符串形式），无解时返回空串或更短长度的最大数
     */
    private static String findMaxNumberLessThanN(String n, int[] A) {
        Arrays.sort(A);
        int len = n.length();
        char[] digits = n.toCharArray();
        char[] result = new char[len];

        int pos = 0;
        while (pos < len) {
            int curDigit = digits[pos] - '0';
            int idx = findLessOrEqual(A, curDigit);
            if (idx == -1) {
                break;
            }
            result[pos] = (char) ('0' + A[idx]);
            if (A[idx] < curDigit) {
                pos++;
                for (int i = pos; i < len; i++) {
                    result[i] = (char) ('0' + A[A.length - 1]);
                }
                return removeLeadingZeros(new String(result));
            }
            pos++;
        }

        while (pos > 0) {
            pos--;
            int curDigit = result[pos] - '0';
            int idx = findStrictlyLess(A, curDigit);
            if (idx != -1) {
                result[pos] = (char) ('0' + A[idx]);
                for (int i = pos + 1; i < len; i++) {
                    result[i] = (char) ('0' + A[A.length - 1]);
                }
                return removeLeadingZeros(new String(result));
            }
        }

        if (len == 1) {
            return "";
        }
        char[] shorter = new char[len - 1];
        Arrays.fill(shorter, (char) ('0' + A[A.length - 1]));
        return new String(shorter);
    }

    /**
     * 去除字符串的前导零（保留最后一个零，如 "0" 不变）
     */
    private static String removeLeadingZeros(String s) {
        int i = 0;
        while (i < s.length() - 1 && s.charAt(i) == '0') {
            i++;
        }
        return s.substring(i);
    }

    /**
     * 在已排序数组 A 中查找 <= target 的最大元素的索引（二分查找右边界）
     *
     * @param A      已排序的升序数组
     * @param target 目标值
     * @return 满足 A[idx] <= target 的最大索引 idx，不存在则返回 -1
     */
    private static int findLessOrEqual(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        int findIdx = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target >= A[mid]) {
                findIdx = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return findIdx;
    }

    /**
     * 在已排序数组 A 中查找 < target 的最大元素的索引（二分查找严格右边界）
     *
     * @param A      已排序的升序数组
     * @param target 目标值
     * @return 满足 A[idx] < target 的最大索引 idx，不存在则返回 -1
     */
    private static int findStrictlyLess(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        int findIdx = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target > A[mid]) {
                findIdx = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return findIdx;
    }
}
package cn.com.sky.algorithms.leetcode.slide_window;

/**
 * <pre>
 *     LeetCode 76. Minimum Window Substring【Hard】
 *
 *     题目描述：给你一个字符串 s 和一个字符串 t，返回 s 中的最小窗口子串，该子串包含包含 t 中的所有字符。
 *     如果 s 中不存在这样的子串，返回空字符串 ""。
 *
 *     示例：
 *     输入：s = "ADOBECODEBANC", t = "ABC"
 *     输出："BANC"
 *
 *     时间复杂度：O(n)
 *     空间复杂度：O(1)
 *
 *     滑动窗口（双指针）。
 *
 *
 *
 */
public class MinWindowSubstring76 {

    public static String minWindow(String s, String t) {
        // 1. 初始化需求数组（ASCII 128位，涵盖所有英文字符）
        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0, right = 0;
        int count = t.length(); // 关键：还需要匹配的字符总数
        int start = 0;          // 记录最小子串的起始位置
        int minLen = Integer.MAX_VALUE; // 记录最小长度

        while (right < s.length()) {
            char c1 = s.charAt(right);
            
            // 2. 右移右指针：
            // 如果当前字符是 t 中需要的，count--
            // 注意：即使 need[c1] 是负数（多余字符），count 也不受影响
            if (need[c1] > 0) {
                count--;
            }
            need[c1]--; // 统一减一，记录窗口内的频次
            right++;     // 窗口扩大

            // 3. 当窗口已覆盖 t (count == 0)，尝试收缩左指针
            while (count == 0) {
                // 更新最小子串
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                char c2 = s.charAt(left);
                // 如果即将移出的字符是 t 中需要的，count++
                // 因为移出后，窗口不再覆盖 t 了
                need[c2]++;
                if (need[c2] > 0) {
                    count++;
                }
                left++; // 窗口缩小
            }
        }

        // 4. 返回结果
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // BANC
        System.out.println(minWindow("a", "aa")); // ""
        System.out.println(minWindow("ab", "a")); // a
    }
}
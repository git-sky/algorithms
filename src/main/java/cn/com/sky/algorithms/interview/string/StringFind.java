package cn.com.sky.algorithms.interview.string;

/**
 * <pre>
 * KMP字符串匹配算法【Hard】
 *
 * 题目：在主串S中查找模式串P第一次出现的位置，如果不存在返回-1。
 *
 * 算法原理（KMP算法，最优）：
 * 1. 预处理模式串P，计算next数组（最长公共前后缀长度）
 *    - next[i]表示P[0..i-1]的最长相等前后缀长度
 *    - 当P[i] != P[j]时，j回退到next[j]继续匹配
 * 2. 匹配过程：
 *    - 当S[i] != P[j]时，j回退到next[j]，i不回退
 *    - 当j == P.length时，匹配成功
 *
 * 为什么KMP比暴力法优？
 * - 暴力法：失配时i回退，j归零，最坏O(m*n)
 * - KMP：i永不回退，j利用next数组跳跃，最坏O(m+n)
 *
 * next数组的含义：
 * next[j] = P[0..j-1]的最长相等前后缀长度
 * 即 P[0..next[j]-1] == P[j-next[j]..j-1]
 * 当P[j]失配时，j回退到next[j]，因为P[0..next[j]-1]已经匹配过了
 *
 * 时间复杂度：O(m+n)，m为主串长度，n为模式串长度
 * 空间复杂度：O(n)，next数组
 * </pre>
 */
public class StringFind {

    public static void main(String[] args) {
        // 测试用例1：正常匹配
        System.out.println("=== 测试用例1：正常匹配 ===");
        String s1 = "BBC ABCDAB ABCDABCDABDE";
        String p1 = "ABCDABD";
        System.out.println("主串: " + s1);
        System.out.println("模式串: " + p1);
        System.out.println("暴力法结果: " + indexOf(s1, p1)); // 15
        System.out.println("KMP结果: " + kmp(s1, p1)); // 15

        // 测试用例2：模式串在开头
        System.out.println("\n=== 测试用例2：模式串在开头 ===");
        String s2 = "ABCDABD";
        String p2 = "ABCDABD";
        System.out.println("KMP结果: " + kmp(s2, p2)); // 0

        // 测试用例3：模式串不存在
        System.out.println("\n=== 测试用例3：模式串不存在 ===");
        String s3 = "ABCDEFG";
        String p3 = "XYZ";
        System.out.println("KMP结果: " + kmp(s3, p3)); // -1

        // 测试用例4：空模式串
        System.out.println("\n=== 测试用例4：空模式串 ===");
        System.out.println("KMP结果: " + kmp("ABC", "")); // 0

        // 测试用例5：重复模式
        System.out.println("\n=== 测试用例5：重复模式 ===");
        String s5 = "AAAAAAAB";
        String p5 = "AAAB";
        System.out.println("KMP结果: " + kmp(s5, p5)); // 4
    }

    /**
     * 暴力法字符串匹配
     * 时间复杂度O(m*n)
     */
    public static int indexOf(String s, String p) {
        if (s == null || p == null || p.length() > s.length()) {
            return -1;
        }
        if (p.length() == 0) {
            return 0;
        }

        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();

        for (int i = 0; i <= ss.length - pp.length; i++) {
            int j;
            for (j = 0; j < pp.length; j++) {
                if (ss[i + j] != pp[j]) {
                    break;
                }
            }
            if (j == pp.length) {
                return i;
            }
        }
        return -1;
    }

    /**
     * KMP字符串匹配算法（最优）
     * 时间复杂度O(m+n)
     */
    public static int kmp(String s, String p) {
        if (s == null || p == null || p.length() > s.length()) {
            return -1;
        }
        if (p.length() == 0) {
            return 0;
        }

        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();

        int[] next = getNext(pp);

        int i = 0;
        int j = 0;

        while (i < ss.length && j < pp.length) {
            if (j == -1 || ss[i] == pp[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == pp.length) {
            return i - j;
        }
        return -1;
    }

    /**
     * 计算next数组
     * next[j] = P[0..j-1]的最长相等前后缀长度
     * next[0] = -1（特殊标记，表示j需要归零）
     *
     * 构造方法：
     * 1. next[0] = -1
     * 2. 如果P[j] == P[k]，则next[j+1] = k+1
     * 3. 如果P[j] != P[k]，则k回退到next[k]
     */
    private static int[] getNext(char[] p) {
        int[] next = new int[p.length];
        next[0] = -1;

        int j = 0;
        int k = -1;

        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }

        return next;
    }
}
package cn.com.sky.algorithms.interview.string;

/**
 * <pre>
 * 字符串匹配算法 - KMP算法【Hard】（字节跳动高频）
 * 
 * 题目描述：在主串S中查找模式串P的第一次出现位置。
 * 
 * KMP算法原理：
 * 1. 预处理模式串P，构建部分匹配表（最长前缀后缀数组）
 * 2. 使用双指针遍历主串和模式串
 * 3. 当字符不匹配时，利用部分匹配表跳过不必要的比较
 * 
 * 部分匹配表（next数组）：
 * - next[i]表示P[0..i]的最长相等前后缀长度
 * - 例如："ABABC"的next数组为[0,0,1,2,0]
 * 
 * 时间复杂度：O(n + m)，n为主串长度，m为模式串长度
 * 空间复杂度：O(m)
 * 
 * 相比暴力匹配的O(n*m)，KMP在最坏情况下有显著优势
 * </pre>
 */
public class StringFind {

    public static void main(String[] args) {
        StringFind kmp = new StringFind();
        
        // 测试用例1：正常匹配
        String s1 = "ABABDABACDABABCABAB";
        String p1 = "ABABCABAB";
        System.out.println("测试用例1: " + kmp.kmpSearch(s1, p1)); // 10
        
        // 测试用例2：模式串在开头
        String s2 = "ABCDEFG";
        String p2 = "ABC";
        System.out.println("测试用例2: " + kmp.kmpSearch(s2, p2)); // 0
        
        // 测试用例3：模式串在结尾
        String s3 = "HELLOWORLD";
        String p3 = "LD";
        System.out.println("测试用例3: " + kmp.kmpSearch(s3, p3)); // 8
        
        // 测试用例4：模式串不存在
        String s4 = "ABCDEFG";
        String p4 = "XYZ";
        System.out.println("测试用例4: " + kmp.kmpSearch(s4, p4)); // -1
        
        // 测试用例5：模式串等于主串
        String s5 = "TEST";
        String p5 = "TEST";
        System.out.println("测试用例5: " + kmp.kmpSearch(s5, p5)); // 0
        
        // 测试用例6：模式串比主串长
        String s6 = "ABC";
        String p6 = "ABCD";
        System.out.println("测试用例6: " + kmp.kmpSearch(s6, p6)); // -1
        
        // 测试用例7：空串
        System.out.println("测试用例7(空模式串): " + kmp.kmpSearch("ABC", "")); // 0
        System.out.println("测试用例7(空主串): " + kmp.kmpSearch("", "ABC")); // -1
        
        // 测试用例8：重复模式
        String s8 = "AAAAA";
        String p8 = "AA";
        System.out.println("测试用例8: " + kmp.kmpSearch(s8, p8)); // 0
    }

    /**
     * KMP字符串匹配
     * 
     * @param text 主串
     * @param pattern 模式串
     * @return 匹配位置，未找到返回-1
     */
    public int kmpSearch(String text, String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            return 0;
        }
        if (text == null || text.isEmpty()) {
            return -1;
        }
        
        int n = text.length();
        int m = pattern.length();
        
        if (m > n) {
            return -1;
        }
        
        // 构建部分匹配表
        int[] next = buildNext(pattern);
        
        int i = 0; // 主串指针
        int j = 0; // 模式串指针
        
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            
            if (j == m) {
                // 找到匹配，返回起始位置
                return i - j;
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                // 不匹配时利用next数组回溯
                if (j != 0) {
                    j = next[j - 1];
                } else {
                    i++;
                }
            }
        }
        
        // 未找到匹配
        return -1;
    }

    /**
     * 构建部分匹配表（next数组）
     * 
     * @param pattern 模式串
     * @return next数组
     */
    private int[] buildNext(String pattern) {
        int m = pattern.length();
        int[] next = new int[m];
        int len = 0; // 当前最长相等前后缀长度
        
        for (int i = 1; i < m; ) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                next[i] = len;
                i++;
            } else {
                if (len != 0) {
                    // 回溯到上一个可能的前缀
                    len = next[len - 1];
                } else {
                    next[i] = 0;
                    i++;
                }
            }
        }
        
        return next;
    }

    /**
     * 暴力匹配算法（对比用）
     * 
     * @param text 主串
     * @param pattern 模式串
     * @return 匹配位置，未找到返回-1
     */
    public int bruteForceSearch(String text, String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            return 0;
        }
        if (text == null || text.isEmpty()) {
            return -1;
        }
        
        int n = text.length();
        int m = pattern.length();
        
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i;
            }
        }
        
        return -1;
    }
}
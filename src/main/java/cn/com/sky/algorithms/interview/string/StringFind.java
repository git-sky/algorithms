package cn.com.sky.algorithms.interview.string;

/**
 * 字符串匹配【Medium】
 * 
 * 在文本字符串中查找模式字符串出现的次数。
 * 
 * 算法原理（KMP算法）：
 * KMP算法通过预处理模式串生成最长前缀后缀数组(LPS)，避免不必要的回溯：
 * 1. 预处理阶段：构建LPS数组
 *    - LPS[i]表示模式串前i+1个字符的最长相等前缀和后缀长度
 * 2. 匹配阶段：
 *    - 使用双指针遍历文本和模式
 *    - 如果字符匹配，同时移动两个指针
 *    - 如果不匹配，利用LPS数组回溯模式指针
 * 
 * 时间复杂度：O(N + M)，N为文本长度，M为模式长度
 * 空间复杂度：O(M)
 */
public class StringFind {

    public static void main(String[] args) {
        StringFind solution = new StringFind();
        
        // 测试用例1：正常匹配
        System.out.println("测试用例1: " + solution.kmpContains("abcabcabx", "abc")); // 2
        
        // 测试用例2：模式在开头
        System.out.println("测试用例2: " + solution.kmpContains("abcdefg", "abc")); // 1
        
        // 测试用例3：模式在结尾
        System.out.println("测试用例3: " + solution.kmpContains("abcdefg", "efg")); // 1
        
        // 测试用例4：多次匹配
        System.out.println("测试用例4: " + solution.kmpContains("aaaaa", "aa")); // 4
        
        // 测试用例5：不匹配
        System.out.println("测试用例5: " + solution.kmpContains("abcdefg", "xyz")); // 0
        
        // 测试用例6：模式等于文本
        System.out.println("测试用例6: " + solution.kmpContains("hello", "hello")); // 1
        
        // 测试用例7：模式大于文本
        System.out.println("测试用例7: " + solution.kmpContains("hi", "hello")); // 0
        
        // 测试用例8：空字符串
        System.out.println("测试用例8: " + solution.kmpContains("", "a")); // 0
        System.out.println("测试用例8: " + solution.kmpContains("abc", "")); // 0
        
        // 测试用例9：特殊字符
        System.out.println("测试用例9: " + solution.kmpContains("abababa", "aba")); // 3
    }

    /**
     * KMP算法查找模式串出现次数
     * 
     * @param text    文本字符串
     * @param pattern 模式字符串
     * @return 模式串出现的次数
     */
    public int kmpContains(String text, String pattern) {
        if (text == null || pattern == null || text.length() < pattern.length()) {
            return 0;
        }
        
        char[] tArray = text.toCharArray();
        char[] pArray = pattern.toCharArray();
        
        int[] lps = computeLPSArray(pArray);
        int count = 0;
        int j = 0; // 模式串指针
        
        for (int i = 0; i < tArray.length; i++) {
            // 如果不匹配，回溯模式指针
            while (j > 0 && tArray[i] != pArray[j]) {
                j = lps[j - 1];
            }
            
            // 如果匹配，移动模式指针
            if (tArray[i] == pArray[j]) {
                j++;
            }
            
            // 如果模式串完全匹配
            if (j == pArray.length) {
                count++;
                // 继续查找下一个匹配（不重叠）
                j = lps[j - 1];
            }
        }
        
        return count;
    }

    /**
     * 计算最长前缀后缀数组(LPS)
     * 
     * @param pattern 模式串字符数组
     * @return LPS数组
     */
    private int[] computeLPSArray(char[] pattern) {
        int n = pattern.length;
        int[] lps = new int[n];
        int len = 0; // 当前最长相等前后缀长度
        
        for (int i = 1; i < n; ) {
            if (pattern[i] == pattern[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    // 回溯到前一个可能的匹配位置
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }
}
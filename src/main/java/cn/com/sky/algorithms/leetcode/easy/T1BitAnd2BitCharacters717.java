package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * LeetCode 717. 1比特与2比特字符【Easy】
 * 
 * 题目描述：有两种特殊字符：第一种用0表示（1比特），第二种用10或11表示（2比特）。
 * 给定一个以0结尾的比特数组，判断最后一个字符是否一定是1比特字符。
 * 
 * 示例1：bits = [1, 0, 0] → true（10 + 0，最后是1比特字符）
 * 示例2：bits = [1, 1, 1, 0] → false（11 + 10，最后是2比特字符）
 * 
 * 算法原理（贪心遍历）：
 * 1. 从左到右遍历比特数组
 * 2. 遇到1，说明是2比特字符，跳过下一个比特（i += 2）
 * 3. 遇到0，说明是1比特字符，前进一位（i += 1）
 * 4. 如果最后恰好停在倒数第二个位置，说明最后一个0是1比特字符
 * 
 * 关键：因为编码方式唯一确定，所以只需按规则解码即可
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * </pre>
 */
public class T1BitAnd2BitCharacters717 {

    public static void main(String[] args) {
        T1BitAnd2BitCharacters717 solution = new T1BitAnd2BitCharacters717();

        // 测试用例1：1比特字符在末尾
        System.out.println("测试用例1: " + solution.isOneBitCharacter(new int[]{1, 0, 0})); // true

        // 测试用例2：2比特字符在末尾
        System.out.println("测试用例2: " + solution.isOneBitCharacter(new int[]{1, 1, 1, 0})); // false

        // 测试用例3：单0
        System.out.println("测试用例3: " + solution.isOneBitCharacter(new int[]{0})); // true

        // 测试用例4：全1+0
        System.out.println("测试用例4: " + solution.isOneBitCharacter(new int[]{1, 1, 0})); // true

        // 测试用例5：交替
        System.out.println("测试用例5: " + solution.isOneBitCharacter(new int[]{1, 0, 1, 0})); // false
    }

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }
}
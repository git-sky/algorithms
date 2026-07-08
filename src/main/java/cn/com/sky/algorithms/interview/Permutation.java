package cn.com.sky.algorithms.interview;

/**
 * <pre>
 * 子集排列问题【Medium】
 *
 * 题目：输出一个集合中选取m个元素的所有排列。
 * 例如输入：{"a","b","c","d"}，m=3
 * 输出：abc, abd, acb, acd, adb, adc, bac, bad, bca, bcd, bda, bdc, ...
 *
 * 算法原理（回溯法 / 交换法）：
 * 1. 从第begin个位置开始，依次将后面的每个元素交换到begin位置
 * 2. 递归处理begin+1位置
 * 3. 回溯：交换回来恢复原状
 * 4. 当begin==m时，输出前m个元素的排列
 *
 * 去重优化：
 * - needSwap方法检查[begin, j)范围内是否有与arr[j]相同的元素
 * - 如果有，说明该元素已经被交换到begin位置处理过，跳过避免重复
 *
 * 时间复杂度：O(A(n,m)) = O(n!/(n-m)!)，即n个中选m个的排列数
 * 空间复杂度：O(m)，递归栈深度
 * </pre>
 */
public class Permutation {

    public static void main(String[] args) {
        // 测试用例1：4个元素选3个排列
        System.out.println("=== 测试用例1：4个元素选3个排列 ===");
        String[] array1 = new String[]{"a", "b", "c", "d"};
        perm(array1, 0, 3, array1.length - 1);

        // 测试用例2：2个元素选2个排列
        System.out.println("\n=== 测试用例2：2个元素全排列 ===");
        String[] array2 = new String[]{"a", "b"};
        perm(array2, 0, 2, array2.length - 1);

        // 测试用例3：含重复元素
        System.out.println("\n=== 测试用例3：含重复元素 ===");
        String[] array3 = new String[]{"a", "b", "b"};
        perm(array3, 0, 2, array3.length - 1);

        // 测试用例4：3个元素选1个
        System.out.println("\n=== 测试用例4：3个元素选1个 ===");
        String[] array4 = new String[]{"a", "b", "c"};
        perm(array4, 0, 1, array4.length - 1);

        // 测试用例5：单元素
        System.out.println("\n=== 测试用例5：单元素 ===");
        String[] array5 = new String[]{"a"};
        perm(array5, 0, 1, array5.length - 1);
    }

    /**
     * 从数组中选取m个元素的排列
     *
     * @param array 元素数组
     * @param begin 当前处理位置
     * @param m     选取的元素个数
     * @param end   数组末尾索引
     */
    private static void perm(String[] array, int begin, int m, int end) {
        if (begin == m) {
            print(array, m);
            return;
        }

        for (int i = begin; i <= end; i++) {
            if (needSwap(array, begin, i)) {
                swap(array, begin, i);
                perm(array, begin + 1, m, end);
                swap(array, begin, i);
            }
        }
    }

    private static void swap(String[] arr, int i, int j) {
        if (i == j) return;
        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 判断是否需要交换位置，相同元素不重复交换
     * 例如abb中，第二个b和第三个b不需要交换
     */
    private static boolean needSwap(String[] arr, int i, int j) {
        for (; i < j; i++) {
            if (arr[i] == arr[j]) {
                return false;
            }
        }
        return true;
    }

    private static void print(String[] array, int end) {
        for (int i = 0; i <= end; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }
}
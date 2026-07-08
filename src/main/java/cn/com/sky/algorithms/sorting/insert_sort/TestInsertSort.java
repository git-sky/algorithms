package cn.com.sky.algorithms.sorting.insert_sort;

import org.junit.Test;

import cn.com.sky.algorithms.sorting.AbstractSort;

/**
 * <pre>
 * 插入排序（Insertion Sort）【Easy】
 *
 * 题目：实现直接插入排序算法
 *
 * 算法原理：
 * 1. 将数组分为已排序部分和未排序部分（初始时第一个元素为已排序）
 * 2. 从未排序部分取出一个元素，在已排序部分中找到合适位置插入
 * 3. 插入位置之后的元素依次后移
 * 4. 重复直到所有元素都插入完成
 *
 * 类似于打扑克牌整理手牌的过程
 *
 * 时间复杂度：
 * - 最坏：O(n^2)（逆序）
 * - 最好：O(n)（已有序）
 * 空间复杂度：O(1)
 * 稳定性：稳定
 * </pre>
 */
public class TestInsertSort extends AbstractSort {

    @Test
    public void sort1() {
        methodName = "sort1";

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                int temp = arr[i];
                int j = i;
                while (j > 0 && arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];
                    j--;

                    count++;
                }
                arr[j] = temp;
                count++;
            }
        }
    }

    @Test
    public void sort2() {
        methodName = "sort2";

        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            int j = 0;
            for (j = i - 1; j >= 0 && arr[j] > tmp; j--) {
                arr[j + 1] = arr[j];
                count++;
            }
            if (j + 1 != i) {
                arr[j + 1] = tmp;
                count++;
            }
        }
    }

    @Test
    public void sort3() {

        methodName = "sort3";

        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                    count++;
                } else {
                    count++;
                    break;
                }
            }
            if (j + 1 != i) {
                arr[j + 1] = tmp;
                count++;
            }
        }
    }

    @Override
    public void sort() {

    }

}
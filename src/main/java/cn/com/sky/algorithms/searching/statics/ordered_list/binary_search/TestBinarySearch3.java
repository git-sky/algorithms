package cn.com.sky.algorithms.searching.statics.ordered_list.binary_search;

/**
 * <pre>
 * 二分查找注意事项与陷阱【Medium】
 *
 * 题目：给定升序排列的含重复数字的数组，实现二分查找返回正确位置
 *
 * 二分查找三大注意事项：
 *
 * 问题一：参数有效性检查
 * - low/high是否构成有效区间？
 * - 数组是否为空？
 * - 不检查可能导致逻辑错误
 *
 * 问题二：中值计算方式
 * - 算法一：mid = (low + high) / 2  ← 可能溢出！
 * - 算法二：mid = low + (high - low) / 2  ← 推荐，无溢出风险
 * - 算法三：mid = (low + high) >>> 1  ← 推荐，无符号右移
 *
 * 问题三：递归 vs 迭代
 * - 递归存在压栈/出栈开销，效率较低
 * - 数据库内核（InnoDB、PostgreSQL）均使用迭代实现
 * - 推荐使用迭代方式
 *
 * 参考：http://hedengcheng.com/?p=595
 * </pre>
 */
public class TestBinarySearch3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
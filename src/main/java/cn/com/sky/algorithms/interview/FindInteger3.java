package cn.com.sky.algorithms.interview;

/**
 * 题目：0-999999之间的所有整数数字中，任何一位都不包括数字3的数字总数有多少个？
 */
public class FindInteger3 {
	public static void main(String[] args) {
		System.out.println(Math.pow(9, 6));
		System.out.println(9 + 8 * 9 + 8 * 9 * 9 + 8 * 9 * 9 * 9 + 8 * 9 * 9 * 9 * 9 + 8 * 9 * 9 * 9 * 9 * 9);
	}
}

/**
 * <pre>
 * 
 * A(4,4)=4x(4-1)x(4-2)x(4-3)x(4-4+1)=4x3x2x1x1=24。
 * 
 * A(6,6)=6x5x4x3x2x1=720。
 * 
 * A(6,4)=6!/(6-4)!=(6x5x4x3x2x1)/2=360。
 * 
 * 排列用符号A(n,m)表示，m≦n。 
 * 计算公式是：A(n,m)＝n(n-1)(n-2)……(n-m+1)＝n!/(n-m)!
 *  此外规定0!=1，n!表示n(n-1)(n-2)…1
 *  
 * 例如：
 * 6!=6x5x4x3x2x1=720，
 * 4!=4x3x2x1=24。
 * 
 * 
 */

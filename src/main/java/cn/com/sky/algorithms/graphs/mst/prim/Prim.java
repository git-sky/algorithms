package cn.com.sky.algorithms.graphs.mst.prim;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * prim算法的实现 输入一带权值的无向连通图 产生改图的最小生成树
 */
public class Prim {
	/*
	 * 使用数字代替字符 A-0，B-1,C-2,D-3,E-4
	 */
	private static final int MOUSTMAX = 1000;

	private static final List<String> START = new ArrayList<String>();

	public static void main(String[] args) {
		// 声明一个二维数组保存边的权值
		int[][] array = new int[5][5];
		// 给二维数组全部赋值
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				array[i][j] = MOUSTMAX;
			}
		}
		// 输入边的权值（采用有向图的方式）
		array[0][2] = 200;// AC权值为200
		array[0][3] = 80;// AD权值为80
		array[0][4] = 50;// AE权值为50
		array[1][2] = 70;// BC权值为70
		array[1][3] = 75;// BD权值为75
		array[1][4] = 300;// BE权值为300
		array[2][3] = 60;// CD权值为60
		array[3][4] = 90;// DE权值为90

		array[2][0] = 200;// AC权值为200
		array[3][0] = 80;// AD权值为80
		array[4][0] = 50;// AE权值为50
		array[2][1] = 70;// BC权值为70
		array[3][1] = 75;// BD权值为75
		array[4][1] = 300;// BE权值为300
		array[3][2] = 60;// CD权值为60
		array[4][3] = 90;// DE权值为90

		// 默认以A点开始
		START.add("E");
		// 保存权值最小边的坐标
		int varx = 100, vary = 100;
		while (true) {
			int min = 1000;
			List<Integer> L = new ArrayList<Integer>();
			for (int i = 0; i < START.size(); i++) {
				if (min > findmin(array, toInt(START.get(i)))) {
					min = findmin(array, toInt(START.get(i)));
					L = findpoint(array, min);
					varx = L.get(0);
					vary = L.get(1);
				}
			}

			System.out.print(toChar(varx) + toChar(vary) + " ");
			// 添加新的点到点集中去
			if (!START.contains(toChar(varx))) {
				START.add(toChar(varx));
			}
			if (!START.contains(toChar(vary))) {
				START.add(toChar(vary));
			}
			// 当点击中包含所有的点的时候退出循环
			if (START.size() == 5) {
				break;
			}
		}

	}

	/**
	 * 找出数组中指定值的坐标并修改值
	 * 
	 * @param array
	 * @param min
	 * @return
	 */
	public static List<Integer> findpoint(int[][] array, int min) {
		List<Integer> L = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i][j] == min) {
					array[i][j] = MOUSTMAX;
					L.add(i);
					L.add(j);
					break;
				}
			}
		}
		return L;
	}

	/**
	 * 找出以某点为顶点权值最小的边
	 * 
	 * @param array
	 *            代表权值的数组
	 * @param point
	 *            点代表的数字
	 * @return
	 */
	public static int findmin(int[][] array, int point) {
		int min = array[0][0];
		// 找出权值最小边
		for (int j = 0; j < array.length; j++) {
			if (array[point][j] <= min) {
				min = array[point][j];
			}
		}
		return min;
	}

	/**
	 * 实现有字符向数值转换
	 * 
	 * @param char1
	 * @return
	 */
	public static int toInt(String char1) {
		int num = Integer.MAX_VALUE;
		if ("A".equals(char1)) {
			num = 0;
		}
		if ("B".equals(char1)) {
			num = 1;
		}
		if ("C".equals(char1)) {
			num = 2;
		}
		if ("D".equals(char1)) {
			num = 3;
		}
		if ("E".equals(char1)) {
			num = 4;
		}

		return num;
	}

	/**
	 * 实现有数值向字符转变
	 * 
	 * @param var
	 * @return
	 */
	public static String toChar(int var) {
		String char1 = "";
		switch (var) {
		case 0:
			char1 = "A";
			break;
		case 1:
			char1 = "B";
			break;

		case 2:
			char1 = "C";
			break;

		case 3:
			char1 = "D";
			break;

		case 4:
			char1 = "E";
			break;

		}
		return char1;
	}

}
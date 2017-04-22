package cn.com.sky.algorithms.others.classical;

import java.util.Stack;

/**
 * <pre>
 * 回溯法是一种不断试探且及时纠正错误的搜索方法，下面的求解过程采用回溯法。从入口出发，按某一方向向前探索，若能走通（未走过的），即某处可以到达，则到达一个新点，否则试探下一个方向；若所有的方向均没有通路，则沿原路返回前一点，换下一个方向继续试探，直到所有可能的通路都搜索到，或找到一条通路，或无路可走又返回到入口点。这里可以用一个栈来实现，每走一步，将该位置压入栈中，若该点无路可走，则出栈返回上一位置。
 * 需要解决的四个问题：
 * （1）表示迷宫的数据结构
 * 　　设迷宫为m行n列，利用数组maze[m][n]来表示一个迷宫，maze[i][j]=0或1，其中0表示通路，1表示不通。迷宫该数组四边都为1，代表迷宫四周都是墙。这样就可以保证每个点都有8个方向可以试探。
 * 　　入口为（1,1），出口为（6,8）
 * 　　1,1,1,1,1,1,1,1,1,1
 *     1,0,1,1,1,0,1,1,1,1
 *     1,1,0,1,0,1,1,1,1,1
 *     1,0,1,0,0,0,0,0,1,1
 *     1,0,1,1,1,0,1,1,1,1
 *     1,1,0,0,1,1,0,0,0,1
 *     1,0,1,1,0,0,1,1,0,1
 *     1,1,1,1,1,1,1,1,1,1
 * （2）试探方向
 * 　　迷宫中间每个点都有8个方向可以试探。其增量数组可以用一个8*2的二维数组move表述，表示对当前点而言,它周围8个点的行和列的坐标偏移量.具体值如下：
 * 　　　　　　  x　　y
 *           0　 0　　1
 *           1   1    1
 *           2   1    0
 *           3   1   -1
 *           4   0   -1
 *           5  -1   -1
 *           6  -1    0
 *           7  -1    1
 * 在move数组中，x表示横坐标的增量，y表示纵坐标的增量。
 * 　　（3）栈中存放元素的设计
 * 　　栈中所存放的元素应该包含所到达的每点的坐标以及从该点沿哪个方向向下走的,可用一个类表示:
 * class Step{
 *      int x,y,d;
 *      public Step(int x,int y,int d) {
 *          this.x = x;//横坐标
 *          this.y = y;//纵坐标
 *          this.d = d;//方向
 *      }
 *  }
 * （4）防止重复到达某点而发生死循环
 * 　　使maze[i][j]置为-1，以便区别为达到的点，同样也可以防止走重复点的作用。
 * 源码如下:
 * 
 */

class Step {
	int x, y, d;

	public Step(int x, int y, int d) {
		this.x = x;// 横坐标
		this.y = y;// 纵坐标
		this.d = d;// 方向
	}
}

/**
 * 走迷宫算法
 * 
 */
public class TestMaze {

	public static void main(String[] args) {
		// 迷宫定义
		int[][] maze = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 1, 0, 1, 0, 1, 1, 1, 1, 1 }, { 1, 0, 1, 0, 0, 0, 0, 0, 1, 1 },
				{ 1, 0, 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 1, 0, 0, 1, 1, 0, 0, 0, 1 }, { 1, 0, 1, 1, 0, 0, 1, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
		int[][] move = { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
		Stack<Step> s = new Stack<Step>();
		int result = path(maze, move, s);
		System.out.println(result);
		while (!s.isEmpty()) {
			Step step = s.pop();
			System.out.println(step.x + ":" + step.y);
		}
	}

	public static int path(int[][] maze, int[][] move, Stack<Step> s) {
		Step temp = new Step(1, 1, -1); // 起点
		s.push(temp);
		while (!s.isEmpty()) {
			temp = s.pop();
			int x = temp.x;
			int y = temp.y;
			int d = temp.d + 1;
			while (d < 8) {
				int i = x + move[d][0];
				int j = y + move[d][1];
				if (maze[i][j] == 0) { // 该点可达
					temp = new Step(i, j, d); // 到达新点
					s.push(temp);
					x = i;
					y = j;
					maze[x][y] = -1; // 到达新点，标志已经到达
					if (x == 6 && y == 8) {
						return 1; // 到达出口，迷宫有路，返回1
					} else {
						d = 0; // 重新初始化方向
					}
				} else {
					d++; // 改变方向
				}
			}
		}
		return 0;
	}

}
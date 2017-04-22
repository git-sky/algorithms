package cn.com.sky.algorithms.searching.dynamics.skiplist;

import java.util.Random;

/**
 * 跳表
 * 
 * 说明： JumpList是一个按照值的大小有序排列的链表
 */
public class JumpList {
	private final int MAXN = 100;
	public JumpNode head = new JumpNode(MAXN); // 存放各层链表的第一个对象的用
	public JumpNode tail = new JumpNode(MAXN); // 各层链表结尾都要指向该引用
	public JumpNode[] pres = new JumpNode[MAXN]; // 插入、删除操作前要在该数组中存入待插入或删除元素前趋节点的引用
	public int levels; // 链表层数

	public JumpList() {
		tail = new JumpNode(1);
		for (int i = 0; i < MAXN; i++) {
			head.nextLinks[i] = tail; // 初始指向tail
			pres[i] = head;
		}
		levels = 0;
	}

	/*
	 * 功能： 根据给定的元素，获取其前驱节点(x在链表中)或x应插入位置在各层链表中的前驱节点的引用
	 */
	public void updatePresRef(int x) {
		for (int i = 0; i <= levels; i++) {// 这里要注意：i应<=levels，不应<，否则会有一个bug
			JumpNode p = head;
			while (p.nextLinks[i].value < x) {
				p = p.nextLinks[i];
			}
			pres[i] = p;
		}
	}

	/*
	 * 功能：对于新增节点根据概率随机分配其nextLinks数组的大小
	 */
	public int getLevel() {
		Random rand = new Random();
		int lev = 0;
		while (rand.nextInt() <= Integer.MAX_VALUE / 2) {// 以1/2的概率进入循环，每循环一次相当于乘一次1/2
			++lev; // 高度增加1
			if (lev >= MAXN) { // 限制lev的无限增加
				lev = MAXN - 1;
				break;
			}
		}
		if (lev > levels) { // 减少空层浪费
			lev = levels++;
		}
		return lev;
	}

	/*
	 * 功能：将元素x插入JumpList中，采用无则插入，有则放弃的原则
	 */
	public void insertElement(int x) {
		updatePresRef(x);
		if (pres[0].nextLinks[0].value == x) {
			return; // x已存在，返回
		}
		int lev = getLevel();
		JumpNode node = new JumpNode(lev + 1);
		node.value = x;
		for (int i = 0; i <= lev; i++) {
			node.nextLinks[i] = pres[i].nextLinks[i];
			pres[i].nextLinks[i] = node;
		}
	}

	// 删除操作：有则删，无则不变
	public void deleteElement(int x) {
		updatePresRef(x);
		if (pres[0].nextLinks[0].value != x) {
			return; // x不存在，返回
		}

		for (int i = 0; pres[i].nextLinks[i].value == x; i++) {
			pres[i].nextLinks[i] = pres[i].nextLinks[i].nextLinks[i];
		}
	}

	public void display() {
		JumpNode p = head.nextLinks[0];
		while (p != tail) {
			System.out.print(p.value + " ");
			p = p.nextLinks[0];
		}
		System.out.println();
	}

	public static void main(String[] args) {
		JumpList jl = new JumpList();
		jl.insertElement(10);
		jl.insertElement(4);
		jl.insertElement(5);
		jl.insertElement(7);
		jl.display();
		jl.deleteElement(1);
		jl.display();
		jl.deleteElement(7);
		jl.display();
	}
}

class JumpNode {
	public int value;
	public JumpNode[] nextLinks = null;

	public JumpNode(int size) {
		nextLinks = new JumpNode[size];
		value = Integer.MAX_VALUE;
	}
}

/*
 * 感想： 1.为了插入和删除的方便，采用链表头节点的思想，在跳表前端附加一个节点， 这样即便每一层没有元素pres[i]指向head也是正确的(若不附加，指向head则是指向tail)，
 * 话说原来没有想到，纠结了半天...... 2.将tail的value设置为Integer.MAX_VALUE
 * 3.看着书上敲代码也不简单啊，如果没有完全搞懂原理并且对自己所用语言的某知识点有些不熟悉， 往往会出现一些细节的bug，找起来也很麻烦。暂时还没有好的解决办法......
 */
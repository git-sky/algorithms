package cn.com.sky.algorithms.interview.stack_queue;

import java.util.ArrayList;
import java.util.Random;

/**
 * <pre>
 * 
 * 问题：如何仅使用递归函数和栈操作逆序一个栈
 * 
 * </pre>
 */
public class DogCat {

	public static void main(String[] args) {

		DogCat dc = new DogCat();
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			int type = r.nextInt(100) % 2;
			Pet p = null;
			if (type == 0) {
				p = new DogCat().new Dog();
			} else {
				p = new DogCat().new Cat();
			}
			dc.add(p);
			System.out.println("add:" + p);
		}

//		while (!dc.isEmpty()) {
//			System.out.println("pollAll:" + dc.pollAll());
//		}

		while (!dc.isDogEmpty()) {
			System.out.println("pollDog:" + dc.pollDog());
		}

		while (!dc.isCatEmpty()) {
			System.out.println("pollCat:" + dc.pollCat());
		}

	}

	private ArrayList<Pet> q = new ArrayList<Pet>();

	public void add(Pet p) {
		q.add(p);
	}

	public Pet pollAll() {
		return q.remove(0);
	}

	public Pet pollDog() {
		int index = -1;
		for (Pet p : q) {
			index++;
			if (p instanceof Dog) {
				return q.remove(index);
			}
		}
		return null;
	}

	public Pet pollCat() {
		int index = -1;
		for (Pet p : q) {
			index++;
			if (p instanceof Cat) {
				return q.remove(index);
			}
		}
		return null;
	}

	public boolean isEmpty() {
		return q.isEmpty();
	}

	public boolean isDogEmpty() {
		for (Pet p : q) {
			if (p instanceof Dog) {
				return false;
			}
		}
		return true;
	}

	public boolean isCatEmpty() {
		for (Pet p : q) {
			if (p instanceof Cat) {
				return false;
			}
		}
		return true;
	}

	public class Pet {
		private String type;

		public Pet(String type) {
			this.type = type;
		}

		public String getPetType() {
			return this.type;
		}
	}

	public class Dog extends Pet {
		public Dog() {
			super("dog");
		}
	}

	public class Cat extends Pet {
		public Cat() {
			super("cat");
		}
	}
}

package cn.com.sky.algorithms.interview.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * 猫狗队列问题【Medium】
 * 
 * 题目描述：实现一个猫狗队列，支持以下操作：
 * 1. add(pet) - 添加宠物（猫或狗）
 * 2. poll() - 弹出最早加入的宠物
 * 3. pollDog() - 弹出最早加入的狗
 * 4. pollCat() - 弹出最早加入的猫
 * 5. isEmpty() - 判断队列是否为空
 * 6. isDogEmpty() - 判断狗队列是否为空
 * 7. isCatEmpty() - 判断猫队列是否为空
 * 
 * 算法原理：
 * 使用两个队列分别存储猫和狗，同时为每个宠物添加时间戳：
 * 1. 添加宠物时，记录时间戳并加入对应队列
 * 2. 弹出时比较两个队列头部的时间戳，选择较早的
 * 
 * 时间复杂度：O(1)（所有操作）
 * 空间复杂度：O(n)
 * </pre>
 */
public class DogCat {

    public static void main(String[] args) {
        DogCatQueue queue = new DogCatQueue();
        
        // 测试用例1：正常添加和弹出
        queue.add(new Dog("旺财"));
        queue.add(new Cat("咪咪"));
        queue.add(new Dog("大黄"));
        System.out.println("测试用例1(poll): " + queue.poll()); // Dog(旺财)
        System.out.println("测试用例1(pollDog): " + queue.pollDog()); // Dog(大黄)
        System.out.println("测试用例1(pollCat): " + queue.pollCat()); // Cat(咪咪)
        
        // 测试用例2：交替添加
        queue.add(new Cat("小黑"));
        queue.add(new Dog("阿福"));
        queue.add(new Cat("雪球"));
        System.out.println("测试用例2(poll): " + queue.poll()); // Cat(小黑)
        System.out.println("测试用例2(poll): " + queue.poll()); // Dog(阿福)
        
        // 测试用例3：空队列弹出
        System.out.println("测试用例3(isEmpty): " + queue.isEmpty()); // false
        queue.poll(); // Cat(雪球)
        System.out.println("测试用例3(isEmpty): " + queue.isEmpty()); // true
    }

    /**
     * 宠物抽象类
     */
    public static abstract class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    /**
     * 狗类
     */
    public static class Dog extends Pet {
        public Dog(String name) {
            super("dog");
            this.name = name;
        }
        
        private String name;
        
        public String getName() {
            return name;
        }
        
        @Override
        public String toString() {
            return "Dog(" + name + ")";
        }
    }

    /**
     * 猫类
     */
    public static class Cat extends Pet {
        public Cat(String name) {
            super("cat");
            this.name = name;
        }
        
        private String name;
        
        public String getName() {
            return name;
        }
        
        @Override
        public String toString() {
            return "Cat(" + name + ")";
        }
    }

    /**
     * 带时间戳的宠物包装类
     */
    private static class PetEnter {
        public Pet pet;
        public long count;

        public PetEnter(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }
    }

    /**
     * 猫狗队列实现
     */
    public static class DogCatQueue {
        private Queue<PetEnter> dogQ;
        private Queue<PetEnter> catQ;
        private long count;

        public DogCatQueue() {
            this.dogQ = new LinkedList<>();
            this.catQ = new LinkedList<>();
            this.count = 0;
        }

        /**
         * 添加宠物
         */
        public void add(Pet pet) {
            if (pet.getPetType().equals("dog")) {
                this.dogQ.add(new PetEnter(pet, this.count++));
            } else if (pet.getPetType().equals("cat")) {
                this.catQ.add(new PetEnter(pet, this.count++));
            } else {
                throw new RuntimeException("Not dog or cat!");
            }
        }

        /**
         * 弹出最早加入的宠物
         */
        public Pet poll() {
            if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
                if (this.dogQ.peek().count < this.catQ.peek().count) {
                    return this.dogQ.poll().pet;
                } else {
                    return this.catQ.poll().pet;
                }
            } else if (!this.dogQ.isEmpty()) {
                return this.dogQ.poll().pet;
            } else if (!this.catQ.isEmpty()) {
                return this.catQ.poll().pet;
            } else {
                throw new RuntimeException("Queue is empty!");
            }
        }

        /**
         * 弹出最早加入的狗
         */
        public Dog pollDog() {
            if (this.isDogEmpty()) {
                throw new RuntimeException("Dog queue is empty!");
            }
            return (Dog) this.dogQ.poll().pet;
        }

        /**
         * 弹出最早加入的猫
         */
        public Cat pollCat() {
            if (this.isCatEmpty()) {
                throw new RuntimeException("Cat queue is empty!");
            }
            return (Cat) this.catQ.poll().pet;
        }

        /**
         * 判断队列是否为空
         */
        public boolean isEmpty() {
            return this.dogQ.isEmpty() && this.catQ.isEmpty();
        }

        /**
         * 判断狗队列是否为空
         */
        public boolean isDogEmpty() {
            return this.dogQ.isEmpty();
        }

        /**
         * 判断猫队列是否为空
         */
        public boolean isCatEmpty() {
            return this.catQ.isEmpty();
        }
    }
}
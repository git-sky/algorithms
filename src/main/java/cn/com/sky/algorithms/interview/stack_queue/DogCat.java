package cn.com.sky.algorithms.interview.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗队列【Medium】
 * 
 * 实现一个队列，可以添加猫或狗，支持按顺序出队，也支持只出猫或只出狗。
 * 
 * 算法原理（双队列+时间戳）：
 * 使用两个队列分别存储猫和狗，每个元素携带时间戳：
 * 1. 添加元素时，根据类型放入对应的队列，并记录时间戳
 * 2. 按顺序出队时，比较两个队列的队首元素时间戳，取出较早的
 * 3. 只出猫或只出狗时，直接从对应队列取出
 * 
 * 时间复杂度：O(1)（所有操作）
 * 空间复杂度：O(n)
 */
public class DogCat {

    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    /**
     * 带时间戳的宠物包装类
     */
    private static class PetEnter {
        private Pet pet;
        private long timestamp;

        public PetEnter(Pet pet, long timestamp) {
            this.pet = pet;
            this.timestamp = timestamp;
        }

        public Pet getPet() {
            return this.pet;
        }

        public long getTimestamp() {
            return this.timestamp;
        }
    }

    private Queue<PetEnter> dogQueue;
    private Queue<PetEnter> catQueue;
    private long count;

    public DogCat() {
        this.dogQueue = new LinkedList<>();
        this.catQueue = new LinkedList<>();
        this.count = 0;
    }

    public static void main(String[] args) {
        DogCat queue = new DogCat();
        
        // 测试用例1：添加和按顺序出队
        queue.add(new Dog());
        queue.add(new Cat());
        queue.add(new Dog());
        queue.add(new Cat());
        
        System.out.println("测试用例1(按顺序出队):");
        System.out.println(queue.pollAll().getType()); // dog
        System.out.println(queue.pollAll().getType()); // cat
        System.out.println(queue.pollAll().getType()); // dog
        System.out.println(queue.pollAll().getType()); // cat
        
        // 测试用例2：只出猫或只出狗
        queue.add(new Dog());
        queue.add(new Cat());
        queue.add(new Dog());
        
        System.out.println("\n测试用例2(只出狗):");
        System.out.println(queue.pollDog().getType()); // dog
        System.out.println(queue.pollDog().getType()); // dog
        
        System.out.println("\n测试用例2(只出猫):");
        System.out.println(queue.pollCat().getType()); // cat
        
        // 测试用例3：空队列操作
        System.out.println("\n测试用例3(check):");
        System.out.println("isEmpty: " + queue.isEmpty()); // true
        System.out.println("isDogEmpty: " + queue.isDogEmpty()); // true
        System.out.println("isCatEmpty: " + queue.isCatEmpty()); // true
        
        // 测试用例4：混合操作
        queue.add(new Cat());
        queue.add(new Dog());
        queue.add(new Cat());
        
        System.out.println("\n测试用例4(混合操作):");
        System.out.println(queue.pollCat().getType()); // cat
        System.out.println(queue.pollAll().getType()); // dog
        System.out.println(queue.pollAll().getType()); // cat
    }

    public void add(Pet pet) {
        if (pet.getType().equals("dog")) {
            this.dogQueue.add(new PetEnter(pet, this.count++));
        } else if (pet.getType().equals("cat")) {
            this.catQueue.add(new PetEnter(pet, this.count++));
        } else {
            throw new RuntimeException("Unknown pet type");
        }
    }

    public Pet pollAll() {
        if (!this.dogQueue.isEmpty() && !this.catQueue.isEmpty()) {
            if (this.dogQueue.peek().getTimestamp() < this.catQueue.peek().getTimestamp()) {
                return this.dogQueue.poll().getPet();
            } else {
                return this.catQueue.poll().getPet();
            }
        } else if (!this.dogQueue.isEmpty()) {
            return this.dogQueue.poll().getPet();
        } else if (!this.catQueue.isEmpty()) {
            return this.catQueue.poll().getPet();
        } else {
            throw new RuntimeException("Queue is empty");
        }
    }

    public Dog pollDog() {
        if (this.isDogEmpty()) {
            throw new RuntimeException("Dog queue is empty");
        }
        return (Dog) this.dogQueue.poll().getPet();
    }

    public Cat pollCat() {
        if (this.isCatEmpty()) {
            throw new RuntimeException("Cat queue is empty");
        }
        return (Cat) this.catQueue.poll().getPet();
    }

    public boolean isEmpty() {
        return this.dogQueue.isEmpty() && this.catQueue.isEmpty();
    }

    public boolean isDogEmpty() {
        return this.dogQueue.isEmpty();
    }

    public boolean isCatEmpty() {
        return this.catQueue.isEmpty();
    }
}
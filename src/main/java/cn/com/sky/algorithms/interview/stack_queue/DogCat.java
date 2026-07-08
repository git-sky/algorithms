package cn.com.sky.algorithms.interview.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * 猫狗队列【Medium】
 *
 * 题目：实现一种猫狗队列结构，要求：
 * 1. 可以调用add方法将cat或dog类的实例放入队列
 * 2. 可以调用pollAll方法，按进队顺序依次弹出所有实例
 * 3. 可以调用pollDog方法，按进队顺序依次弹出dog实例
 * 4. 可以调用pollCat方法，按进队顺序依次弹出cat实例
 * 5. 可以调用isEmpty方法，检查队列是否为空
 * 6. 可以调用isDogEmpty方法，检查dog队列是否为空
 * 7. 可以调用isCatEmpty方法，检查cat队列是否为空
 *
 * 算法原理（双队列 + 时间戳）：
 * 1. 使用两个队列分别存储cat和dog
 * 2. 每个元素附带一个递增的时间戳count
 * 3. pollAll时比较两个队列队头的时间戳，弹出时间戳较小的
 * 4. pollDog/pollCat直接从对应队列弹出
 *
 * 时间复杂度：add O(1)，pollAll O(1)，pollDog O(1)，pollCat O(1)
 * 空间复杂度：O(n)
 * </pre>
 */
public class DogCat {

    public static void main(String[] args) {
        DogCatQueue queue = new DogCatQueue();

        // 测试用例1：正常操作
        System.out.println("=== 测试用例1：正常操作 ===");
        queue.add(new Dog("dog1"));
        queue.add(new Cat("cat1"));
        queue.add(new Dog("dog2"));
        queue.add(new Cat("cat2"));
        queue.add(new Dog("dog3"));

        System.out.println("isEmpty: " + queue.isEmpty()); // false
        System.out.println("isDogEmpty: " + queue.isDogEmpty()); // false
        System.out.println("isCatEmpty: " + queue.isCatEmpty()); // false

        System.out.println("pollAll: " + queue.pollAll().getPetType()); // dog
        System.out.println("pollCat: " + queue.pollCat().getPetType()); // cat
        System.out.println("pollDog: " + queue.pollDog().getPetType()); // dog
        System.out.println("pollAll: " + queue.pollAll().getPetType()); // cat
        System.out.println("pollAll: " + queue.pollAll().getPetType()); // dog

        // 测试用例2：只添加猫
        System.out.println("\n=== 测试用例2：只添加猫 ===");
        DogCatQueue queue2 = new DogCatQueue();
        queue2.add(new Cat("cat3"));
        queue2.add(new Cat("cat4"));
        System.out.println("isDogEmpty: " + queue2.isDogEmpty()); // true
        System.out.println("pollCat: " + queue2.pollCat().getPetType()); // cat
        System.out.println("pollCat: " + queue2.pollCat().getPetType()); // cat
    }

    static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    static class Dog extends Pet {
        public Dog(String name) {
            super("dog");
        }
    }

    static class Cat extends Pet {
        public Cat(String name) {
            super("cat");
        }
    }

    static class PetEnter {
        Pet pet;
        long count;

        PetEnter(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return this.pet;
        }

        public long getCount() {
            return this.count;
        }

        public String getEnterPetType() {
            return this.pet.getPetType();
        }
    }

    static class DogCatQueue {
        Queue<PetEnter> dogQ;
        Queue<PetEnter> catQ;
        long count;

        public DogCatQueue() {
            dogQ = new LinkedList<>();
            catQ = new LinkedList<>();
            count = 0;
        }

        public void add(Pet pet) {
            if (pet.getPetType().equals("dog")) {
                dogQ.add(new PetEnter(pet, count++));
            } else if (pet.getPetType().equals("cat")) {
                catQ.add(new PetEnter(pet, count++));
            } else {
                throw new RuntimeException("err, not dog or cat");
            }
        }

        public Pet pollAll() {
            if (!dogQ.isEmpty() && !catQ.isEmpty()) {
                if (dogQ.peek().getCount() < catQ.peek().getCount()) {
                    return dogQ.poll().getPet();
                } else {
                    return catQ.poll().getPet();
                }
            } else if (!dogQ.isEmpty()) {
                return dogQ.poll().getPet();
            } else if (!catQ.isEmpty()) {
                return catQ.poll().getPet();
            } else {
                throw new RuntimeException("err, queue is empty!");
            }
        }

        public Dog pollDog() {
            if (dogQ.isEmpty()) {
                throw new RuntimeException("Dog queue is empty!");
            }
            return (Dog) dogQ.poll().getPet();
        }

        public Cat pollCat() {
            if (catQ.isEmpty()) {
                throw new RuntimeException("Cat queue is empty!");
            }
            return (Cat) catQ.poll().getPet();
        }

        public boolean isEmpty() {
            return dogQ.isEmpty() && catQ.isEmpty();
        }

        public boolean isDogEmpty() {
            return dogQ.isEmpty();
        }

        public boolean isCatEmpty() {
            return catQ.isEmpty();
        }
    }
}
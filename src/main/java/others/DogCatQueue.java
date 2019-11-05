package others;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗队列
 * 简单概括，按顺序存，按顺序取，也能按类取。
 * @author yitl
 *
 */
public class DogCatQueue {

	/**
	 * cat和dog的父类 
	 * @author yitl
	 */
	public static class Pet{
		private String type;
		public Pet(String type) {
			this.type = type;
		}
		public String getPetType() {
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
	 * pet的加强类，增加了count属性，用来记录进入队列的次序。 
	 * @author yitl
	 */
	public static class PetEnterQueue {
		private Pet pet;
		private long count;
		
		public PetEnterQueue(Pet pet, long count) {
			this.pet = pet;
			this.count = count;
		}

		public Pet getPet() {
			return pet;
		}

		public long getCount() {
			return count;
		}
		
		public String getEnterType() {
			return this.pet.getPetType();
		}
		
	}
	
	public static class CatDogQueue {
		private Queue<PetEnterQueue> dogQ;
		private Queue<PetEnterQueue> catQ;
		private long count;
		
		public CatDogQueue() {
			this.dogQ = new LinkedList<PetEnterQueue>();
			this.catQ = new LinkedList<PetEnterQueue>();
			this.count = 0;
		}
		
		public void add(Pet pet) {
			if(pet.getPetType().equals("cat")) {
				this.catQ.add(new PetEnterQueue(pet, count++));
			}else if(pet.getPetType().equals("dog")) {
				this.dogQ.add(new PetEnterQueue(pet, count++));
			}else {
				throw new RuntimeException("not dog or cat!!");
			}
		}
		
		public Pet pollAll() {
			if(!this.dogQ.isEmpty()&&!this.catQ.isEmpty()) {
				if(this.dogQ.peek().getCount() > this.catQ.peek().getCount()) {
					return this.dogQ.poll().getPet();
				}else {
					return this.catQ.poll().getPet();
				}
			}else if(!this.dogQ.isEmpty()) {
				return this.dogQ.poll().getPet();
			}else if(!this.catQ.isEmpty()) {
				return this.catQ.poll().getPet();
			}else {
				throw new RuntimeException("queue is empty");
			}
		}
		
		public Pet pollCat() {
			if(!this.catQ.isEmpty()) {
				return this.catQ.poll().getPet();
			}else {
				throw new RuntimeException("cat queue is empty");
			}
		}
		
		public Pet pollDog() {
			if(!this.dogQ.isEmpty()) {
				return this.dogQ.poll().getPet();
			}else {
				throw new RuntimeException("dog queue is empty");
			}
		}
		
		public boolean isEmpty() {
			return this.catQ.isEmpty()&&this.dogQ.isEmpty();
		}
		
		public boolean isDogQueueEmpty() {
			return this.dogQ.isEmpty();
		}
		
		public boolean isCatQueueEmpty() {
			return this.catQ.isEmpty();
		}
	}
	
	public static void main(String[] args) {
		CatDogQueue test = new CatDogQueue();
		
		Dog dog1 = new Dog();
		Cat cat1 = new Cat();
		Dog dog2 = new Dog();
		Cat cat2 = new Cat();
		Dog dog3 = new Dog();
		Cat cat3 = new Cat();
		
		test.add(dog1);
		test.add(cat1);
		test.add(dog2);
		test.add(cat2);
		test.add(dog3);
		test.add(cat3);
		
		while(!test.isDogQueueEmpty()) {
			System.out.println(test.pollDog().getPetType());
		}
		while(!test.isCatQueueEmpty()) {
			System.out.println(test.pollCat().getPetType());
		}
	}
}

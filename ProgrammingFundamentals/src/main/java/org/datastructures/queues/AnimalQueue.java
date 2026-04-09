package org.datastructures.queues;

import java.util.LinkedList;

public class AnimalQueue {

    static abstract class Animal {
        private int order;
        protected String name;
        public Animal(String n) {
            name = n;
        }

        public abstract String name();

        public void setOrder(int ord) {
            order = ord;
        }

        public int getOrder() {
            return order;
        }

        public boolean isOlderThan(Animal a) {
            return this.order < a.getOrder();
        }
    }

    static class Cat extends Animal {
        public Cat(String n) {
            super(n);
        }

        public String name() {
            return "Cat: " + name;
        }
    }

    static class Dog extends Animal {
        public Dog(String n) {
            super(n);
        }

        public String name() {
            return "Dog: " + name;
        }
    }

    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order = 0;

    public void enqueue(Animal a){
        a.setOrder(order);
        order++;
        if(a instanceof Dog){
            dogs.addLast((Dog)a);
        }
        else if(a instanceof Cat){
            cats.addLast((Cat)a);
        }
    }

    public Animal dequeueAny(){
        if(dogs.isEmpty())return dequeueCats();
        else if(cats.isEmpty())return dequeueDogs();

        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if(dog.isOlderThan(cat)){
            return dogs.poll();
        }
        else{
            return cats.poll();
        }
    }

    public Animal peekAnimal(){
        if(dogs.isEmpty())return cats.peek();
        else if(cats.isEmpty())return dogs.peek();

        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if(dog.isOlderThan(cat)){
            return dogs.peek();
        }
        else{
            return cats.peek();
        }
    }

    public int size(){
        return dogs.size() + cats.size();
    }

    public Dog dequeueDogs(){
        return dogs.poll();
    }

    public Dog peekDogs(){
        return dogs.peek();
    }

    public Cat dequeueCats(){
        return cats.poll();
    }

    public Cat peekCats(){
        return cats.peek();
    }

    static void main() {
        AnimalQueue animals = new AnimalQueue();
        animals.enqueue(new Cat("Kiki"));
        animals.enqueue(new Cat("Kari"));
        animals.enqueue(new Dog("Beji"));
        animals.enqueue(new Cat("Reki"));
        animals.enqueue(new Dog("Dexter"));

        System.out.println(animals.dequeueAny().name());
        System.out.println(animals.dequeueDogs().name());
        System.out.println(animals.dequeueCats().name());
    }

}

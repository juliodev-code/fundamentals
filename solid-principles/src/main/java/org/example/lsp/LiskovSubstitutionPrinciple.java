package org.example.lsp;

/**
 * The Rule: Objects of a superclass should be replaceable with objects of its subclasses without breaking the application.
 * The Smell: A Penguin class inherits from Bird, but the fly() method throws an UnsupportedOperationException.
 * The Java Fix: If a subclass can’t do what the parent does, they shouldn't share that specific parent. Use more granular interfaces.
 */
public class LiskovSubstitutionPrinciple {

    //made a good abstraction for no find not implemented behaviors
    public static abstract class Bird {
        public abstract void makeSound();
    }

    public static abstract class FlyingBird extends Bird {
        public abstract void fly();
    }

    public static class Sparrow extends FlyingBird {
        @Override
        public void fly() {
            System.out.println("Sparrow flying high!");
        }

        @Override
        public void makeSound() {
            System.out.println("Chirp!!!");
        }
    }

    public static class Penguin extends Bird {
        @Override
        public void makeSound() {
            System.out.println("Honk!");
        }
    }

    public static class BirdWatcher{
        public void observe(Bird bird){
            bird.makeSound();
        }

        public void makeItFly(FlyingBird bird){
            bird.fly();
        }
    }

    static void main() {
        BirdWatcher watcher = new BirdWatcher();
        watcher.observe(new Sparrow());
        watcher.observe(new Penguin());

        watcher.makeItFly(new Sparrow());
        //A PENGUIN CAN NOT FLY, EXCEPTION
        //watcher.makeItFly(new Penguin());
    }
}

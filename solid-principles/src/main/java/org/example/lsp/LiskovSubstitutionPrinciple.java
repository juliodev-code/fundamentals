package org.example.lsp;

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

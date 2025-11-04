package org.example.creational.singleton;

public class ThreadSafeSingleton {

    private static volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){
        System.out.println("Singleton created by " + Thread.currentThread().getName());
    }

    public static ThreadSafeSingleton getInstance(){
        if(instance == null){
            synchronized (ThreadSafeSingleton.class){
                if(instance == null){
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    static void main() throws InterruptedException {
        Runnable task = () -> {
            ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + " -> " + singleton.hashCode());
        };

        //Launched multiple threads
        Thread[] threads = new Thread[10];
        for(int i = 0; i < threads.length; i++){
            threads[i] = new Thread(task, "Thread-" + i);
            threads[i].start();
        }

        //wait for all threads
        for(Thread t : threads){
            t.join();
        }
    }
}

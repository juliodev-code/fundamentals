package org.example.creational.singleton;

public class Singleton {

    //We create the static resource for be instantiated once
    private static Singleton instance;

    //we create the "private constructor" for control the instantiation
    private Singleton(){
        System.out.println("Singleton Instance created");
    }

    //we create the "accessor" method to access the resource
    public static Singleton getInstance(){
        if(instance == null) instance = new Singleton();
        return instance;
    }

    //Example method
    public void showMessage(){
        System.out.println("Hello from singleton");
    }

    static void main() {
        //client
        Singleton object1 = Singleton.getInstance();
        Singleton object2 = Singleton.getInstance();

        object1.showMessage();
        object2.showMessage();

        //we test if the instance is the same
        System.out.println("Is same instance?:" + (object1 == object2));

    }

}

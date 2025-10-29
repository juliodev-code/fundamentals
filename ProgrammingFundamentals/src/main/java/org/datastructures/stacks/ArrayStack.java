package org.datastructures.stacks;

import java.util.EmptyStackException;

public class ArrayStack<T> {
    private T[] stackArray;
    private int top; //index of the top element
    private static final int DEFAULT_CAPACITY = 10;

    //Default constructor using the default capacity
    @SuppressWarnings("unchecked")
    public ArrayStack(){
        this.stackArray = (T[]) new Object[DEFAULT_CAPACITY];
        this.top = -1;
    }

    //Constructor specific capacity
    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity){
        this.stackArray = (T[])new Object[capacity];
        this.top = -1;
    }

    /**
     * Pushes an element onto the top of the stack.
     */
    public void push(T element){
        //checking is the array is full
        if(top == this.stackArray.length - 1){
            resize();
        }
        //we increment the top value and assign the stack
        this.stackArray[++this.top] = element;

    }

    /**
     * Removes and returns the element at the top of the stack.
     * Throws an exception if the stack is empty.
     */
    public T pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        //decrements top and return the element
        T element = this.stackArray[top];
        this.stackArray[this.top--] = null;
        return element;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     */
    public T peek(){
        if(isEmpty()) throw new EmptyStackException();
        return this.stackArray[this.top];
    }

    /**
     * Checks if the stack is empty.
     */
    public boolean isEmpty(){
        return this.top == -1;
    }

    /**
     * Resizes the internal array to double its current capacity.
     */
    @SuppressWarnings("unchecked")
    private void resize(){
        int newCapacity = this.stackArray.length * 2;
        T[] newArray = (T[])new Object[newCapacity];

        //Copy all the new elements to the new array
        for(int i = 0; i < this.stackArray.length; i++){
            newArray[i] = this.stackArray[i];
        }
        this.stackArray = newArray;
    }
}

package org.datastructures.arraylists;

public class MyArrayList<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList(){
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    // add the element to the end
    public void add(T element){
        ensureCapacity();
        elements[size++] = element;
    }

    //Get element at index
    public T get(int index){
        checkIndex(index);
        return (T) elements[index];
    }

    //set element at index
    public void set(int index, T value){
        checkIndex(index);
        elements[index] = value;
    }

    // Remove element by index
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null; // Avoid memory leak
    }

    // Return size
    public int size() {
        return size;
    }

    // Check if list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Increase capacity if full
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            Object[] newArray = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = elements[i];
            }
            elements = newArray;
        }
    }

    // Validate index
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
    }

    // Print contents (for debugging)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list); // [10, 20, 30]

        list.remove(1);
        System.out.println(list); // [10, 30]

        list.set(1, 99);
        System.out.println(list.get(1)); // 99

        System.out.println("Size: " + list.size()); // 2
    }


}

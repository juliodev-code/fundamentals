package org.datastructures.hashtable;

import java.util.LinkedList;

public class MyHashTable<K, V> {

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry<K, V>>[] buckets;
    private int capacity;

    @SuppressWarnings("unchecked")
    public MyHashTable(int capacity) {
        this.capacity = capacity;
        buckets = new LinkedList[capacity];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        // check if key already exists
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // update existing value
                return;
            }
        }

        buckets[index].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = hash(key);
        if (buckets[index] == null) return null;

        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        if (buckets[index] == null) return;
        buckets[index].removeIf(entry -> entry.key.equals(key));
    }

    public void printTable() {
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + ": ");
            if (buckets[i] != null) {
                for (Entry<K, V> entry : buckets[i]) {
                    System.out.print("[" + entry.key + "=" + entry.value + "] ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MyHashTable<String, Integer> table = new MyHashTable<>(5);

        table.put("John", 25);
        table.put("Emma", 30);
        table.put("Lucas", 35);
        table.put("Bob", 22); // likely collides with Emma

        table.printTable();

        System.out.println("Value for Emma: " + table.get("Emma"));
        System.out.println("Value for Bob: " + table.get("Bob"));
    }







}

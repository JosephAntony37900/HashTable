package main.java.hashtable;


import java.util.LinkedList;

public class HashTable {
    private LinkedList<Business>[] table;
    private int size;

    public HashTable(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunction1(String key) {
        return Math.abs(key.hashCode() % size);
    }

    private int hashFunction2(String key) {
        return Math.abs(key.hashCode()) % size;
    }

    public void insert(Business business, boolean useHashFunction1) {
        int index = useHashFunction1 ? hashFunction1(business.getId()) : hashFunction2(business.getId());
        table[index].add(business);
    }

    public Business get(String id, boolean useHashFunction1) {
        int index = useHashFunction1 ? hashFunction1(id) : hashFunction2(id);
        for (Business business : table[index]) {
            if (business.getId().equals(id)) {
                return business;
            }
        }
        return null;
    }
}

package com.boatrain;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        for (int i = 0; i < 12; i++) {
            map.put(i,i);
        }
        map.put(111,11);
    }
}

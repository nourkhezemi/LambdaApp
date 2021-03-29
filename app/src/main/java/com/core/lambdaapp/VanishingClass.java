package com.core.lambdaapp;

import java.util.HashMap;

public class VanishingClass {
    private HashMap<String, Integer> vanishingHashMap;

    public VanishingClass() {
        vanishingHashMap = new HashMap<String, Integer>();
        for (int i=0; i<50; i++) {
            vanishingHashMap.put(String.valueOf(i), i);
        }
    }
}

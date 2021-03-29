package com.core.lambdaapp;

import android.os.Handler;
import android.util.Log;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

import java.util.HashMap;
import java.util.Random;

public class StructuresManager {
    private HashMap<String, Integer> littleHashMap;
    private HashMap<String, Integer> bigHashMap;
    private SimpleArrayMap<String, Integer> littleSimpleArrayMap;
    private SimpleArrayMap<String, Integer> bigSimpleArrayMap;
    private ArrayMap<String, Integer> littleArrayMap;
    private ArrayMap<String, Integer> bigArrayMap;
    private HashMap<String, Integer> randomHashMap;
    private ArrayMap<String, Integer> randomArrayMap;

    private int randomArrayMapSize, randomHashMapSize;

    private VanishingClass vanishingclass;

    public StructuresManager() {
        littleHashMap = new HashMap<String, Integer>();
        bigHashMap = new HashMap<String, Integer>();
        littleArrayMap = new ArrayMap<String, Integer>();
        bigArrayMap = new ArrayMap<String, Integer>();
        littleSimpleArrayMap = new SimpleArrayMap<String, Integer>();
        bigSimpleArrayMap = new SimpleArrayMap<String, Integer>();
        randomArrayMap = new ArrayMap<String, Integer>();
        randomHashMap = new HashMap<String, Integer>();
        vanishingclass = new VanishingClass();
        randomArrayMapSize=800;
        randomHashMapSize=800;
        initializeStructures();
    }


    private void initializeStructures() {

            for (int i=0; i<100; i++) {
                littleHashMap.put(String.valueOf(i), i);
                littleArrayMap.put(String.valueOf(i), i);
                littleSimpleArrayMap.put(String.valueOf(i), i);
            }

            for (int i=0; i<800; i++) {
                randomArrayMap.put(String.valueOf(i), i);
                randomHashMap.put(String.valueOf(i), i);
            }

            for (int i=0; i<1000; i++) {
                bigHashMap.put(String.valueOf(i), i);
                bigArrayMap.put(String.valueOf(i), i);
                bigSimpleArrayMap.put(String.valueOf(i), i);
            }

            for (int i=999; i>500; i--) {
                bigHashMap.remove(String.valueOf(i));
                bigArrayMap.remove(String.valueOf(i));
                bigSimpleArrayMap.remove(String.valueOf(i));
            }

            final Handler h = new Handler();
            h.postDelayed(new Runnable()
            {
                private long time = 0;

                @Override
                public void run()
                {
                    // do stuff then
                    // can call h again after work!
                    Random rand = new Random();
                    int result = rand.nextInt(3);
                    System.out.println("result : " + result);
                    if (result==0) {
                        System.out.println("Little remove");
                        if (randomArrayMapSize > 50) {
                            for (int i=randomArrayMapSize-1; i>randomArrayMapSize-50; i--) {
                                randomArrayMap.remove(String.valueOf(i));
                                randomHashMap.remove(String.valueOf(i));
                            }
                            randomArrayMapSize-=50;
                            randomHashMapSize-=50;
                        }
                    }
                    else if (result==1) {
                        System.out.println("Little add");
                        for (int i=randomArrayMapSize; i<randomArrayMapSize+50; i++) {
                            randomArrayMap.put(String.valueOf(i), i);
                            randomHashMap.put(String.valueOf(i), i);
                        }
                        randomArrayMapSize+=50;
                        randomHashMapSize+=50;
                    }
                    else if (result==2) {
                        System.out.println("Big add");
                        for (int i=randomArrayMapSize; i<randomArrayMapSize+250; i++) {
                            randomArrayMap.put(String.valueOf(i), i);
                            randomHashMap.put(String.valueOf(i), i);
                        }
                        randomArrayMapSize+=250;
                        randomHashMapSize+=250;
                    }
                    time += 5000;
                    Log.d("TimerExample", "Going for... " + time);
                    h.postDelayed(this, 5000);
                }
            }, 1000); // 1 second delay (takes millis)

            vanishingclass = null;
            System.out.println("Initialisations finies");
    }
}

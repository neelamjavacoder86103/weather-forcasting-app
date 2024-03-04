package com.weather.forecasting.app.common;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private LinkedHashMap<String, WeatherInfo> map;
    private final int CAPACITY;
    public LRUCache(int capacity)
    {
        CAPACITY = capacity;
        map = new LinkedHashMap<String, WeatherInfo>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest)
            {
                return size() > CAPACITY;
            }
        };
    }


    public WeatherInfo get(String key) {
        System.out.println("getting the value from cache based on  the key : " + key);
        return map.get(key);
    }

    public void set(String key, WeatherInfo value) {
         System.out.println("Setting the (key, " + "value) : (" + key + ", " + value + ")");
        map.put(key, value);
    }

    public boolean containsKey(String key){
        return map.containsKey(key);
    }
}

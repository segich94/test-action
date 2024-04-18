package org.example.collection;

import java.util.HashMap;
import java.util.Map;

public class CollectionMap {
    public <T> Map<T,Integer> countOfElement(T[] array){
        Map<T,Integer> result = new HashMap<>();

        for (T t : array) {
            if (result.containsKey(t)) {
                result.put(t, result.get(t) + 1);
            } else {
                result.put(t, 1);
            }
        }
        return result;
    }
}

package org.example.collection;



public class CollectionFilter {
    public static <T> T[] filter(T[] array, Filter filter){
        T[] result = (T[]) new Object[array.length];
        for (int i = 0;i < array.length; i++){
            result[i] = (T) filter.apply(array[i]);
        }
        return result;
    }
}

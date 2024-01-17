package org.example;

import java.lang.reflect.Array;

public class Utils {
    public static <T> T[] arrAdd(T[] arr, T o){
        // If array has empty slot
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == null){
                arr[i] = o;
                return arr;
            }
        }

        // Else if array is full
        T[] tmp = (T[]) Array.newInstance(arr.getClass().getComponentType(), arr.length+1);
        for (int i = 0; i < arr.length; i++){
            tmp[i] = arr[i];
        }
        tmp[arr.length] = o;
        return tmp;
    }

}

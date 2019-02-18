package com.zipcodewilmington.assessment1.part2;

import java.util.*;

/**
 * Created by leon on 2/16/18.
 */
public class ArrayUtils {
    /**
     * @param objectArray   an array of any type of Object
     * @param objectToCount any non-primitive value
     * @return the number of times the specified `value` occurs in the specified `objectArray`
     * Given an array of objects, named `objectArray`, and an object `objectToCount`, return the number of times the `objectToCount` appears in the `objectArray`
     */
    public static Integer getNumberOfOccurrences(Object[] objectArray, Object objectToCount) {
        Integer count = 0;
        for (Object obj : objectArray) {
            if (obj == objectToCount) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param objectArray    an array of any type of Object
     * @param objectToRemove a value to be removed from the `objectArray`
     * @return an array with identical content excluding the specified `objectToRemove`
     * Given an array of objects, name `objectArray`, and an object `objectToRemove`, return an array of objects with identical contents excluding `objectToRemove`
     */
    public static Object[] removeValue(Object[] objectArray, Object objectToRemove) {
        List<Integer> myNewArrayList = new ArrayList<Integer>();
        for (Object obj : objectArray) {
            if (obj != objectToRemove) {
                myNewArrayList.add((Integer) obj);
            }
        }
        Integer[] returnArray = myNewArrayList.toArray(new Integer[myNewArrayList.size()]);
        return returnArray;
    }

    /**
     * @param objectArray an array of any type of Object
     * @return the most frequently occurring object in the array
     * given an array of objects, named `objectArray` return the most frequently occuring object in the array
     */
    public static Object getMostCommon(Object[] objectArray) {
        Integer[] integerArray1 = Arrays.copyOf(objectArray, objectArray.length, Integer[].class);
        int count = 1, tempCount;
        int popular = integerArray1[0];
        int temp = 0;
        for(int i =0; i<(integerArray1.length-1); i++){
            temp = integerArray1[i];
            tempCount = 0;
            for(int j = 1; j< integerArray1.length;j++){
                if(temp == integerArray1[j]){
                    tempCount++;
                }
                if(tempCount>count){
                    popular = temp;
                    count = tempCount;
                }

            }
        }
        return popular;
    }


    /**
     * @param objectArray an array of any type of Object
     * @return the least frequently occurring object in the array
     * given an array of objects, named `objectArray` return the least frequently occuring object in the array
     */
    public static Object getLeastCommon(Object[] objectArray) {
        Integer[] myArray = Arrays.copyOf(objectArray, objectArray.length, Integer[].class);
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(int i = 0; i < myArray.length; i++)
        {
            int key = myArray[i];
            if(count.containsKey(key))
            {
                int freq = count.get(key);
                freq++;
                count.put(key,freq);
            }
            else
                count.put(key,1);
        }
        //finding min frequency
        int min_count = myArray.length+1, res = -1;
        for(Map.Entry<Integer,Integer> val : count.entrySet())
        {
            if (min_count >= val.getValue())
            {
                res = val.getKey();
                min_count = val.getValue();
            }
        }

        return res;

    }

    /**
     * @param objectArray      an array of any type of Object
     * @param objectArrayToAdd an array of Objects to add to the first argument
     * @return an array containing all elements in `objectArray` and `objectArrayToAdd`
     * given two arrays `objectArray` and `objectArrayToAdd`, return an array containing all elements in `objectArray` and `objectArrayToAdd`
     */
    public static Object[] mergeArrays(Object[] objectArray, Object[] objectArrayToAdd) {
        Integer[] integerArray1 = Arrays.copyOf(objectArray, objectArray.length, Integer[].class);
        Integer[] integerArray2 = Arrays.copyOf(objectArrayToAdd, objectArrayToAdd.length, Integer[].class);
        List<Integer> myCombinedList = new ArrayList(Arrays.asList(integerArray1));
        myCombinedList.addAll(Arrays.asList(integerArray2));

        Integer[] returnArray = myCombinedList.toArray(new Integer[myCombinedList.size()]);
        return returnArray;
    }
}

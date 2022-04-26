package me.podrezov.search;

import java.util.*;
import java.util.stream.Collectors;

public class BinarySearch {
    public static int iteratively(int[] sortedArray, int key, int low, int high) {
        int index = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }

        return index;
    }

    public static int withArrays(int[] sortedArray, int key) {
        return Arrays.binarySearch(sortedArray, key);
    }

    public static int withCollections(int[] sortedArray, int key) {
        List<Integer> sortedList = Arrays.stream(sortedArray).boxed().collect(Collectors.toList());
        return Collections.binarySearch(sortedList, key);
    }

    public static int recursively(int[] sortedArray, int key, int low, int high) {
        int middle = (low + high) / 2;

        if (high < low) {
            return -1;
        }

        if (key == sortedArray[middle]) {
            return middle;
        } else if (key < sortedArray[middle]) {
            return recursively(sortedArray, key, low, middle - 1);
        } else {
            return recursively(sortedArray, key, middle + 1, high);
        }
    }
}
package com.jwetherell.algorithms.sorts;

import java.util.Random;

public class QuickSort<T extends Comparable<T>> {

    private static final Random RANDOM = new Random();

    public enum PivotType {
        FIRST, MIDDLE, RANDOM
    }

    private static PivotType pivotType = PivotType.RANDOM;

    private QuickSort() { }

    public static <T extends Comparable<T>> T[] sort(PivotType type, T[] array) {
        pivotType = type; // Set the pivot selection strategy
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1); // Recursively sort left partition
            quickSort(array, partitionIndex, high); // Recursively sort right partition
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        T pivot = selectPivot(array, low, high);
        int left = low;
        int right = high;

        while (left <= right) {
            while (array[left].compareTo(pivot) < 0) left++; // Find larger on left
            while (array[right].compareTo(pivot) > 0) right--; // Find smaller on right
            if (left <= right) {
                swap(array, left, right); // Swap out-of-place elements
                left++;
                right--;
            }
        }
        return left; // Return next partition index
    }

    private static <T extends Comparable<T>> T selectPivot(T[] array, int low, int high) {
        int pivotIndex;
        if (pivotType == PivotType.RANDOM) {
            pivotIndex = RANDOM.nextInt(high - low + 1) + low; // Random index
        } else if (pivotType == PivotType.MIDDLE) {
            pivotIndex = (low + high) / 2; // Middle index
        } else {
            pivotIndex = low; // First element
        }
        T pivot = array[pivotIndex];
        swap(array, pivotIndex, high); // Move pivot to end
        return pivot;
    }

    private static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
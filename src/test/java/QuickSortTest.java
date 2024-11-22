package com.jwetherell.algorithms.sorts.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.jwetherell.algorithms.sorts.QuickSort;

public class QuickSortTest {

    @Test
    public void testSortIntegersRandomPivot() {
        Integer[] unsorted = {12, 7, 19, 4, 8};
        Integer[] expected = {4, 7, 8, 12, 19};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortStringsMiddlePivot() {
        String[] unsorted = {"kiwi", "mango", "grape", "peach"};
        String[] expected = {"grape", "kiwi", "mango", "peach"};
        String[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.MIDDLE, unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortEmptyArray() {
        Integer[] unsorted = {};
        Integer[] expected = {};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortSingleElement() {
        Integer[] unsorted = {78};
        Integer[] expected = {78};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.FIRST, unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortAlreadySorted() {
        Integer[] unsorted = {3, 6, 9, 12, 15};
        Integer[] expected = {3, 6, 9, 12, 15};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.MIDDLE, unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortDescending() {
        Integer[] unsorted = {20, 15, 10, 5, 0};
        Integer[] expected = {0, 5, 10, 15, 20};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortArrayWithDuplicates() {
        Integer[] unsorted = {4, 9, 2, 4, 7, 9, 6};
        Integer[] expected = {2, 4, 4, 6, 7, 9, 9};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortArrayWithNegativeValues() {
        Integer[] unsorted = {-12, 8, -5, 10, -2};
        Integer[] expected = {-12, -5, -2, 8, 10};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortLargeArray() {
        Integer[] unsorted = new Integer[1000];
        for (int i = 0; i < 1000; i++) {
            unsorted[i] = (int) (Math.random() * 2000 - 1000); // Random values between -1000 and 999
        }
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, unsorted);
        // Test if the result is sorted
        for (int i = 1; i < result.length; i++) {
            assertTrue(result[i - 1] <= result[i]);
        }
    }
}
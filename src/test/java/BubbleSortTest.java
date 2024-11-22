package com.jwetherell.algorithms.sorts.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.jwetherell.algorithms.sorts.BubbleSort;

public class BubbleSortTest {

    @Test
    public void testSortIntegers() {
        Integer[] unsorted = {7, 1, 9, 6, 3};
        Integer[] expected = {1, 3, 6, 7, 9};
        Integer[] result = BubbleSort.sort(unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortStrings() {
        String[] unsorted = {"grape", "orange", "kiwi", "pear"};
        String[] expected = {"grape", "kiwi", "orange", "pear"};
        String[] result = BubbleSort.sort(unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortEmptyArray() {
        Integer[] unsorted = {};
        Integer[] expected = {};
        Integer[] result = BubbleSort.sort(unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortSingleElement() {
        Integer[] unsorted = {17};
        Integer[] expected = {17};
        Integer[] result = BubbleSort.sort(unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortAlreadySorted() {
        Integer[] unsorted = {2, 4, 6, 8, 10};
        Integer[] expected = {2, 4, 6, 8, 10};
        Integer[] result = BubbleSort.sort(unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortDescending() {
        Integer[] unsorted = {10, 8, 6, 4, 2};
        Integer[] expected = {2, 4, 6, 8, 10};
        Integer[] result = BubbleSort.sort(unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortArrayWithDuplicates() {
        Integer[] unsorted = {9, 3, 7, 9, 2, 7, 1};
        Integer[] expected = {1, 2, 3, 7, 7, 9, 9};
        Integer[] result = BubbleSort.sort(unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortArrayWithNegativeValues() {
        Integer[] unsorted = {-7, 3, -4, 6, -2};
        Integer[] expected = {-7, -4, -2, 3, 6};
        Integer[] result = BubbleSort.sort(unsorted);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortLargeArray() {
        Integer[] unsorted = new Integer[1000];
        for (int i = 0; i < 1000; i++) {
            unsorted[i] = (int) (Math.random() * 2000 - 1000); // Random values between -1000 and 999
        }
        Integer[] result = BubbleSort.sort(unsorted);
        // Test if the result is sorted
        for (int i = 1; i < result.length; i++) {
            assertTrue(result[i - 1] <= result[i]);
        }
    }
}
package org.example.DataStructure.ArrayAndString;

import org.junit.Test;

import java.util.Arrays;

public class TestDoublePointerTest {

    char[] s = new char[]{'a', 'b', 'c', 'd', 'e'};
    int[] arr = new int[]{11, 3, 1, 7, 5, 9};
    int[] arr2 = new int[]{1, 2, 5, 7, 8, 9};
    int[] arr3 = new int[]{2, 2, 5, 2, 8, 9};

    @Test
    public void reverseString() {
        TestDoublePointer.reverseString(s);
        for (char c : s) {
            System.out.println(c);
        }
    }

    @Test
    public void arrayPairSum() {
        System.out.println(TestDoublePointer.arrayPairSum(arr));
    }

    @Test
    public void twoSum() {
        int[] ints = TestDoublePointer.twoSum(arr2, 12);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void removeElement() {
        System.out.println(TestDoublePointer.removeElement(arr3, 2));
    }

    @Test
    public void findMaxConsecutiveOnes() {
//        int[] ints = {1, 0, 1, 1, 1, 0, 1, 1};
        int[] ints = {1,1,0,1,1,1};
        System.out.println(TestDoublePointer.findMaxConsecutiveOnes(ints));
    }

    @Test
    public void minSubArrayLen() {
        System.out.println(TestDoublePointer.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
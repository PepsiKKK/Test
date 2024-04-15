package org.example.DataStructure.ArrayAndString;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TestAllTest {

    private void printDouble(int[][] arr){
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
            System.out.println();
        }
    }
    @Test
    public void generate() {
        printDouble(TestAll.generate(0));
    }

    @Test
    public void generate2() {
        System.out.println(TestAll.generate2(6));
    }

    @Test
    public void getRow() {
        System.out.println(TestAll.generate2(4));
        System.out.println(TestAll.getRow(3));
    }

    @Test
    public void reverseWords() {
        System.out.println(TestAll.reverseWords("Let's take LeetCode contest"));
    }

    @Test
    public void findMin() {
        System.out.println(TestAll.findMin(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void removeDuplicates() {
    }

    @Test
    public void moveZeroes() {
        int[] arr = new int[]{4,2,4,0,0,3,0,5,1,0};
        TestAll.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
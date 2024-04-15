package org.example.DataStructure.ArrayAndString;

import org.example.DataStructure.ArrayAndString.TestArray;
import org.junit.Test;

public class TestArrayTest {

    @Test
    public void pivotIndex() {
//        int[] arr = {6, 5, 2, 1, 3, 4, 6};
//        int[] arr = {2, 1, -1};
        int[] arr = {-1, -1, -1, -1, -1, -1};
        System.out.println("中心下标为：" + TestArray.pivotIndex(arr));
    }

    @Test
    public void searchInsert() {
        int[] arr = {1, 3, 5, 7, 9};
        System.out.println(TestArray.searchInsert(arr, 6));
    }

    @Test
    public void merge() {
        int[][] arr = {{1,2}, {3,5},{6,7}};

    }
}